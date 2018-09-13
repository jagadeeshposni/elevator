package com.jposni.elevator;

public class Elevator {

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;

    }

    private int id;

    private State state;

    private int currentFloorNo;

    public State getState() {
        return state;
    }

    public int getCurrentFloorNo() {
        return currentFloorNo;
    }

    public Elevator(int id, State state, int defaultLocation){
        this.setId(id);
        this.state = state;
        this.currentFloorNo = defaultLocation;
    }

    public void move(int endLocation) throws InterruptedException {
        System.out.println("Calling elevator no: " + this.getId());
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
