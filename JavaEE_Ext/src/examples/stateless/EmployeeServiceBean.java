package examples.stateless;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import examples.model.Employee;

@Stateless
public class EmployeeServiceBean implements EmployeeService {

    @PersistenceContext(unitName = "JPA_Lesson1")
    protected EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Employee createEmployee(final int addressId,
                                   final String name,
                                   final long salary) {
        final Employee emp = new Employee();
        emp.setName(name);
        emp.setSalary(salary);
        emp.setAddressId(addressId);
        this.em.persist(emp);

        return emp;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Collection<Employee> findAllEmployees() {
        final Query query = this.em.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }
}
