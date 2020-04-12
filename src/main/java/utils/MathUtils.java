package utils;

import java.math.BigInteger;

public class MathUtils {
    public static int RandomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
    public static long getDecimal(double value, int toFixed){
        String tmp = "0."+String.valueOf(value).split("\\.")[1];
        int lastIndex = Math.min(tmp.length(), toFixed + 2);
        tmp = tmp.substring(0, lastIndex);
        float decimal = Float.parseFloat(tmp);

        return (long) (decimal * BigInteger.valueOf(10).pow(lastIndex - 2).intValue());
    }
}
