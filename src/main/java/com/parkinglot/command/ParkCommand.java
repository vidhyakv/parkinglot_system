package com.parkinglot.command;

import com.parkinglot.model.Record;
import com.parkinglot.model.Slot;

import java.text.MessageFormat;
import java.util.List;

public class ParkCommand extends Command {
    @Override
    public void execute(String[] args) {
        String vehicleName = args[0];
        Record record = parkingManager.park(vehicleName);
        System.out.println(MessageFormat.format("Parking Ticket \n Ticket Number: {0} \n Slot Number: {1} \n Entry Date-time: {2}", record.getTicketNumber(),record.getSlot().getSlotId(), record.getEntryDateTime()));
    }
}