package com.jposni.elevator;

public class Floor {
    int floorNo;
    boolean upButton;
    boolean downButton;

    public Floor(int floorNo){
        this.floorNo = floorNo;
        upButton = false;
        downButton = false;
    }
}
