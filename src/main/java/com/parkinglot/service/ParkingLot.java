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
 
    public HashMap<String, List<Slot>> getVehicleSlots() {
        return this.slots;
    }

    public List<Slot> getSlots(String vehicleName) {
        return this.slots.get(vehicleName);
    }

}
