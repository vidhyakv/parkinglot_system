package com.parkinglot.service;


import com.parkinglot.model.*;
import org.junit.Before;
import org.junit.Test;

import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

public class ParkingManagerTest {

    private String vehicleName;
    private ParkingRegister parkingRegister;

    private ParkingLot parkingLot;

    private ParkingManager parkingManager;

    private List<Slot> allotedSlots;
    private Record inputRec;
    private java.time.LocalDateTime entryTime;

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

        inputRec = new Record();
        inputRec.setSlot(slot);
        inputRec.setVehicleName("motorcycle");
        inputRec.setTicketNumber(19);
        entryTime = java.time.LocalDateTime.now();
        inputRec.setEntryDateTime(entryTime);
    }

    @Test
    public void shouldMakeentryRecordwhileParking() throws Exception {
        Record record = parkingManager.park(vehicleName, java.time.LocalDateTime.now().plusDays(1));
        assertEquals(record.getTicketNumber(),1);
        assertEquals(parkingRegister.getParkingStatus().get(record.getTicketNumber()),record);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowErrorwhenallSlotsareOccupied() throws Exception {
        allotedSlots.stream().forEach(element-> element.setOccupied(true));
        parkingManager.park(vehicleName, java.time.LocalDateTime.now());
    }

    @Test
    public void shouldCalculateFlatFeeAirportParking() throws Exception {
        AirPortFeeModel feeModel = new AirPortFeeModel();
        FeeDetail feeDetail = new FeeDetail();
        feeDetail.setFeeValue(900);
        feeDetail.setFeeLowerLimit(24);
        feeDetail.setFeeUpperLimit(0);
        feeDetail.setFeeType("per-day");
        feeModel.putfeeModel("motorcycle", feeDetail);
        parkingLot.setFeeModel(feeModel);
        parkingRegister.getParkingStatus().put(19, inputRec);
        parkingManager.unpark(vehicleName, 19, entryTime.now().plusDays(2));
        assertEquals(inputRec.getFeeCost(), 1800);
    }

}
