package com.sinuke.easy;

public class ConvertTemperature {

    public double[] convertTemperature(double celsius) {
        return new double[] {celsius + 273.15, celsius * 1.8 + 32};
    }

}
