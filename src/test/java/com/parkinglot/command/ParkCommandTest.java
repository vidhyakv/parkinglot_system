package com.parkinglot.command;


import com.parkinglot.model.Slot;
import com.parkinglot.service.ParkingLot;
import com.parkinglot.service.ParkingRegister;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        parkCommand.setParkingManager(parkingManager);
        when (parkingManager.getParkingRegister()).thenReturn(new ParkingRegister());
        when(parkingManager.getParkingLot()).thenReturn(parkingLot);
        List<Slot> availableSlots = new ArrayList<Slot>();
        availableSlots.add(new Slot(1));
        availableSlots.add(new Slot(2));
        when(parkingLot.getSlots(any(String.class))).thenReturn(availableSlots);
        parkCommand.execute(new String []{ vehicleName });
        availableSlots.forEach(element->{
            if (element.isOccupied()){
                assertEquals(element.getTicketNo(), element.getSlotId());
            }else{
                assertEquals(element.getTicketNo(),0);
            }
        });
    }
}
