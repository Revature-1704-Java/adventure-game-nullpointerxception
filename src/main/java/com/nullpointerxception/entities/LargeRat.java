package com.nullpointerxception.entities;

import java.util.ArrayList;

import com.nullpointerxception.assets.items.*;
import com.nullpointerxception.game.Game;

public class LargeRat extends Enemy{

    public LargeRat(){
        super("Large Rat", 3, 1, 3, "A Large Rat appears before you.");
    }

    public int attack(){
        System.out.println("The Large Rat lunges towards you with it's sharp teeth.");
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