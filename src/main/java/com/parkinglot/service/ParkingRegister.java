package com.parkinglot.service;

public class ParkingRegister {

    public static int ticketNumber = 0;

    public int getTicketNumber(){
        return ++ticketNumber;
    }
}
