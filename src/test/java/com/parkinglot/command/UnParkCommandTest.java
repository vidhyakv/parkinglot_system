package com.parkinglot.command;


import com.parkinglot.model.Record;
import com.parkinglot.model.Slot;
import org.junit.Before;
import org.junit.Test;

import java.text.MessageFormat;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


public class UnParkCommandTest extends CommandTest {
    private UnparkCommand unParkCommand;

    @Before
    public void setUp() {
        unParkCommand = new UnparkCommand();
    }

    @Test
    public void shouldUnParkMotorcycleandReturnFeeCost() throws Exception {
        String vehicleName = "motorcycle";
        int ticketNumber = 1;
        Slot slot = new Slot(1);
        Record record = new Record();
        record.setVehicleName(vehicleName);
        LocalDateTime entryTime = java.time.LocalDateTime.now();
        LocalDateTime endTime = java.time.LocalDateTime.now();
        record.setEntryDateTime(entryTime);
        record.setEndTime(endTime);
        record.setFeeCost(20);
        record.setSlot(slot);
        unParkCommand.setParkingManager(parkingManager);
        when (parkingManager.unpark(vehicleName, ticketNumber)).thenReturn(record);
        unParkCommand.execute( new String []{ vehicleName, "ticket", "number", "1" } );
        assertEquals(MessageFormat.format("Parking Receipt: \n Receipt Number: R-{0} \n Entry Date-time: {1} \n Exit Date-time: {2} \n Fees: {3}\n",ticketNumber,entryTime,endTime,20), outContent.toString());
    }
}
