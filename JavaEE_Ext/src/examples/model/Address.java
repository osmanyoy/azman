package examples.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long   id;
    private String addressStr;

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getAddressStr() {
        return this.addressStr;
    }

    public void setAddressStr(final String addressStr) {
        this.addressStr = addressStr;
    }

}
