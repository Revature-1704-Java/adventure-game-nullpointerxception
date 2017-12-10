package com.nullpointerxception.assets.rooms;

import java.util.*;


import com.nullpointerxception.assets.items.Item;

public abstract class Room{

	private String name;
	private String description;
	protected Random generator;

	public Room(String name, String description){
		this.name = name;
		this.description = description;
		generator = new Random();
	}

	public Room(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public String getDescription(){
		return description;
	}


	public abstract ArrayList<Item> dropLoot();


}