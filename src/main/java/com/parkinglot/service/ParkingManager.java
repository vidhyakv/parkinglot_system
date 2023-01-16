package com.parkinglot.service;


import com.parkinglot.model.*;
import com.parkinglot.util.TimeUtility;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

    public Record park(String vehicleName, LocalDateTime entryTime) {
        List<Slot> totalSlots = parkingLot.getAvailableSlots(vehicleName);
        Slot slot = totalSlots.stream().filter(a->!a.isOccupied()).findFirst()
                .orElseThrow(() -> new RuntimeException("All slots are occupied"));
        Record record = parkingRegister.record(slot, vehicleName, entryTime);
        return record;
    }

    public Record unpark(String vehicleName, int ticketNumber, LocalDateTime endTime) throws Exception {
        Record record = parkingRegister.getSlotbyTicketNumber(vehicleName, ticketNumber);
        parkingRegister.erase(record, endTime);
        record.setFeeCost(parkingLot.getFeeModel().calculateFee(record.getParkingTime(), vehicleName, parkingLot.getFeeModel().getLocalFeeModels()));
        return record;
    }
}