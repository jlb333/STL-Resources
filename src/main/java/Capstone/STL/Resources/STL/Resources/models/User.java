package Capstone.STL.Resources.STL.Resources.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true)
    @NotNull
    @Size(min = 3,max = 15, message="Username must be between 3 to 15 characters")
    private String username;

    @Column
    @NotNull
    @Size(min = 3, max = 15, message="Password must be between 3 to 15 characters")
    private String password;

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    //do I need a setter for user id?  Video:  Persisting Objects with JPA indicated id would not need a setter.
    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
