package com.jposni.elevator;

import java.util.Scanner;

public class DemoClass {

    public static void main(String args[]) throws InterruptedException {

        Building mindspace = new Building(8, 1);
//        mindspace.elevators[0].move(8);
        System.out.println("Welcome Jagadeesh....");
        for(;;) {
            System.out.println("Which floor do you want to go..?");
            Scanner s = new Scanner(System.in);
            int targetFloorNo = s.nextInt();

            mindspace.callElevatorFrom(targetFloorNo, true, false);
        }
    }
}
