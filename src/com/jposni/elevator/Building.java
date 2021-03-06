package com.jposni.elevator;

import com.jposni.elevator.exception.InvalidFloorNoExcpetion;
import com.jposni.elevator.thread.ElevatorRunnable;

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
            Elevator elevator = new Elevator(i, State.IDLE, 0);
            this.elevators[i] = elevator;
        }
    }

    public void callElevatorFrom(int targetFloorNo, boolean upButton, boolean downButton ) throws InterruptedException, InvalidFloorNoExcpetion {
        validateTargetFloorNo(targetFloorNo);

        this.floors[targetFloorNo].upButton = upButton;
        this.floors[targetFloorNo].downButton = downButton;
        
        Elevator selectedElevator = selectAnElevator(targetFloorNo);
        int elevatorStartFloorNo = selectedElevator.getCurrentFloorNo();
//        selectedElevator.move(targetFloorNo);
        ElevatorRunnable runnableElevator = new ElevatorRunnable(selectedElevator, targetFloorNo);
        Thread thread = new Thread(runnableElevator);
        thread.setName("lift" + String.valueOf(selectedElevator.getId()));
        thread.start();
        //write an if condition, to check if the elevator has actually moved to the targetFloorNo
        setFloorButtons(targetFloorNo, false, false);
    }

    private void validateTargetFloorNo(int targetFloorNo) throws InvalidFloorNoExcpetion {
        if( targetFloorNo >= noFloors || 0 > targetFloorNo){
            throw new InvalidFloorNoExcpetion("Requested floor doesn't exist. LOL!");
        }
    }

    private void setFloorButtons(int targetFloorNo, boolean upButton, boolean downButton) {
        this.floors[targetFloorNo].upButton = upButton;
        this.floors[targetFloorNo].downButton = downButton;
    }

    private Elevator selectAnElevator(int targetFloorNo) {
        Elevator selectedElevator = null;
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i < elevators.length; i++){
            Elevator currentElevator = elevators[i];
            int distanceBetween = getDistanceBetween(currentElevator, targetFloorNo);
            if (distanceBetween < distance){
                selectedElevator = currentElevator;
                distance = distanceBetween;
            }
        }
        return selectedElevator;
    }

    private int getDistanceBetween(Elevator anElevator, int targetFloorNo) {
        //this could be neagative, covert it to positive.
        int distance =  anElevator.getCurrentFloorNo() - targetFloorNo;
        if (distance < 0) {
            return -1 * distance;
        }else return distance;
    }
}
