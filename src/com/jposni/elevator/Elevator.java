package com.jposni.elevator;

public class Elevator {

    private State state;

    private Floor location;

    public Elevator(State state, Floor defaultLocation){
        this.state = state;
        this.location = defaultLocation;
    }

    public void move(int startLocation, int endLocation) throws InterruptedException {
        System.out.println("Moving the elevator......");

        for(int i = startLocation; i < endLocation; i++){
            System.out.print(i + " ===>>> ");
            Thread.sleep(500);
        }

        System.out.println("ENDED");
    }
}
