package sorts;

import templates.Sort;
import utils.*;

import java.awt.*;
/*
DO Time: Not Tested
AddMarks: Working
 */
// Code refactored from Python: http://wiki.c2.com/?SlowSort

final public class OptimizedSlowSort extends Sort {
    public OptimizedSlowSort(Delays delayOps, Highlights markOps, Reads readOps, Writes writeOps) {
        super(delayOps, markOps, readOps, writeOps);

        this.setSortPromptID("Optimized Slow");
        this.setRunAllID("Optimized Slow Sort");
        this.setReportSortID("Optimized SlowSort");
        this.setCategory("Exchange Sorts");
        this.isComparisonBased(true);
        this.isBucketSort(false);
        this.isRadixSort(false);
        this.isUnreasonablySlow(true);
        this.setUnreasonableLimit(512);
        this.isBogoSort(false);
    }



    private void optslowsort(int[] A, int i, int j) {

        if (j <= 1) return;

        optslowsort(A,i + 1, j - 1);

        if (Reads.compare(A[i], A[i+1]) == 1)
        {
            Delays.sleep(0.025);
            Writes.swap(A, i, i + 1, 1, true, false);

            optslowsort(A, i + 1, j);
        }

    }


    @Override
    public void runSort(int[] array, int currentLength, int bucketCount) {
        this.optslowsort(array, 0, currentLength - 1);
    }
}