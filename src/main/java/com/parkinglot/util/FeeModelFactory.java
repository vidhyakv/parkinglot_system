package com.parkinglot.util;

import com.parkinglot.model.AirPortFeeModel;
import com.parkinglot.model.MallFeeModel;
import com.parkinglot.model.FeeModel;

public class FeeModelFactory {

    public static FeeModel getFeeModel(String inputFeeModel) {
        FeeModel feeModel = null;
        switch (inputFeeModel) {
            case "Mall":
                feeModel = new MallFeeModel();
            case "Stadium":
                feeModel = new MallFeeModel();
            case "Airport":
                feeModel = new AirPortFeeModel();
            default: break;
        }
        return feeModel;
    }

}