package com.parkinglot.model;

import com.parkinglot.util.MathUtility;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class AirPortFeeModel extends FeeModel{

    public void putfeeModel(String vehicleName, FeeDetail feeDetail) {
        feeModels.put(new Vehicle(vehicleName), feeDetail);
    }

    public int calculateFee(int hours, String vehicleName, HashMap<Vehicle, FeeDetail> localFeeModels) throws Exception {
        List<Vehicle> vehicles = getVehicleModels(vehicleName, localFeeModels);
        int days = com.parkinglot.util.MathUtility.roundOff((float) hours/24);
        for (Vehicle vehicle : vehicles) {
            FeeDetail feeDetail = localFeeModels.get(vehicle);
            if (hours <24) {
                if(hours > feeDetail.getFeeLowerLimit() && hours < feeDetail.getFeeUpperLimit()) {
                    return feeDetail.getFeeValue();
                }else{
                    continue;
                }
            }else{
                if (feeDetail.getFeeType().equals("per-day")){
                    return feeDetail.getFeeValue() * days;
                }else{
                    continue;
                }
            }
        }
        return 0;
    }
}
