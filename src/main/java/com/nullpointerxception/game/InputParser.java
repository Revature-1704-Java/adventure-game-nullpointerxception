package com.nullpointerxception.game;

import java.util.Arrays;


import com.nullpointerxception.exceptions.InvalidCommandFormatException;
import static com.nullpointerxception.game.Game.*;

public class InputParser{

    // public static void parseCommand(String input){


    //     if(input.equals("Help") || input.equals("H")){
    //         System.out.println("CONTINUE | C: Move to the next room. The room must be clear in order for you to move on.");
    //         System.out.println("VIEW INVENTORY | I: View what is in your inventory and the amount of each item you have.");
    //         System.out.println("VIEW STATS | P: View you player's stats.");
    //         System.out.println("ATTACK | A: Attack using your currently equiped weapon.");
    //         System.out.println("USE | S: Use an item.");
    //         System.out.println("RUN | D: You attempt to skip the current room.");
    //         System.out.println("HELP: Brings up the commands you can use.");
    //     }else if(input.equals("CONTINUE") || input.equals("C")){
    //         if(enemy != null){
    //             System.out.println("The monster blocks your path.");
    //         }else{
    //             System.out.println("You got some loot for clearing this room.");
    //             player.addInventory(currentRoom.dropLoot());
    //             player.resetTempAtk();
    //             currentRoom = roomFactory.generateRoom();
    //             System.out.println(currentRoom.getDescription());
    //             enemy = enemyFactory.generateEnemy();
    //             System.out.println(enemy.getDescription()); 
    //         }
    //     }

    // }

    public static String parseUse(String input) throws InvalidCommandFormatException{
        String[] inputArray = input.split(" ");
        if(!isValidUse(inputArray)){
            throw new InvalidCommandFormatException();
        }

        String[] items = Arrays.copyOfRange(inputArray, 1, inputArray.length - 1);
        
        return String.join(" ", items);
        


    }

    private static boolean isValidUse(String[] inputArray){
        
        if(inputArray.length < 3){
            return false;
        }
        if(!inputArray[0].equals("USE") && !inputArray[0].equals("S")){
            return false;
        }

        if(!isNumeric(inputArray[inputArray.length - 1])){
            
            return false;
        }

       return true;

    }

    private static boolean isNumeric(final CharSequence cs){
        if(cs.length() == 0){
            return false;
        }
        final int sz = cs.length();
        for(int i = 0; i < sz; i++){
            if(!Character.isDigit(cs.charAt(i))){
                return false;
            }
        }
        return true;
    }



}