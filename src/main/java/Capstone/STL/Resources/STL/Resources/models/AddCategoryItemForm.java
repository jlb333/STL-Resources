package Capstone.STL.Resources.STL.Resources.models;

import javax.validation.constraints.NotNull;

public class AddCategoryItemForm {

    @NotNull
    private int categoryId;

    @NotNull
    private int agencyId;

    private Category category;

    private Iterable<Agency> agencies;

    public AddCategoryItemForm() {}

    public AddCategoryItemForm(Iterable<Agency> agencies, Category category) {
        this.agencies = agencies;
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public Category getCategory() {
        return category;
    }

    public Iterable<Agency> getAgencies() {
        return agencies;
    }


}
