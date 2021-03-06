package com.example.cheesemvn.models;


import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Cheese {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15, message = "")
    @Pattern(regexp="[a-zA-Z][a-zA-Z ]+[a-zA-Z]${3,15}", message = "only letters with spaces between them allowed(3-15).")
    private String name;

    @NotNull
    @Size(min=1, message = "can not be empty.")
    private String description;

    @ManyToOne
    private Category category;

//    private CheeseRate rate;

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Cheese(){ }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//    public CheeseRate getRate() {
//        return rate;
//    }

//    public void setRate(CheeseRate rate) {
//        this.rate = rate;
//    }


}
