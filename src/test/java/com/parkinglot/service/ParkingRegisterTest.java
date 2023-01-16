package com.parkinglot.service;

import com.parkinglot.model.Record;
import com.parkinglot.model.Slot;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ParkingRegisterTest {

    private Map<Integer, Record>  parkingStatus;
    private ParkingRegister parkingRegister;
    private String vehicleName;
    private Slot slot;
    private Record inputRec;


    @Before
    public void setUp() {
        vehicleName = "motorcycle";
        parkingRegister = new ParkingRegister();
        slot = new Slot(1);
        inputRec = new Record();
        inputRec.setSlot(slot);
        inputRec.setTicketNumber(19);
        inputRec.setFeeCost(78);
    }

    @Test
    public void shouldAddRecordToParkingStatus() throws Exception {
        Record record = parkingRegister.record(slot, vehicleName, java.time.LocalDateTime.now());
        assertEquals(record.getSlot(),slot);
        assertNotNull(parkingRegister.getParkingStatus().get(record.getTicketNumber()));
    }

    @Test
    public void shouldEraseRecordfromParkingStatus() {
        inputRec.getSlot().setOccupied(true);
        assertEquals(inputRec.getSlot().isOccupied(),true);
        parkingRegister.getParkingStatus().put(inputRec.getTicketNumber(),inputRec);
        parkingRegister.erase(inputRec, java.time.LocalDateTime.now().plusDays(9));
        assertEquals (inputRec.getSlot().isOccupied(),false);
        assertNull(parkingRegister.getParkingStatus().get(inputRec.getTicketNumber()));
    }
}
