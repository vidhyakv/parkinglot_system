package com.parkinglot.service;


public class ParkingManager {

    private ParkingLot parkingLot;

    private ParkingRegister parkingRegister;

    public ParkingManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public ParkingRegister getParkingRegister() {
        return parkingRegister;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingRegister = new ParkingRegister();
        this.parkingLot = parkingLot;
    }

}