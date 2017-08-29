package com.example.cheesemvn.models;

import java.util.ArrayList;

public class UserData {
    static ArrayList<User> users = new ArrayList<>();

    //list
    public static ArrayList<User> getAll(){
        return users;
    }

    //add
    public static void add(User newUser){
        users.add(newUser);
    }



    //remove
    public  static void remove(int id){
        users.remove(getById(id));
    }

//    //update
//    public static void update(int id, String name, String description){
//        Cheese cheeseToUpdate = getById(id);
//        cheeseToUpdate.setName(name);
//        cheeseToUpdate.setDescription(description);
//    }

    //getById
    public static User getById(int id){
        User theUser = null;
        for(User candidate : users){
            if(candidate.getUserId() == id){
                theUser = candidate;
            }
        }
        return theUser;
    }

}
