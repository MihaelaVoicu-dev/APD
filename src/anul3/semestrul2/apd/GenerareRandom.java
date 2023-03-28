package anul3.semestrul2.apd;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerareRandom {

	  public  int[] generateRandomArray(int size, int minValue, int maxValue) {
	        Random random = new Random();
	        int[] arr = new int[size];
	        for (int i = 0; i < size; i++) {
	            arr[i] = random.nextInt(maxValue - minValue + 1) + minValue;
	        }
	        return arr;
	    }

	    public static void writeArrayToFile(int[] arr, String filename) throws IOException {
	    	   FileWriter writer = new FileWriter(filename, true);
	    	    for (int i = 0; i < arr.length; i++) {
	    	        writer.write(arr[i] + " ");
	    	    }
	    	    writer.write(System.lineSeparator());
	    	    writer.close();
	    }
}
