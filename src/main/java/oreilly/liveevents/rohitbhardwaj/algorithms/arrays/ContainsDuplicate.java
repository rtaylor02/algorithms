package oreilly.liveevents.rohitbhardwaj.algorithms.arrays;

import java.util.HashSet;
import java.util.stream.Stream;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] input) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : input) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
