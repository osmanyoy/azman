package examples.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.model.Employee;
import examples.stateless.EmployeeService;

@WebServlet(name = "EmployeeServlet", urlPatterns = { "/es", "/call" })
public class EmployeeServlet extends HttpServlet {

    private static final long serialVersionUID = 1044263119589850875L;

    private final String      TITLE            = "Field Access Example";

    private final String      DESCRIPTION      = "This example demonstrates how to specify field access for entities.</br> "
                                                 + "It allows you to create/find employees. All operations "
                                                 + "are persisted to the database.";


    // inject a reference to the EmployeeService slsb
    @EJB
    EmployeeService           service;

    @Override
    public void doPost(final HttpServletRequest request,
                       final HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        this.printHtmlHeader(out);

        // process request
        String action = request.getParameter("action");
        if (action == null) {
            // do nothing if no action requested
        } else if (action.equals("Create")) {
            Employee emp = this.service.createEmployee(this.parseInt(request.getParameter("id")),
                                                       request.getParameter("name"),
                                                       this.parseLong(request.getParameter("salary")));
            out.println("Created " + emp);
        } else if (action.equals("FindAll")) {
            Collection<Employee> emps = this.service.findAllEmployees();
            if (emps.isEmpty()) {
                out.println("No Employees found ");
            } else {
                out.println("Found Employees: </br>");
                for (Employee emp : emps) {
                    out.println(emp + "<br/>");
                }
            }
        }

        this.printHtmlFooter(out);
    }

    @Override
    public void doGet(final HttpServletRequest request,
                      final HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    private int parseInt(final String intString) {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private long parseLong(final String longString) {
        try {
            return Long.parseLong(longString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void printHtmlHeader(final PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
        out.println("<head><title>" + this.TITLE + "</title></head>");
        out.println("<center><h1>" + this.TITLE + "</h1></center>");
        out.println("<p>" + this.DESCRIPTION + "</p>");
        out.println("<hr/>");
        out.println("<form action=\"es\" method=\"POST\">");
        // form to create and Employee and Address
        out.println("<h3>Create an Employee</h3>");
        out.println("<table><tbody>");
        out.println("<tr><td>Employee Id:</td><td><input type=\"text\" name=\"id\"/>(int)</td></tr>");
        out.println("<tr><td>Employee Name:</td><td><input type=\"text\" name=\"name\"/>(String)</td></tr>");
        out.println("<tr><td>Employee Salary:</td><td><input type=\"text\" name=\"salary\"/>(long)</td></tr>");
        out.println("<td><input name=\"action\" type=\"submit\" value=\"Create\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<hr/>");
        // form to find all
        out.println("<h3>Find all Employees</h3>");
        out.println("<input name=\"action\" type=\"submit\" value=\"FindAll\"/>");
        out.println("</form>");
        out.println("<hr/>");
    }


    private void printHtmlFooter(final PrintWriter out) throws IOException {
        out.println("</html>");
        out.println("</body>");
        out.close();
    }
}
