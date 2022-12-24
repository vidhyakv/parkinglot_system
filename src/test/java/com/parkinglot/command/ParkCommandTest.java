package com.parkinglot.command;


import com.parkinglot.model.Record;
import com.parkinglot.model.Slot;
import com.parkinglot.service.ParkingLot;
import com.parkinglot.service.ParkingRegister;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


public class ParkCommandTest extends CommandTest {
    private ParkCommand parkCommand;

    ParkingLot parkingLot = Mockito.mock(ParkingLot.class);

    @Before
    public void setUp() throws Exception {
        parkCommand = new ParkCommand();
    }

    @Test
    public void shouldParkMotorcycleandSetTicketNumber() throws Exception {
        String vehicleName = "motorcycle";
        Record record = new Record();
        record.setTicketNumber(1);
        record.setSlot(new Slot(1));
        record.setEntryDateTime(java.time.LocalDateTime.now());
        parkCommand.setParkingManager(parkingManager);
        when (parkingManager.park(vehicleName)).thenReturn(record);
        parkCommand.execute(new String []{ vehicleName });
        assertEquals(MessageFormat.format("Parking Ticket \n Ticket Number: {0} Slot Number: {1} Entry Date-time: {2}\n", record.getTicketNumber(),record.getSlot().getSlotId(), record.getEntryDateTime()), outContent.toString());
    }
}
