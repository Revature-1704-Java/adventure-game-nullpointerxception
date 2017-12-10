package com.nullpointerxception.assets.items;

public class ItemInventory{

    private Item item;
    private int amount;

    public ItemInventory(Item item, int amount){
        this.item = item;
        this.amount = amount;
    }

    public Item getItem(){
        return item;
    }

    public int getAmount(){
        return amount;
    }

    public void addInventory(int amount){
        this.amount += amount;
    }

    public void subtractInventory(int amount){
        this.amount -= amount;
    }
        

}