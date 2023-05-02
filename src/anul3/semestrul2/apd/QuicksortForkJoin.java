package anul3.semestrul2.apd;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class QuicksortForkJoin extends RecursiveAction {
    private final int[] array;
    private final int left;
    private final int right;

    public QuicksortForkJoin(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            QuicksortForkJoin leftTask = new QuicksortForkJoin(array, left, pivotIndex - 1);
            QuicksortForkJoin rightTask = new QuicksortForkJoin(array, pivotIndex + 1, right);
            invokeAll(leftTask, rightTask);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
