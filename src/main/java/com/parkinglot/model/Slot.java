package com.parkinglot.model;

public class Slot {

	public Slot(int slotId){
		this.slotId = slotId;
	}
	private int slotId;

	private boolean isOccupied;
	public int getSlotId() {
		return slotId;
	}

	public boolean isOccupied() {
		           return isOccupied;
	}

	public void setOccupied(boolean occupied) {
		isOccupied = occupied;
	}
}
