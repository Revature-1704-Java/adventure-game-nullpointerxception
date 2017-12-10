package com.nullpointerxception.entities;

import com.nullpointerxception.assets.items.*;
import java.util.ArrayList;

public abstract class Enemy extends Entity{

    public Enemy(String name, int health, int lowAtk, int highAtk, String description){
        super(name, health, lowAtk, highAtk, description);
    }
    //If you are an enemy, then you should be able to drop loot.
    public abstract ArrayList<Item> dropLoot();

}