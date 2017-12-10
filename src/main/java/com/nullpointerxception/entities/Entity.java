package com.nullpointerxception.entities;

import java.util.Random;


public abstract class Entity{
    
    private String name;
    private int health;
    private int lowAtk;
    private int highAtk;
    private int tempLowAtk;
    private int tempHighAtk;
    private String description;
    protected Random generator;
    
    protected Entity(String name, int health, int lowAtk, int highAtk, String description){
        this.name = name;
        this.health = health;
        this.lowAtk = lowAtk;
        this.highAtk = highAtk;
        this.description = description;
        generator = new Random();
    }

    public String getName(){
        return name;
    }

    public int getHealth(){
        return health;
    }

    public String getDescription(){
        return description;
    }

    public int getLowAtk(){
        return lowAtk;
    }

    public int getHighAtk(){
        return highAtk;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setTempLowAtk(int tempLowAtk){
        this.tempLowAtk = this.tempLowAtk + tempLowAtk;
    }

    public void setTempHighAtk(int tempHighAtk){
        this.tempHighAtk = this.tempHighAtk + tempHighAtk;
    }

    public void resetTempAtk(){
        tempLowAtk = 0;
        tempHighAtk = 0;
    }

    protected int generateDamage(){
        return generator.nextInt((highAtk + tempHighAtk) - (lowAtk + tempLowAtk)) + (lowAtk + tempLowAtk);
    }

    public abstract int attack();


}