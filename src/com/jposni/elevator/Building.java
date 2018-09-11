package com.jposni.elevator;

public class Building {

    int noFloors;

    Floor floors[];

    int noElevators;

    Elevator elevators[];

    public Building(int noFloors, int noElevators){
        this.noElevators = noElevators;
        this.noFloors = noFloors;
        this.elevators = new Elevator[noElevators];
        this.floors = new Floor[noFloors];

        for(int i = 0; i < noFloors; i++){
            Floor floor = new Floor(i);
            this.floors[i] = floor;
        }

        for(int i = 0; i < noElevators; i++){
            Elevator elevator = new Elevator(State.IDLE, floors[0]);
            this.elevators[i] = elevator;
        }
    }
}
