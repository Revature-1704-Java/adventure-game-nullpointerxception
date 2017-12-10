package com.nullpointerxception.assets.rooms;

import java.util.ArrayList;

import com.nullpointerxception.assets.items.*;
import com.nullpointerxception.game.Game;

public class TreasureRoom extends Room{

    public TreasureRoom(){
        super("Treasure Room", "You've entered a Treasure room.");
    }

    public ArrayList<Item> dropLoot(){
        ArrayList<Item> loot = new ArrayList<Item>();
        double p = generator.nextDouble();
        if(p <= .5){
            Game.player.addGoldPieces(25);
        }else if(p > .5 && p <= .8){
            Game.player.addGoldPieces(50);
        }else if(p > .8 && p <= .95){
            Game.player.addGoldPieces(75);
        }else{
            Game.player.addGoldPieces(100);
        }

        return loot;
    }

}