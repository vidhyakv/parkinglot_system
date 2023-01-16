package com.parkinglot.command;

import com.parkinglot.model.Record;
import com.parkinglot.util.TimeUtility;

import java.text.MessageFormat;

public class ParkCommand extends Command {
    @Override
    public void execute(String[] args) {
        String vehicleName = args[0];
        String entryDate = args[1];
        String entryTime = args[2];
        Record record = parkingManager.park(vehicleName, TimeUtility.convertStringToLocalDateTime(entryDate,entryTime));
        System.out.println(MessageFormat.format("Parking Ticket \n Ticket Number: {0} \n Slot Number: {1} \n Entry Date-time: {2}", record.getTicketNumber(),record.getSlot().getSlotId(), record.getEntryDateTime()));
    }
}