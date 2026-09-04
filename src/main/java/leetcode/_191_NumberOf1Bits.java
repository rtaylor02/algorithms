package leetcode;

public class _191_NumberOf1Bits {
    public int hammingWeight(int n) {
        int total1Bits = 0;

        // The remainder of the bit shift operation is technically the bit that is discarded.
        // e.g. 11 (1011) >> 1 ==> 101 remainder 1
        // 101 >> 1 ==> 10 remainder 1
        // 10 >> 1 ==> 1 remainder 0
        // 1 >> 1 ==> 0 remainder 1
        while (n >= 1) {
            int remainder = n % 2;
            n = n / 2;

            if ((n >= 0) && (remainder == 1)) {
                total1Bits++;
            }
        }

        return total1Bits;
    }

    public int hammingWeight2(int n) {
        int total1Bits = 0;

        // n & 1 ==> determines if the least significant digit is 1.
        // If so, we have detected bit 1. We need to keep shifting left to check all bits until n = 0.
        while (n > 0) {
            total1Bits = ((n & 1) == 1) ? total1Bits + 1 : total1Bits;
            n >>= 1;
        }

        return total1Bits;
    }
}
