package com.parkinglot.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FeeModel {
    protected static HashMap<Vehicle, FeeDetail> feeModels = new LinkedHashMap<>();

    public abstract void putfeeModel(String vehicleName, FeeDetail feeDetail);

    public abstract int calculateFee(int hours, String vehicleName, HashMap<Vehicle, FeeDetail> localFeeModels) throws Exception;

    protected List<Vehicle> getVehicleModels(String vehicleName, HashMap<Vehicle, FeeDetail> localFeeModels) {
        List<Vehicle> vehicleFeeModels = localFeeModels.keySet().stream().filter(element -> element.getName().equals(vehicleName)).collect(Collectors.toList());
        return vehicleFeeModels;
    }

    public static HashMap<Vehicle, FeeDetail> getFeeModels() {
        return feeModels;
    }

    public HashMap<Vehicle, FeeDetail> getLocalFeeModels() {
        HashMap<Vehicle, FeeDetail> localFeeModels = new LinkedHashMap<>(feeModels);
        return localFeeModels;
    }


}
