package com.nullpointerxception.assets.items;

import com.nullpointerxception.entities.*;

public class Potion extends Item{

    public Potion(int amount){
        super("POTION", "A bottle of magic liquid that heals 5 health to whoever drinks it.", amount);
    }
    
    public void use(Player player, Entity enemy){
        player.setHealth(player.getHealth() + 5);
    }

    public String toString(){
        return "Potion";
    }

}