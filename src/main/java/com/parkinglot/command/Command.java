package com.parkinglot.command;

import com.parkinglot.service.ParkingManager;

public abstract class Command {
    protected static ParkingManager parkingManager;
    public static void setParkingManager(ParkingManager parkingManager) {
        Command.parkingManager = parkingManager;
    }
    public abstract void execute(String[] args);
}
