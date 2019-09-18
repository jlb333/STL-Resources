package Capstone.STL.Resources.STL.Resources.models;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "category_id")
    private int id;

    @Column(unique = true, name = "name")
    @NotEmpty(message = "*Please provide a category name")
    private String name;

    @ManyToMany
    private List<Agency> agencies;

    public Category(String name) {
        this.name = name;
    }

    public Category() {}

    public void addItem(Agency item) { agencies.add(item);}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Agency> getAgencies() {
        return agencies;
    }
}
