package com.example.cheesemvn.models;

public class Cheese {
    private String name;
    private String description;
    private int cheeseId;
    public static int nextId;

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

    @Override
    public String toString() {
        return "Cheese{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cheeseId=" + cheeseId +
                '}';
    }


}
