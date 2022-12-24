package com.parkinglot.model;

import com.parkinglot.util.MathUtility;

import java.util.List;
import java.util.stream.Collectors;

public class AirPortFeeModel extends FeeModel{

    public void putfeeModel(String vehicleName, FeeDetail feeDetail) {
        feeModels.put(new Vehicle(vehicleName), feeDetail);
    }

    public int calculateFee(int hours, String vehicleName) throws Exception {
        for (Vehicle vehicle : getVehicleModels(vehicleName)) {
            FeeDetail feeDetail = feeModels.get(vehicle);
            if(hours > feeDetail.getFeeLowerLimit() && feeDetail.getFeeUpperLimit()==0){
                return feeDetail.getFeeValue() * MathUtility.roundOff((float)hours/24);
            }else if(hours < feeDetail.getFeeUpperLimit() && hours > feeDetail.getFeeLowerLimit()) {
                return feeDetail.getFeeValue();
            }else{
                return 0;
            }
        }
        return 0;
    }
}
