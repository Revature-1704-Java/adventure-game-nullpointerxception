package com.nullpointerxception.entities;

import java.util.ArrayList;

import com.nullpointerxception.assets.items.*;
import com.nullpointerxception.game.Game;

public class Mimic extends Enemy{

    public Mimic(){
        super("Mimic", 5, 1, 3, "Sharp teeth appear around the opening of a treasure chest. It tries to clamp onto you hand.");

    }

    public int attack(){
        System.out.println("Its sharp teeth bite down on you.");
        return generateDamage();
    }   

    public ArrayList<Item> dropLoot(){
        ArrayList<Item> loot = new ArrayList<Item>();
        double p = generator.nextDouble();
        if(p <= .5){
            Game.player.addGoldPieces(15);
        }else if(p > .5 && p <= .8){
            Game.player.addGoldPieces(20);
        }else if(p > .8 && p <= .95){
            loot.add(new Potion(1));
            Game.player.addGoldPieces(25);
        }else{
            loot.add(new Potion(2));
            Game.player.addGoldPieces(30);
        }

        return loot;

    }

}