package examples.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int    id;
    @Column(name = "EMP_NAME")
    private String name;
    private long   salary;
    private int    addressId;

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public long getSalary() {
        return this.salary;
    }

    public void setSalary(final long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee id: " + this.getId() + " name: " + this.getName() + " salary: " + this.getSalary();
    }

    public int getAddressId() {
        return this.addressId;
    }

    public void setAddressId(final int addressId) {
        this.addressId = addressId;
    }
}
