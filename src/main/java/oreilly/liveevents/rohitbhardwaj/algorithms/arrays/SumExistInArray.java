package oreilly.liveevents.rohitbhardwaj.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumExistInArray {

    public boolean hasArrayTwoCandidates(int[] arrayInput, int targetSum) {
        int leftPointer = 0;
        int rightPointer = arrayInput.length - 1;

        // !! Array must be sorted
        Arrays.sort(arrayInput);

        // This is the Two Pointers algorithm: indices are meeting in the middle
        while (leftPointer < rightPointer) {
            int sum = arrayInput[leftPointer] + arrayInput[rightPointer];
            if (sum == targetSum) {
                return true;
            } else if (sum < targetSum) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return false;
    }

    public int[] getIndicesOfTwoCandidates(int[] arrayInput, int targetSum) {
        int leftPointer = 0;
        int rightPointer = arrayInput.length - 1;

        Map<Integer, Integer> indexOfPreviousValue = new HashMap<>(); // Record of previous index values as we traverse through the array

        for (int i = 0; i < arrayInput.length; i++) {
            int difference = targetSum - arrayInput[i];
            if (indexOfPreviousValue.containsKey(difference)) {
                return new int[]{indexOfPreviousValue.get(difference), i};
            } else {
                indexOfPreviousValue.put(arrayInput[i], i);
            }
        }

        return null;
    }
}
