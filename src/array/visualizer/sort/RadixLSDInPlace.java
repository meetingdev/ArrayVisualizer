package array.visualizer.sort;

import static array.visualizer.utils.Analysis.*;
import static array.visualizer.ArrayVisualizer.*;
import static array.visualizer.utils.Swaps.*;

public class RadixLSDInPlace {
    public static void inPlaceRadixLSDSort(int radix)throws Exception{
        int pos = 0;
        int[] vregs = new int[radix-1];
        int maxpower = analyze(radix);
        double smul = Math.sqrt(radix);
        for(int p = 0; p <= maxpower; p++){
            for(int i = 0; i < vregs.length; i++)
                vregs[i]=array.length-1;
            pos = 0;
            for(int i = 0; i < array.length; i++){
                int digit = getDigit(array[pos], p, radix);
                if(digit==0) {
                    pos++;
                    marked.set(0, pos);
                } else {
                    for(int j = 0; j<vregs.length;j++)
                        marked.set(j+1,vregs[j]);
                    swapUpToNM(pos,vregs[digit-1], 0.0011*smul);
                    for(int j = digit-1; j > 0; j--)
                        vregs[j-1]--;
                }
            }
                
        }
    }
}
