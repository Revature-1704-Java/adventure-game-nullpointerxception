package com.nullpointerxception.assets.items;

import com.nullpointerxception.entities.*;

public class LesserPotionOfStrength extends Item{

    public LesserPotionOfStrength(int amount){
        super("LESSER POTION OF STRENGTH", "A potion of strength that will temporarily increase attack by 2 for the current room. Stacks." , amount);
    }

    public void use(Player player, Entity enemy){
        player.setTempLowAtk(2);
        player.setTempHighAtk(2);
    }

    public String toString(){
        return "Lesser Potion of Strength";
    }

}