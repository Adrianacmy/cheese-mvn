package com.example.cheesemvn.models;

public enum  CheeseRate {
    ONE ("1"),
    TWO ("2"),
    THREE ("3"),
    FOUR ("4"),
    FIVE("5");

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
