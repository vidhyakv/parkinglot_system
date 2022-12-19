package com.parkinglot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class FeeModel {
    protected static HashMap<String, Integer> feeModels = new HashMap<>();

    public abstract void putfeeModel(String vehicleName, int feeValue);

}
