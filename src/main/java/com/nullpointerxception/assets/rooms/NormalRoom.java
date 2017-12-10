package com.nullpointerxception.assets.rooms;

import java.util.ArrayList;

import com.nullpointerxception.assets.items.*;
import com.nullpointerxception.game.Game;

public class NormalRoom extends Room{

    public NormalRoom(){
        super("Normal Room", "You've entered a dungeon room.");
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
        }else{
            loot.add(new Potion(2));
        }

        return loot;
    }

}