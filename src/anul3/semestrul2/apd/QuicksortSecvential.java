package anul3.semestrul2.apd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class QuicksortSecvential {

	   public static void quickSort(int[] arr, int left, int right) {
	        if (left < right) {
	            int pivot = partition(arr, left, right);
	            quickSort(arr, left, pivot - 1);
	            quickSort(arr, pivot + 1, right);
	        }
	    }

	    public static int partition(int[] arr, int left, int right) {
	        int pivot = arr[right];
	        int i = left - 1;
	        for (int j = left; j < right; j++) {
	            if (arr[j] <= pivot) {
	                i++;
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        int temp = arr[i + 1];
	        arr[i + 1] = arr[right];
	        arr[right] = temp;
	        return i + 1;
	    }

	    public static int[] readArrayFromString(String str) throws IOException {
	    	String[] values = str.split(" ");
	        int[] arr = Arrays.stream(values).mapToInt(Integer::parseInt).toArray();
	        return arr;
	    }

	    public static void writeArrayToFile(String filename, int[] arr) throws IOException {
	        FileWriter writer = new FileWriter(filename);
	        for (int i = 0; i < arr.length; i++) {
	            writer.write(Integer.toString(arr[i]) + " ");
	        }
	        writer.close();
	    }
	}

