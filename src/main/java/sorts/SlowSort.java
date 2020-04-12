package sorts;

import templates.Sort;
import utils.*;

import java.awt.*;
/*
DO Time: Not Tested
AddMarks: Working
 */
// Code refactored from Python: http://wiki.c2.com/?SlowSort

final public class SlowSort extends Sort {
    public SlowSort(Delays delayOps, Highlights markOps, Reads readOps, Writes writeOps) {
        super(delayOps, markOps, readOps, writeOps);
        
        this.setSortPromptID("Slow");
        this.setRunAllID("Slow Sort");
        this.setReportSortID("Slowsort");
        this.setCategory("Exchange Sorts");
        this.isComparisonBased(true);
        this.isBucketSort(false);
        this.isRadixSort(false);
        this.isUnreasonablySlow(true);
        this.setUnreasonableLimit(512);
        this.isBogoSort(false);
    }
    
	private void slowSort(int[] A, int i, int j) {
		if (i >= j) {
			return;
		}
	
	    int m = i + ((j - i) / 2);

	    Highlights.markArray(Highlights.getMaximumLength() + 1, m);

	    this.slowSort(A, i, m);
	    this.slowSort(A, m + 1, j);
        Delays.sleep(0.025);

	    if (Reads.compare(A[m], A[j]) == 1) {
	        Writes.swap(A, m, j, 1, true, false);
	    }

        Highlights.markArray(j, j, Color.GREEN, Mark.TYPE_SORTED);
        Highlights.markArray(j-1, j-1, Color.GREEN, Mark.TYPE_SORTED);


	    Highlights.markArray(Highlights.getMaximumLength() + 1, j);
	    Highlights.markArray(Highlights.getMaximumLength() + 2, m);
	    this.slowSort(A, i, j - 1);
        Highlights.clearMarks(i, j, Mark.TYPE_SORTED);
	}

    @Override
    public void runSort(int[] array, int currentLength, int bucketCount) {
        this.slowSort(array, 0, currentLength - 1);
    }
}