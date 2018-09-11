package com.jposni.elevator;

public class DemoClass {

    public static void main(String args[]) throws InterruptedException {

        Building mindspace = new Building(8, 1);
        mindspace.elevators[0].move(0,8);
    }
}
