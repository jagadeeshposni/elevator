package com.jposni.elevator;

public class Elevator {

    private State state;

    private int currentFloorNo;

    public State getState() {
        return state;
    }

    public int getCurrentFloorNo() {
        return currentFloorNo;
    }

    public Elevator(State state, int defaultLocation){
        this.state = state;
        this.currentFloorNo = defaultLocation;
    }

    public void move(int endLocation) throws InterruptedException {
        System.out.println("Trying to move the elevator......");
        if(currentFloorNo < endLocation){
            this.state = State.RUNNING_UP;
            for(int i = currentFloorNo; i <= endLocation; i++){
                System.out.print(i + " ===>>> ");
                Thread.sleep(500);
            }
        }else if (currentFloorNo > endLocation){
            this.state= State.RUNNING_DOWN;
            for(int i = currentFloorNo; i >= endLocation; i--){
                System.out.print(i + " ===>>> ");
                Thread.sleep(500);
            }
        }else{
            System.out.println("Already situated at " + endLocation + " floor" );
        }

        this.state = State.IDLE;
        this.currentFloorNo = endLocation;
        System.out.println("STOP");
    }
}
