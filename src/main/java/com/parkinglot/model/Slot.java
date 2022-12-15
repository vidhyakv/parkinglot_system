package com.parkinglot.model;

import java.sql.Time;
import java.time.LocalDateTime;

public class Slot {

	public Slot(int slotId){
		this.slotId = slotId;
	}
	private int slotId;
	
	private int ticketNo;
	
	private LocalDateTime entryDateTime;
	
	private LocalDateTime endTime;
	
	private boolean isOccupied;

	public int getSlotId() {
		return slotId;
	}

	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public LocalDateTime getEntryDateTime() {
		return entryDateTime;
	}

	public void setEntryDateTime(LocalDateTime entryDateTime) {
		this.entryDateTime = entryDateTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean occupied) {
		isOccupied = occupied;
	}
}
