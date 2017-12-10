package com.nullpointerxception.entities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.nullpointerxception.assets.items.Item;
import com.nullpointerxception.assets.items.ItemInventory;
import com.nullpointerxception.game.*;

public class Player extends Entity{

	private HashMap<String,ItemInventory> inventory;
	private int goldPieces;

	public Player(){
		super("Player", 15 , 1, 5, "The player character");
		inventory = new HashMap<String,ItemInventory>();
	}

	public int getGoldPieces(){
		return goldPieces;
	}

	public void addGoldPieces(int gp){
		goldPieces += gp;
	}

	public void subtractGoldPieces(int gp){
		goldPieces -= gp;
	}

	public void addInventory(ArrayList<Item> items){
		if(items == null){
			return;
		}
		Iterator<Item> it = items.iterator();
		while(it.hasNext()){
			Item item = it.next();
			if(inventory.get(item.getName()) == null){
				inventory.put(item.getName(), new ItemInventory(item, item.getAmount()));
			}else{
				ItemInventory itemInventory = inventory.get(item.getName());
				itemInventory.addInventory(item.getAmount());
				inventory.put(item.getName(), itemInventory);
			}
		}

	}

	public void viewInventory(){

		System.out.println("Inventory:");
		
		for(Entry<String,ItemInventory> entry: inventory.entrySet()){

			System.out.println(entry.getKey() + ": " + entry.getValue().getAmount());

		}

	}

	public boolean useItem(String itemName, int amount){
		String UpperItemName = itemName.toUpperCase();
		if(inventory.get(UpperItemName) == null || inventory.get(itemName).getAmount() <= 0){
			System.out.println("You don't have any " + itemName + "s");
			return false;
		}else{
			ItemInventory itemInventory = inventory.get(UpperItemName);
			itemInventory.subtractInventory(amount);
			itemInventory.getItem().use(Game.player, Game.enemy);
			return true;
		}
	}

	public void getStats(){
		System.out.println("Health: " + getHealth());
		System.out.println("GP: " + getGoldPieces());
	}

	@Override
	public int attack(){
		return generateDamage();
	}


}