package com.parkinglot.command;

import com.parkinglot.model.Record;
import java.text.MessageFormat;

public class UnparkCommand extends Command {
    @Override
    public void execute(String[] args) throws Exception {
        String vehicleName = args[0];
        String ticketNumber = args[3];
        Record record = parkingManager.unpark(vehicleName, Integer.parseInt(ticketNumber));
        System.out.println(MessageFormat.format("Parking Receipt: \n Receipt Number: R-{0} \n Entry Date-time: {1} \n Exit Date-time: {2} \n Fees: {3}", ticketNumber, record.getEntryDateTime(),record.getEndTime(), record.getFeeCost()));
    }
}