package com.parkinglot.service;

import com.parkinglot.model.Record;
import com.parkinglot.model.Slot;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingRegister {

    public static int ticketNumber = 0;

    private Map<Integer, Record> parkingStatus;

    public int getTicketNumber() {
        return ++ticketNumber;
    }

    public ParkingRegister(){
        this.parkingStatus = new HashMap<Integer, Record>();
    }

    public Map<Integer, Record> getParkingStatus() {
        return parkingStatus;
    }

    public Record record(Slot slot, String vehicleName) {
        int ticketNo = getTicketNumber();
        Record record = new Record();
        record.setSlot(slot);
        record.setTicketNumber(ticketNo);
        record.setEntryDateTime(java.time.LocalDateTime.now());
        record.setVehicleName(vehicleName);
        slot.setOccupied(true);
        parkingStatus.put(ticketNo, record);
        return record;
    }


    public Record erase(Record record) {
        //record.setEndTime(java.time.LocalDateTime.now().plusDays(8));
        record.setEndTime(java.time.LocalDateTime.now());
        record.getSlot().setOccupied(false);
        return parkingStatus.remove(record.getTicketNumber());
    }

    public Record getSlotbyTicketNumber(String vehicleName, int ticketNumber) throws Exception {
        Optional <Map.Entry<Integer, Record>> record = this.parkingStatus.entrySet().stream().parallel().filter(e ->
                e.getValue().getTicketNumber() == ticketNumber && e.getValue().getVehicleName().equals(vehicleName)
        ).findFirst();
        if (record.isPresent()) {
            return record.get().getValue();
        }else {
            throw new Exception(String.format("No vehicle found for ticketNumber %d", ticketNumber));
        }

    }
}
