package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by User on 13.06.2017.
 */
@Entity
public class Customer extends Model {
    @Id

    @Column
    public Long id;
    public String firstname;
    public String lastname;
    public String company;
    public String address;
    public  String email;
    public  String phone;

    public Customer(String firstname, String lastname, String company, String address, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", company='" + company + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static Finder<Long, Customer> find = new Finder<Long, Customer>(Customer.class);

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
