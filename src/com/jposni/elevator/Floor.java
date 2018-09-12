package com.jposni.elevator;

public class Floor {
    int floorNo;
    boolean upButton;

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public void setUpButton(boolean upButton) {
        this.upButton = upButton;
    }

    public void setDownButton(boolean downButton) {
        this.downButton = downButton;
    }

    public int getFloorNo() {

        return floorNo;
    }

    public boolean isUpButton() {
        return upButton;
    }

    public boolean isDownButton() {
        return downButton;
    }

    boolean downButton;

    public Floor(int floorNo){
        this.floorNo = floorNo;
        upButton = false;
        downButton = false;
    }


}
