package com.nullpointerxception.assets.items;

import com.nullpointerxception.entities.*;

public abstract class Item{

    private String name;
    private String description;
    private int amount;

    public Item(String name, String description, int amount){
        this.name = name;
        this.description = description;
        this.amount = amount;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getAmount(){
        return amount;
    }

    public abstract void use(Player player, Entity enemy);
}