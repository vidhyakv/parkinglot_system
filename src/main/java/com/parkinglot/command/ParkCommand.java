package com.parkinglot.command;

import com.parkinglot.model.Slot;
import java.util.List;

public class ParkCommand extends Command {
    @Override
    public void execute(String[] args) {
        String vehicleName = args[0];
        List<Slot> totalSlots = parkingManager.getParkingLot().getSlots(vehicleName);
        Slot slot = totalSlots.stream().filter(a->!a.isOccupied()).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("All slots are occupied"));
        slot.setTicketNo(parkingManager.getParkingRegister().getTicketNumber());
        slot.setOccupied(true);
        slot.setEntryDateTime(java.time.LocalDateTime.now());
        System.out.println(String.format("Parking Ticket \n Slot Number: %d", slot.getSlotId()));
    }
}

