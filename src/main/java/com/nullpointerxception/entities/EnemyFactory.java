package com.nullpointerxception.entities;

import java.util.Random;

public class EnemyFactory{

    private static EnemyFactory enemyFactory;
    private Random generator;

    private EnemyFactory(){
        generator = new Random();
    }

    public static EnemyFactory getInstance(){
        if(enemyFactory == null){
            enemyFactory = new EnemyFactory();
            return enemyFactory;
        }else{
            return enemyFactory;
        }
    }

    public Enemy generateEnemy(){

        double n = generator.nextDouble();

        if(n <= .3){
            return new GiantAnt();
        }else if(n > .3 && n <= .6){
            return new LargeRat();
        }else if(n > .6 && n <= .9){
            return new Zombie();
        }else{
            return new Mimic();
        }

    }

}