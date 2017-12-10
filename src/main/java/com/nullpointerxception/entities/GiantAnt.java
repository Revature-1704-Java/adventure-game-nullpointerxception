package com.nullpointerxception.entities;

import java.util.ArrayList;

import com.nullpointerxception.assets.items.*;
import com.nullpointerxception.game.Game;

public class GiantAnt extends Enemy{

    public GiantAnt(){
        super("Giant Ant", 10, 2, 4, "A giant ant burrows out from the ground and branshes it's sharp pincer.");
    }

    public int attack(){
        System.out.println("It launches a vicious tearing atack with its large pincers.");
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