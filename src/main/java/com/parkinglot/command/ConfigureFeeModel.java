package com.parkinglot.command;

import com.parkinglot.model.FeeModel;
import com.parkinglot.service.ParkingManager;
import com.parkinglot.util.FeeModelFactory;

public class ConfigureFeeModel extends Command {
    @Override
    public void execute(String[] args) {

        String inputFeeModel = args[0];
        FeeModel feeModel = FeeModelFactory.getFeeModel(inputFeeModel);
        System.out.println(feeModel);
        parkingManager.getParkingLot().setFeeModel(feeModel);
    }
}
