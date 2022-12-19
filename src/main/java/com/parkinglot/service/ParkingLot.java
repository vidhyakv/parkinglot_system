package com.parkinglot.service;

import java.util.HashMap;
import java.util.List;

import com.parkinglot.model.FeeModel;
import com.parkinglot.model.Slot;

public class ParkingLot {

    private FeeModel feeModel;

    private HashMap<String, List<Slot>> slots;

    public ParkingLot(FeeModel feeModel, HashMap<String, List<Slot>> slots) {
        this.feeModel = feeModel;
        this.slots = slots;
    }

    public ParkingLot() {
    }

    public List<Slot> getSlots(String vehicleName) {
        return this.slots.get(vehicleName);
    }

    public FeeModel getFeeModel() {
        return feeModel;
    }

    public void setFeeModel(FeeModel feeModel) {
        this.feeModel = feeModel;
    }

    public HashMap<String, List<Slot>> getSlots() {
        return slots;
    }

    public void setSlots(HashMap<String, List<Slot>> slots) {
        this.slots = slots;
    }
}
