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

    @Column(unique = true, name = "title")
    @NotEmpty(message = "*Please provide the name of the agency")
    private String title;

    @Column(name = "address1")
    @NotEmpty(message = "*Please provide the address of the agency")
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
    private String zipcode;

    @Column(name = "phone")
    @NotEmpty(message= "*Please enter a phone number in this format XXX-XXX-XXXX")
    private String phone;

    @Column(name = "website")
    private String website;

    @Column(name = "additional_info")
    private String additional_info;
    

    public Agency() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
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

