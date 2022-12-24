package com.parkinglot.model;

import com.parkinglot.util.MathUtility;

import java.time.Duration;
import java.time.LocalDateTime;

public class Record {

    private Slot slot;
    private LocalDateTime entryDateTime;

    private LocalDateTime endTime;

    private int feeCost;

    private int ticketNumber;

    private String vehicleName;

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
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

    public int getFeeCost() {
        return feeCost;
    }

    public void setFeeCost(int feeCost) {
        this.feeCost = feeCost;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getParkingTime(){
        Duration dur = Duration.between(this.entryDateTime, this.endTime);
        long millis = dur.toMillis();
        return MathUtility.roundOff((float)millis/3600000);
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Override
    public String toString() {
        return "Record{" +
                "slot=" + slot +
                " vehicleName=" + vehicleName +
                ", entryDateTime=" + entryDateTime +
                ", endTime=" + endTime +
                ", feeCost=" + feeCost +
                ", ticketNumber=" + ticketNumber +
                '}';
    }
}
