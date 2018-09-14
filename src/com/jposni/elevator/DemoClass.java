package com.jposni.elevator;

import com.jposni.elevator.exception.InvalidFloorNoExcpetion;

import java.util.Scanner;

public class DemoClass {

    public static void main(String args[]) throws InterruptedException, InvalidFloorNoExcpetion {

        System.out.println("Welcome Jagadeesh....");
        Scanner s = new Scanner(System.in);
            System.out.println("Tell me, how many floors are in the building..?");
        int noOfFloors = s.nextInt();
        System.out.println("And the no of elevators..?");
        int noOfElevators = s.nextInt();
        Building mindspace = new Building(noOfFloors, noOfElevators);

        for(;;) {

            System.out.println("Which floor do you want to go..?");
            int targetFloorNo = s.nextInt();

            mindspace.callElevatorFrom(targetFloorNo, true, false);
        }
    }
}
