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
            Elevator elevator = new Elevator(State.IDLE, 0);
            this.elevators[i] = elevator;
        }
    }

    public void callElevatorFrom(int targetFloorNo, boolean upButton, boolean downButton ) throws InterruptedException {
        this.floors[targetFloorNo].upButton = upButton;
        this.floors[targetFloorNo].downButton = downButton;
        
        Elevator selectedElevator = selectAnElevator();
        int elevatorStartLocation = selectedElevator.getCurrentFloorNo();
        selectedElevator.move(targetFloorNo);

        setFloorButtons(elevatorStartLocation, targetFloorNo);
    }

    private void setFloorButtons(int elevatorStartLocation, int targetFloorNo) {
        this.floors[targetFloorNo].upButton = false;
        this.floors[targetFloorNo].downButton = false;
    }

    private Elevator selectAnElevator() {
        return elevators[0];
    }
}
