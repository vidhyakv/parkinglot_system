package com.parkinglot.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.parkinglot.model.Slot;
public class AllotParkingLotCommand extends Command {
    @Override
    public void execute(String[] args) {
        HashMap<String, List<Slot>> slots = new HashMap<>();

        for (int i = 0; i <= args.length - 1; i++) {
            String[] values = args[i].split(":");
            if (values[1].equals("NA")) {
                slots.put(values[0], null);
            } else {
                int numberOfSlots = Integer.valueOf(values[1]);
                List<Slot> allotedSlots = new ArrayList<Slot>();
                for (int j = 0; j <= numberOfSlots - 1; j++) {
                    allotedSlots.add(new Slot(j + 1));
                }
                slots.put(values[0], allotedSlots);
            }

        }
        System.out.println("get parking lot");
        System.out.println(parkingManager);
        parkingManager.getParkingLot().setSlots(slots);
    }
}
