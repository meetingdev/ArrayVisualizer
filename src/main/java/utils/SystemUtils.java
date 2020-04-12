package utils;

public class SystemUtils {
    public static void sleepInNanos(int nanos){
        long start = System.nanoTime();
        long end=0;
        do{
            end = System.nanoTime();
        }while(start + (long) nanos >= end);
    }
}
