package com.parkinglot.command;

import com.parkinglot.service.ParkingLot;
import com.parkinglot.service.ParkingManager;
import com.parkinglot.service.ParkingRegister;

public class CreateParkingLotCommand extends Command {
    @Override
    public void execute(String[] args) {
        setParkingManager(new ParkingManager(new ParkingLot(), new ParkingRegister()));
    }
}
