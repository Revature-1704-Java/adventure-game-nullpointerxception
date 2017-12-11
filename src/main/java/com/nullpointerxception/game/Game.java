package com.nullpointerxception.game;

import java.util.Scanner;

import com.nullpointerxception.assets.items.*;
import com.nullpointerxception.assets.rooms.*;
import com.nullpointerxception.entities.*;
import com.nullpointerxception.exceptions.InvalidCommandFormatException;

public class Game{
    
    static Room currentRoom;
    public static Player player;
    public static Enemy enemy;
    static RoomFactory roomFactory;
    static EnemyFactory enemyFactory;
    static Scanner scanner;

    public static void main(String[] args){

        init();

        while(player.getHealth() > 0){

            String input = scanner.nextLine().toUpperCase();

            if(input.equals("HELP") || input.equals("H")){
                System.out.println("CONTINUE | C: Move to the next room. The room must be clear in order for you to move on.");
                System.out.println("VIEW INVENTORY | I: View what is in your inventory and the amount of each item you have.");
                System.out.println("VIEW STATS | P: View you player's stats.");
                System.out.println("ATTACK | A: Attack using your currently equiped weapon.");
                System.out.println("USE | S: Use an item.");
                System.out.println("RUN | D: You attempt to skip the current room.");
                System.out.println("HELP | H: Brings up the commands you can use.");
            }else if(input.equals("CONTINUE") || input.equals("C")){
                if(enemy != null){
                    System.out.println("The monster blocks your path.");
                }else{
                    if(!(currentRoom instanceof StartingRoom)){
                        System.out.println("You got some loot for clearing this room.");
                        player.addInventory(currentRoom.dropLoot());
                        player.resetTempAtk();
                        currentRoom = roomFactory.generateRoom();
                        System.out.println(currentRoom.getDescription());
                        enemy = enemyFactory.generateEnemy();
                        System.out.println(enemy.getDescription()); 
                    }else{
                        
                        player.addInventory(currentRoom.dropLoot());
                        player.resetTempAtk();
                        currentRoom = roomFactory.generateRoom();
                        System.out.println(currentRoom.getDescription());
                        enemy = enemyFactory.generateEnemy();
                        System.out.println(enemy.getDescription()); 
                    }
                   
                }
            }else if(input.equals("VIEW INVENTORY") || input.equals("I")){
                player.viewInventory();
            }else if(input.equals("ATTACK") || input.equals("A")){
                if(enemy != null){
                    int damage = player.attack();
                    enemy.setHealth(enemy.getHealth() - damage);
                    System.out.println("You hit the " + enemy.getName() + " for " + damage + " damage.");
                    if(enemy.getHealth() <= 0){
                        System.out.println("You killed the " + enemy.getName());
                        System.out.println("The " + enemy.getName() + " dropped some loot.");
                        player.addInventory(enemy.dropLoot());
                        enemy = null;
                        continue;
                    }
                    damage = enemy.attack();
                    player.setHealth(player.getHealth() - damage);
                    System.out.println("The " + enemy.getName() + " hit you for " + damage + " damage.");
                    if(player.getHealth() <= 0){
                        System.out.println("You Died");
                        return;
                    }
                }else{
                    System.out.println("There is nothing to attack.");
                }
                
            }else if(input.length() >= 3 && (input.substring(0, 3).equals("USE") || input.substring(0,1).equals("S"))){
                String item;
                try{
                    item = InputParser.parseUse(input);
                }catch(InvalidCommandFormatException e){
                    System.out.println("What?");
                    continue;
                }

                if(!player.useItem(item, Integer.parseInt(input.substring(input.length() - 1)))){

                }else{
                    System.out.println("You used " + input.substring(input.length() - 1) + " " + item);
                    int damage = enemy.attack();
                    player.setHealth(player.getHealth() - damage);
                    System.out.println("The " + enemy.getName() + " hit you for " + damage + " damage.");
                    if(player.getHealth() <= 0){
                        System.out.println("You Died");
                        return;
                    }
                }
            }else if(input.equals("RUN") || input.equals("D")){
                if(enemy == null){
                    player.resetTempAtk();
                    currentRoom = roomFactory.generateRoom();
                    System.out.println(currentRoom.getDescription());
                    enemy = enemyFactory.generateEnemy();
                    System.out.println(enemy.getDescription()); 
                }else{
                    System.out.println("You decide to run away, but before you do the " + enemy.getName() + " managed to hit you for " + enemy.getHighAtk());
                    player.setHealth(player.getHealth() - enemy.getHighAtk());
                    if(player.getHealth() <= 0){
                        System.out.println("You Died.");
                        return;
                    }
                    player.resetTempAtk();
                    currentRoom = roomFactory.generateRoom();
                    enemy = enemyFactory.generateEnemy();
                }
                
            }else if(input.equals("VIEW STATS") || input.equals("P")){
                player.getStats();
            }else{
                System.out.println("Invalid Command.");
            }

        }

        scanner.close();

    }

    public static void init(){

        roomFactory = RoomFactory.getInstance();
        enemyFactory = EnemyFactory.getInstance();

        player = new Player();

        currentRoom = new StartingRoom();
        System.out.println("\n\n\nYou awaken in a cold empty room. There is a note left on the ground. It reads,\n\n \"Conquer these trials and save the princess. I will be waiting.\"\n\n\t-M\"");
        

        scanner = new Scanner(System.in);


    }





}