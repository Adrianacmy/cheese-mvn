package com.example.cheesemvn.models;

public enum  CheeseRate {
    ONE ("*"),
    TWO ("**"),
    THREE ("***"),
    FOUR ("****"),
    FIVE("*****");

    private  String name = "5";

    CheeseRate(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
