package examples.stateless;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;

import examples.model.Address;

/**
 * Session Bean implementation class Manager
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class Manager {

    @EJB
    private AdressManager   adressManager;

    @EJB
    private EmployeeService employeeServiceBean;

    @Resource
    private UserTransaction transaction;

    /**
     * Default constructor.
     */
    public Manager() {
    }

    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void addAll(final String address,
                       final String name,
                       final long sal) {
        try {
            this.transaction.begin();
            final Address createAddress = this.adressManager.createAddress(address);
            this.employeeServiceBean.createEmployee((int) createAddress.getId(),
                                                    name,
                                                    sal);
            this.transaction.rollback();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

}
