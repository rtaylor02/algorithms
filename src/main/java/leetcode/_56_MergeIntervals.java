package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        /*
        For simplicity, we will use alphanumerical value for pointing to an array value: x0 ==> {a, b, c, ...} where a = {0, 1, ...}.
        E.g. {{10, 20}, {30, 40}}: a0 = 10, a1 = 20, b0 = 30, b1 = 40
        Steps:
        1) Sort intervals: based on first index of each array
        2) Check overlap between merged's last array and next intervals' next array.
        3) Modify merged's last array if overlaps; add to merged if not.
        4) Continue with the next iteration
         */
        //sort(intervals);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] mergedLast = merged.getLast();
            int[] temp = intervals[i];
            if (temp[0] <= mergedLast[1]) {
                mergedLast[1] = Math.max(mergedLast[1], temp[1]);
            } else {
                merged.add(temp);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    private void sort(int[][] multiDimensionalArray) {
        for (int i = 0; i < multiDimensionalArray.length; i++) {
            for (int j = i + 1; j < multiDimensionalArray.length; j++) {
                if (multiDimensionalArray[j][0] < multiDimensionalArray[i][0]) {
                    int[] temp = multiDimensionalArray[i];
                    multiDimensionalArray[i] = multiDimensionalArray[j];
                    multiDimensionalArray[j] = temp;
                }
            }
        }
    }
}
