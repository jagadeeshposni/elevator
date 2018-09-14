package com.jposni.elevator.thread;

import com.jposni.elevator.Elevator;

public class ElevatorRunnable implements Runnable {

    Elevator elevator;

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public int getTargetFloorNo() {
        return targetFloorNo;
    }

    public void setTargetFloorNo(int targetFloorNo) {
        this.targetFloorNo = targetFloorNo;
    }

    int targetFloorNo;

    public ElevatorRunnable(Elevator elevator, int targetFloorNo) {
        this.elevator = elevator;
        this.targetFloorNo = targetFloorNo;
    }

    @Override
    public void run() {
        try {
            elevator.move(this.getTargetFloorNo());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
