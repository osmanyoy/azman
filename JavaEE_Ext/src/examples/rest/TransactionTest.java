package examples.rest;

import java.util.Properties;

import javax.annotation.Resource;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.batch.runtime.JobExecution;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import examples.model.Address;
import examples.model.Employee;
import examples.stateless.Manager;

@Path("/t")
public class TransactionTest {

    @Resource
    private UserTransaction transaction;

    @PersistenceContext(unitName = "JPA_Lesson1")
    protected EntityManager em;

    @EJB
    private Manager         manager;

    @Path("/aa/{a}/{n}/{s}")
    @GET
    public String addAll(@PathParam("a") final String address,
                         @PathParam("n") final String name,
                         @PathParam("s") final long sal) {

        this.manager.addAll(address,
                            name,
                            sal);
        return "ok";
    }

    @Path("/bb/{a}/{n}/{s}")
    @GET
    //@Transactional(value = TxType.REQUIRES_NEW)
    public String addAll2(@PathParam("a") final String address,
                          @PathParam("n") final String name,
                          @PathParam("s") final long sal) {
        try {
            // final EntityTransaction transaction2 = this.em.getTransaction();
            //transaction2.begin();
            // this.transaction.begin();
            final Address address1 = new Address();
            address1.setAddressStr(address);
            this.em.persist(address1);

            final Employee emp = new Employee();
            emp.setName(name);
            emp.setSalary(sal);
            emp.setAddressId((int) address1.getId());
            this.em.persist(emp);

            // this.transaction.commit();
            // transaction2.commit();

        } catch (final Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }

    @GET
    public String hello() {
        final JobOperator jobOperator = BatchRuntime.getJobOperator();
        final Long executionId = jobOperator.start("myJob",
                                                   new Properties());
        final JobExecution jobExecution = jobOperator.getJobExecution(executionId);
        jobExecution.getBatchStatus();

        final JobOperator jobOperator2 = BatchRuntime.getJobOperator();
        final Long executionId2 = jobOperator.start("jobListenerExample",
                                                    new Properties());

        return "" + executionId2;
    }
}
