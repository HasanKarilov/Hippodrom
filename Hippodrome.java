package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by hanaria on 11/6/16.
 */
public class Hippodrome
{
    public static Hippodrome game;
    private static ArrayList<Horse> horses = new ArrayList<Horse>();

    public static void main(String[] args)
    {
       game = new Hippodrome();
        Horse horse1 = new Horse("Asel", 3.0, 0);
        Horse horse2 = new Horse("Ulan", 3.0, 0);
        Horse horse3 = new Horse("Inha", 3.0, 0);

        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();
        game.printWinner();

    }




    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run()
    {
        for (int i = 0; i < 100; i++)
        {
            try
            {
                move();
                print();
                Thread.sleep(200);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
    public void print(){
        for(Horse horse: horses){
            horse.print();
            System.out.println();
            System.out.println();
        }

    }
    public void move(){
        for(Horse horse: horses){
            horse.move();
            horse.print();
        }
    }

    public Horse getWinner(){
        int tempIndex = 0;
        for(int i = 0; i< horses.size(); i++){
            tempIndex = 0;
            if (horses.get(i).getDistance() > horses.get(tempIndex).getDistance())
            {
                tempIndex = tempIndex + 1;
            }

        }
        return horses.get(tempIndex);
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");

    }
}
