package com.parkinglot.command;

import com.parkinglot.model.FeeDetail;
import com.parkinglot.model.FeeModel;
import com.parkinglot.model.Vehicle;
import com.parkinglot.util.FeeModelFactory;

public class ConfigureFeeValue extends Command {
    @Override
    public void execute(String[] args) {

        String vehicleName = args[0];
        String feeValue = args[1];
        FeeDetail feeDetail = new FeeDetail();
        feeDetail.setFeeValue(Integer.parseInt(feeValue));
        if (args.length>3){
            feeDetail.setFeeLowerLimit(Integer.parseInt(args[2]));
            feeDetail.setFeeUpperLimit(Integer.parseInt(args[3]));
        }
        if(args.length>4){
            feeDetail.setFeeType(args[4]);
        }
        parkingManager.getParkingLot().getFeeModel().putfeeModel(vehicleName, feeDetail);
    }
}
