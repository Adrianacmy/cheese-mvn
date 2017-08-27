package com.example.cheesemvn.models.forms;


import com.example.cheesemvn.models.Cheese;
import com.example.cheesemvn.models.Menu;

import javax.validation.constraints.NotNull;

public class AddMenuItemForm {


    @NotNull
    private int menuId;

    @NotNull
    private int cheeseId;

    private Menu menu;

    private Iterable<Cheese> cheeses;

    public AddMenuItemForm(){}

    public AddMenuItemForm(Iterable<Cheese> cheeses, Menu menu){

        this.cheeses = cheeses;
        this.menu = menu;
    }
    public int getMenuId() {return menuId;}

    public void setMenuId(int menuId){ this.menuId = menuId;}

    public int getCheeseId() { return cheeseId;}

    public void setCheeseId(int cheeseId) {this.cheeseId = cheeseId;}

    public Iterable<Cheese> getCheeses() { return  cheeses;}

    public Menu getMenu() { return menu;}
}