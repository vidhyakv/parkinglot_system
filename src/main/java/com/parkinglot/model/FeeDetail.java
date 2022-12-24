package com.parkinglot.model;

public class FeeDetail {

    private int feeValue;

    private int feeLowerLimit;


    private int feeUpperLimit;

    public int getFeeValue() {
        return feeValue;
    }

    public void setFeeValue(int feeValue) {
        this.feeValue = feeValue;
    }

    public int getFeeLowerLimit() {
        return feeLowerLimit;
    }

    public void setFeeLowerLimit(int feeLowerLimit) {
        this.feeLowerLimit = feeLowerLimit;
    }

    public int getFeeUpperLimit() {
        return feeUpperLimit;
    }

    public void setFeeUpperLimit(int feeUpperLimit) {
        this.feeUpperLimit = feeUpperLimit;
    }

    @Override
    public String toString() {
        return "FeeDetail{" +
                "feeValue=" + feeValue +
                ", feeLowerLimit=" + feeLowerLimit +
                ", feeUpperLimit='" + feeUpperLimit + '\'' +
                '}';
    }
}
