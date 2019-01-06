package array.visualizer.utils;

import static array.visualizer.ArrayVisualizer.*;

/**
 *
 * @author S630690
 */
public class Swaps {
    public static void swap(int[] a, int i, int j) {
        marked.set(1, i);
        marked.set(2, j);
        aa+=2;
            //if(Math.random()*8<1.0)
                //sleep(1);
        // TODO Auto-generated method stub
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void swap(int[] a, int i, int j, double pause) {
        marked.set(1, i);
        marked.set(2, j);
        aa+=2;
        sleep(pause);
        // TODO Auto-generated method stub
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void swapnm(int[] a, int i, int j, double pause) {
        sleep(pause);
        aa+=2;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
        
    public static void swapUpTo(int pos, int to, double pause){
        if(to - pos > 0)
            for(int i = pos; i < to; i++)
                swap(array, i, i+1, pause);
        else
            for(int i = pos; i > to; i--)
                swap(array, i, i-1, pause);
    }
    
    public static void swapUpToNM(int pos, int to, double pause){
        if(to - pos > 0)
         for(int i = pos; i < to; i++)
            swapnm(array, i, i+1, pause);
        else
            for(int i = pos; i > to; i--)
                swapnm(array, i, i-1, pause);
    }
    
    public static void swapUp(int pos, double pause) {
        for(int i = pos; i < array.length; i++)
            swap(array, i, i+1, pause);
    }
}
