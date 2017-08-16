package com.example.cheesemvn.models;

import java.util.ArrayList;

public class CheeseData {
    static ArrayList<Cheese> cheeses = new ArrayList<>();

    //list
    public static ArrayList<Cheese> getAll(){
        return cheeses;
    }

    //add
    public static void add(Cheese newCheese){
        cheeses.add(newCheese);
    }


    //remove
    public  static void remove(int id){
        cheeses.remove(getById(id));
    }

    //update
    public static void update(int id, String name, String description){
        Cheese cheeseToUpdate = getById(id);
        cheeseToUpdate.setName(name);
        cheeseToUpdate.setDescription(description);
    }

    //getById
    public static Cheese getById(int id){
        Cheese theCheese = null;
        for(Cheese candidateCheese : cheeses){
            if(candidateCheese.getCheeseId() == id){
                theCheese = candidateCheese;
            }
        }
        return theCheese;
    }

}
