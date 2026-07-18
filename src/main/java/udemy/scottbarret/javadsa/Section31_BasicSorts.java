package udemy.scottbarret.javadsa;

public class Section31_BasicSorts {
    private static class BubbleSort {
        private void bubbleSort(int... array) {
            boolean swapHappened = true;
            int totalIteration = 0;
            while (swapHappened) {
                totalIteration++;
                swapHappened = false;
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        int temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                        swapHappened = true;
                    }
                }
            }
            System.out.println("Total iteration: " + totalIteration);
        }

        public static void main(String... args) {
            //int[] unsorted = {4, 2, 6, 5, 1, 3};
            int[] sorted = {1, 2, 3, 4, 5, 6};
            int[] unsorted = {6, 5, 4, 3, 2, 1};
            new Section31_BasicSorts.BubbleSort().bubbleSort(unsorted);
            new Section31_BasicSorts.BubbleSort().bubbleSort(sorted);
        }
    }
}
