package com.example.cheesemvn.models;

import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Cheese {
//    @NotNull
//    @Size(min=3, max=15)
    @Pattern(regexp="[a-zA-Z][a-zA-Z ]+[a-zA-Z]${3,15}", message = "only letters and spaces between them allowed(3-15).")
    private String name;

    @NotNull
    @Size(min=1, message = "can not be empty.")
    private String description;
    private int cheeseId;
    public static int nextId;

    private CheeseType type;

    private CheeseRate rate;

    public Cheese(String name, String description) {
        this();
        this.name = name;
        this.description = description;
        this.cheeseId = cheeseId;
    }

    public Cheese(){
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() {
        return cheeseId;
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

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }

    public CheeseRate getRate() {
        return rate;
    }

    public void setRate(CheeseRate rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cheeseId=" + cheeseId +
                '}';
    }


}
