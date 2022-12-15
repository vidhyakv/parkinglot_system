package com.parkinglot.util;

import com.parkinglot.model.MallFeeModel;
import com.parkinglot.model.FeeModel;

public class FeeModelFactory {
	
	public static FeeModel getFeeModel(String feeModel) {
		switch(feeModel) {
		case "Mall":
			MallFeeModel.getInstance();
			break;
		case "Stadium":
			break;
		case "Airport":
			break;
		}
		return FeeModel.getInstance();
	}

}
