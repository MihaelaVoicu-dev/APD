package anul3.semestrul2.apd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class main {
	public static void main(String[] args) throws IOException {
		 /*--input1 in functie de nr elemente
	 		int [] array = new int[1000];
	 		for(int i = 999; i >= 0; i--){
	 			array[999 - i] = i;
	 		}
	 		
		 	HelperArray generareRandom = new HelperArray();
		 	generareRandom.writeArrayToFile(array, "input.txt");
		 	
		 	for(int i=1;i<=10;i++) {
		 		int [] array1 =generareRandom.generateRandomArray(5000*i, 0, 20000);
		 		generareRandom.writeArrayToFile(array1, "input.txt");
		 	}
		 	*/
		 	int i=0;
		 	QuicksortSecvential quicksortSecvential = new QuicksortSecvential();
	        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
	        String line;
	        FileWriter writer = new FileWriter("output.txt");
	        
	        while ((line = reader.readLine()) != null) {
	            int[] arr = quicksortSecvential.readArrayFromString(line);
	        
	        long startTime = System.nanoTime();
	        quicksortSecvential.quickSort(arr, 0, arr.length - 1);
	        long endTime = System.nanoTime();
	        i++;
	        double duration = (endTime - startTime) / 1_000_000.0;
	       
	        writer.write("Durata sortarii "+i +" : " + duration + " ms\n");
	        
	    }
	        reader.close();
	        writer.close();
}}
