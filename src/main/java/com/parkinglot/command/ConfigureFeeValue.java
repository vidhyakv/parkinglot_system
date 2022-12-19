package com.parkinglot.command;

import com.parkinglot.model.FeeModel;
import com.parkinglot.util.FeeModelFactory;

public class ConfigureFeeValue extends Command {
    @Override
    public void execute(String[] args) {

        String vehicleName = args[0];
        String feeValue = args[1];
        parkingManager.getParkingLot().getFeeModel().putfeeModel(vehicleName, Integer.parseInt(feeValue));
    }
}
