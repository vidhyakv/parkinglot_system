package com.parkinglot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MallFeeModel extends FeeModel{


    public void putfeeModel(String vehicleName, FeeDetail feeDetail) {
        feeModels.put(new Vehicle(vehicleName), feeDetail);
    }

    public int calculateFee(int hours, String vehicleName) throws Exception {
        for (Vehicle vehicle : getVehicleModels(vehicleName)) {
            FeeDetail feeDetail = feeModels.get(vehicle);
            if (feeDetail != null) {
                return hours * feeDetail.getFeeValue();
            } else {
                throw new Exception("Fee Model is not configured for specified vehicle");
            }
        }
        return 0;
    }
}
