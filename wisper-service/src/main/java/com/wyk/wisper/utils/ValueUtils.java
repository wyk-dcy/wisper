package com.wyk.wisper.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author Qingshan Qin
 */
public final class ValueUtils {
    private ValueUtils() {
    }

    public static double round(double value, int numberOfDecimals) {
        BigDecimal valueAsBigDecimal = (new BigDecimal(value)).setScale(numberOfDecimals, RoundingMode.FLOOR);
        return valueAsBigDecimal.doubleValue();
    }

    public static double[] round(double[] values, int numberOfDecimals) {
        double[] newVal = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            newVal[i] = round(values[i], numberOfDecimals);
        }
        return newVal;
    }

    public static double roundUp(double value, int numberOfDecimals) {
        BigDecimal valueAsBigDecimal = (new BigDecimal(value)).setScale(numberOfDecimals, RoundingMode.HALF_UP);
        return valueAsBigDecimal.doubleValue();
    }

    public static double[] roundUp(double[] values, int numberOfDecimals) {
        double[] newVal = new double[values.length];
        for (int i = 0; i < values.length; i++) {
            newVal[i] = roundUp(values[i], numberOfDecimals);
        }
        return newVal;
    }

    public static int byteToInt(byte b) {
        return b & 0xff;
    }

    public static double[] toRadians(double[] degrees) {
        checkArgument(degrees.length > 0);
        double[] radians = new double[degrees.length];
        for (int i = 0; i < degrees.length; i++) {
            radians[i] = Math.toRadians(degrees[i]);
        }
        return radians;
    }

    public static double toRadians(double degree) {
        return Math.toRadians(degree);
    }

    public static double[] toDegrees(double[] radians) {
        checkArgument(radians.length > 0);
        double[] degrees = new double[radians.length];
        for (int i = 0; i < degrees.length; i++) {
            degrees[i] = Math.toDegrees(radians[i]);
        }
        return degrees;
    }

    public static double toDegrees(double radian) {
        return Math.toDegrees(radian);
    }
}
