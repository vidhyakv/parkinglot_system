package com.parkinglot.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FeeModel {


    private static FeeModel feeModel = new FeeModel();

    public static FeeModel getInstance() {
        return feeModel;
    }

}
