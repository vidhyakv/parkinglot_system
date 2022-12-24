package com.parkinglot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FeeModel {
    protected static HashMap<Vehicle, FeeDetail> feeModels = new HashMap<>();

    public abstract void putfeeModel(String vehicleName, FeeDetail feeDetail);

    public abstract int calculateFee(int hours, String vehicleName) throws Exception;

    protected List<Vehicle> getVehicleModels(String vehicleName){
        List<Vehicle> vehicleFeeModels = feeModels.keySet().stream().filter(element -> element.getName().equals(vehicleName)).collect(Collectors.toList());
        return vehicleFeeModels;
    }

    public static HashMap<Vehicle, FeeDetail> getFeeModels() {
        return feeModels;
    }

    public static void setFeeModels(HashMap<Vehicle, FeeDetail> feeModels) {
        FeeModel.feeModels = feeModels;
    }
}
