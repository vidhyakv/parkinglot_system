package com.parkinglot.service;


import com.parkinglot.model.Record;
import com.parkinglot.model.Slot;

import java.text.MessageFormat;
import java.util.List;

public class ParkingManager {

    private ParkingLot parkingLot;

    private ParkingRegister parkingRegister;

    public ParkingManager(ParkingLot parkingLot, ParkingRegister parkingRegister) {
        this.parkingLot = parkingLot;
        this.parkingRegister = parkingRegister;
    }

    public ParkingLot getParkingLot() {
        return this.parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingRegister = new ParkingRegister();
        this.parkingLot = parkingLot;
    }

    public Record park(String vehicleName) {
        List<Slot> totalSlots = parkingLot.getAvailableSlots(vehicleName);
        Slot slot = totalSlots.stream().filter(a->!a.isOccupied()).findFirst()
                .orElseThrow(() -> new RuntimeException("All slots are occupied"));
        Record record = parkingRegister.record(slot, vehicleName);
        return record;
    }

    public Record unpark(String vehicleName, int ticketNumber) throws Exception {
        Record record = parkingRegister.getSlotbyTicketNumber(vehicleName, ticketNumber);
        parkingRegister.erase(record);
        record.setFeeCost(parkingLot.getFeeModel().calculateFee(record.getParkingTime(), vehicleName));
        return record;
    }
}