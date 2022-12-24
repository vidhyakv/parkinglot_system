package com.parkinglot.util;

import com.parkinglot.model.AirPortFeeModel;
import com.parkinglot.model.MallFeeModel;
import com.parkinglot.model.FeeModel;
import com.parkinglot.model.StadiumFeeModel;

public class FeeModelFactory {

    public static FeeModel getFeeModel(String inputFeeModel) {
        FeeModel feeModel = null;
        switch (inputFeeModel) {
            case "Mall":
                feeModel = new MallFeeModel();
                break;
            case "Stadium":
                feeModel = new StadiumFeeModel();
                break;
            case "Airport":
                feeModel = new AirPortFeeModel();
                break;
            default: break;
        }
        return feeModel;
    }

}