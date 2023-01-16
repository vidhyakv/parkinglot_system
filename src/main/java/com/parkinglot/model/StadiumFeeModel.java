package com.parkinglot.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StadiumFeeModel extends FeeModel{

    public void putfeeModel(String vehicleName, FeeDetail feeDetail) {
        feeModels.put(new Vehicle(vehicleName), feeDetail);
    }

    public int calculateFee(int hours, String vehicleName, HashMap<Vehicle, FeeDetail> localFeeModels) throws Exception {
        List<Vehicle> vehicles = getVehicleModels(vehicleName, localFeeModels);

        for (Vehicle vehicle : vehicles) {
                FeeDetail feeDetail = localFeeModels.get(vehicle);
                if (hours > 0) {
                    int remainingHours = hours - (feeDetail.getFeeUpperLimit() - feeDetail.getFeeLowerLimit());
                    localFeeModels.remove(vehicle);
                    if (remainingHours > 0) {
                        int currentFee = 0;
                        if (feeDetail.getFeeType() != null && feeDetail.getFeeType().equals("per-hour")) {
                            currentFee = feeDetail.getFeeValue() * hours;
                        } else {
                            currentFee = feeDetail.getFeeValue();
                        }
                        return currentFee + calculateFee(remainingHours, vehicleName, localFeeModels);
                    } else {
                        return feeDetail.getFeeValue();
                    }
                }
        }
        return 0;
    }
}