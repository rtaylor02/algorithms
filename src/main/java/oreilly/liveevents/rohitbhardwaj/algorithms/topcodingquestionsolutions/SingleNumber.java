package oreilly.liveevents.rohitbhardwaj.algorithms.topcodingquestionsolutions;

import java.util.stream.Stream;

public class SingleNumber {

    public int singleNumber(int[] arrayInput) {
        int uniqueNum = 0;
        for (int i : arrayInput) {
            uniqueNum ^= i; // Essentially addition if different number, subtraction if same number; starting from 0
        }

        return uniqueNum;
    }
}
