package com.parkinglot.model;

import com.parkinglot.util.MathUtility;

public class StadiumFeeModel extends FeeModel{

    public void putfeeModel(String vehicleName, FeeDetail feeDetail) {
        feeModels.put(new Vehicle(vehicleName), feeDetail);
    }

    public int calculateFee(int hours, String vehicleName) throws Exception {
        for (Vehicle vehicle : getVehicleModels(vehicleName)) {
            FeeDetail feeDetail = feeModels.get(vehicle);
            if(hours > feeDetail.getFeeLowerLimit() && feeDetail.getFeeUpperLimit()==0){
                return feeDetail.getFeeValue() * hours;
            }else if(hours < feeDetail.getFeeUpperLimit() && hours > feeDetail.getFeeLowerLimit()) {
                return feeDetail.getFeeValue();
            }else{
                continue;
            }
        }
        return 0;
    }
}
