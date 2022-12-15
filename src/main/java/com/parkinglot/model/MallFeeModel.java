package com.parkinglot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MallFeeModel extends FeeModel{
    private HashMap<String, Integer> feeModels = new HashMap<>();


    public void putfeeModel(String vehicleName, int feeCost) {
        feeModels.put(vehicleName, feeCost);
    }

}
