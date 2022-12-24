package com.parkinglot.service;

import com.parkinglot.command.CommandTest;
import com.parkinglot.command.UnparkCommand;
import com.parkinglot.model.Record;
import com.parkinglot.model.Slot;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class ParkingManagerTest {

    private String vehicleName;
    private ParkingRegister parkingRegister;

    private ParkingLot parkingLot;

    private ParkingManager parkingManager;

    private List<Slot> allotedSlots;

    @Before
    public void setUp() {
        vehicleName = "motorcycle";
        parkingRegister = new ParkingRegister();
        parkingLot = new ParkingLot();
        parkingManager = new ParkingManager(parkingLot, parkingRegister);
        allotedSlots = new ArrayList<Slot>();
        Slot slot = new Slot(1);
        allotedSlots.add(slot);
        HashMap<String, List<Slot>> slots = new HashMap<>();
        slots.put(vehicleName,allotedSlots);
        parkingManager.getParkingLot().setSlots(slots);
    }

    @Test
    public void shouldMakeentryRecordwhileParking() throws Exception {
        Record record = parkingManager.park(vehicleName);
        assertEquals(record.getTicketNumber(),1);
        assertEquals(parkingRegister.getParkingStatus().get(record.getTicketNumber()),record);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowErrorwhenallSlotsareOccupied() throws Exception {
        allotedSlots.stream().forEach(element-> element.setOccupied(true));
        Record record = parkingManager.park(vehicleName);
    }

}
