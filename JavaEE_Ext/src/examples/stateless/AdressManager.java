package examples.stateless;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import examples.model.Address;

/**
 * Session Bean implementation class AdressManager
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class AdressManager {

    @PersistenceContext(unitName = "JPA_Lesson1")
    protected EntityManager em;


    public AdressManager() {
        // TODO Auto-generated constructor stub
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Address createAddress(final String adresStr) {
        this.em.getTransaction().begin();
        final Address address = new Address();
        address.setAddressStr(adresStr);
        this.em.persist(address);
        return address;
    }

}
