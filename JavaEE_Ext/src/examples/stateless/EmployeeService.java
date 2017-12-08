package examples.stateless;

import java.util.Collection;

import javax.ejb.Local;

import examples.model.Employee;

@Local
public interface EmployeeService {
    public Employee createEmployee(int addressId,
                                   String name,
                                   long salary);

    public Collection<Employee> findAllEmployees();
}
