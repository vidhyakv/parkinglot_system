package com.parkinglot.command;

import com.parkinglot.model.Slot;
import java.util.List;

public class ParkCommand extends Command {
    @Override
    public void execute(String[] args) {
        System.out.println(args[0]);
        String vehicleName = args[0];
        System.out.println(parkingManager.getParkingLot().getSlots());
        List<Slot> totalSlots = parkingManager.getParkingLot().getSlots(vehicleName);
        System.out.println(totalSlots.size());
        Slot slot = totalSlots.stream().filter(a->!a.isOccupied()).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("All slots are occupied"));
        slot.setTicketNo(parkingManager.getParkingRegister().getTicketNumber());
        slot.setEntryDateTime(java.time.LocalDateTime.now());
        System.out.println(String.format("Parking Ticket \n Slot Number: %d", slot.getSlotId()));
    }
}

