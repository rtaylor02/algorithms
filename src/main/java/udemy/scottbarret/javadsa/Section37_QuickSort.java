package udemy.scottbarret.javadsa;


import java.util.Arrays;

public class Section37_QuickSort {
    private static class QuickSort {
        private static int pivot(int[] array, int pivotIndex, int endIndex) {
            int swapIndex = pivotIndex;
            for (int i = pivotIndex + 1; i <= endIndex; i++) {
                if (array[i] < array[pivotIndex]) {
                    swapIndex++;
                    swap(array, swapIndex, i);
                    System.out.println(Arrays.toString(array));
                }
            }
            System.out.println("==== swap <==> pivot ====");
            swap(array, pivotIndex, swapIndex);
            System.out.println(Arrays.toString(array));

            return swapIndex;
        }

        private static void swap(int[] array, int destination, int origin) {
            System.out.printf("--- Swap: %d <--> %d ---\n", origin, destination);
            int temp = array[destination];
            array[destination] = array[origin];
            array[origin] = temp;
        }

        private static void quickSort(int[] array, int left, int right) {
            if (left < right) {
                int pivotIndex = pivot(array, left, right);
                quickSort(array, left, pivotIndex - 1);
                quickSort(array, pivotIndex + 1, right);
            }

        }

        public static void main(String[] args) {
            int[] array = {4, 6, 1, 7, 3, 2, 8, 5};
            System.out.println(Arrays.toString(array));
            QuickSort.quickSort(array, 0, array.length - 1);

            //int[] array2 = {2, 1, 3};
            //System.out.println(Arrays.toString(array2));
            //QuickSort.pivot(array2, 0, 6);
        }
    }
}
