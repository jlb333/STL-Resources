package Capstone.STL.Resources.STL.Resources.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(unique = true, name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide a valid Email")
    @Size(min = 3,max = 30, message = "*Email must be between 3 to 30 characters")
    private String email;

    @Column(name = "password")
    @NotEmpty(message = "*Please provide your password")
    @Size(min = 6, message="*Password must be at least 6 characters")
    private String password;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide your first name")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "*Please provide your last name")
    private String lastName;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
