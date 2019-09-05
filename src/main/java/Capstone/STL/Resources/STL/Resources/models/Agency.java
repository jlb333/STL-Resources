package Capstone.STL.Resources.STL.Resources.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="agency")
public class Agency {


    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "agency_id")
    private int id;

    @Column(unique = true, name = "agency")
    @NotEmpty(message = "*Please provide the name of the agency")
    @Size(min = 1,max = 30, message="*Please provide the name of the agency")
    private String agency;

    @Column(name = "address1")
    @NotEmpty(message = "*Please provide the address of the agency")
    @Size(min = 6, message="*Please provide the address of the agency")
    private String address1;

    @Column(name = "city")
    @NotEmpty(message = "*Please provide the city the agency is located in")
    private String city;

    @Column(name = "state")
    @NotEmpty(message = "*Please provide the state the agency is located in")
    private String state;

    @Column(name = "zipcode")
    @NotEmpty(message= "*Please provide the zip code")
    @Size(max = 5, message="*Please enter 5 digit zip code")
    private int zipcode;

    @Column(name = "phone")
    @NotEmpty(message= "*Please enter a phone number in this format XXX-XXX-XXXX")
    private String phone;

    @Column(name = "website")
    private String website;

    @Column(name = "additional_info")
    private String additional_info;

    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
*/

    public Agency() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }
}

