package com.nullpointerxception.assets.rooms;

import java.util.Random;

public class RoomFactory{

    private static RoomFactory roomFactory;
    private Random generator;

    private RoomFactory(){
        generator = new Random();
    }

    public static RoomFactory getInstance(){
        if(roomFactory == null){
            roomFactory = new RoomFactory();
            return roomFactory;
        }else{
            return roomFactory;
        }
    }

    public Room generateRoom(){
        double p = generator.nextDouble();
        if(p <= .9){
            return new NormalRoom();
        }else{
            return new TreasureRoom();
        }
    }



}