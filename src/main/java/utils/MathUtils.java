package utils;

public class MathUtils {
    public static int RandomInt(int min, int max) {
        return (int) (Math.random() * (max - min) + min);
    }
}
