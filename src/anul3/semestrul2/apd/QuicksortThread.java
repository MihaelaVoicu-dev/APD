package anul3.semestrul2.apd;

import java.util.Arrays;

public class QuicksortThread extends Thread {
	private final int[] array;
    private final int left;
    private final int right;
    private final int threads;

    public QuicksortThread(int[] array, int left, int right, int threads) {
        this.array = array;
        this.left = left;
        this.right = right;
        this.threads = threads;
    }

    @Override
    public void run() {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            int numThreads = Math.min(threads, right - left + 1);
            int size = (right - left + 1) / numThreads;
            Thread[] threadsArr = new Thread[numThreads];
            int start = left;
            int end;
            for (int i = 0; i < numThreads; i++) {
                end = start + size - 1;
                if (i == numThreads - 1) {
                    end = right;
                }
                threadsArr[i] = new QuicksortThread(array, start, end, threads);
                threadsArr[i].start();
                start = end + 1;
            }
            try {
                for (int i = 0; i < numThreads; i++) {
                	threadsArr[i].join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
