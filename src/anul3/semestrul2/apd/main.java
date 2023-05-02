package anul3.semestrul2.apd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class main {
	public static void main(String[] args) throws IOException {
		int i=0;
		QuicksortSecvential quicksortSecvential = new QuicksortSecvential();
		BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		String line;
		FileWriter writer = new FileWriter("output.txt");
		double duration;
		long endTime;
		long startTime;
		while ((line = reader.readLine()) != null) {
			int[] arr = quicksortSecvential.readArrayFromString(line);
			
			//Secvential
			
			/*
	         startTime = System.nanoTime();
	        quicksortSecvential.quickSort(arr, 0, arr.length - 1);
	         endTime = System.nanoTime();
	         duration = (endTime - startTime) / 1_000_000.0;
	        writer.write("Durata sortarii "+i +" : " + duration + " ms\n");*/
			/*
			 //Join/Fork
			  
	        QuicksortForkJoin quicksort = new QuicksortForkJoin(arr, 0, arr.length - 1);
	        ForkJoinPool pool = new ForkJoinPool();
	        startTime = System.nanoTime();
	        pool.invoke(quicksort);
	        endTime = System.nanoTime();
	        duration = (endTime - startTime) / 1_000_000.0;
	        writer.write("Durata sortarii fork "+i +" : " + duration + " ms\n");
			 */
			
			//Threads Concurrency
			
			/*
			int availableCores = Runtime.getRuntime().availableProcessors();
			QuicksortThread quicksortThread = new QuicksortThread(arr, 0,arr.length - 1,availableCores);
			startTime = System.nanoTime();
			quicksortThread.start();
			try {
				quicksortThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1_000_000.0;
			writer.write("Durata sortarii thread concurrency "+i +" : " + duration + " ms\n");
			*/
			
			//Parallel Streams
			
			 startTime=System.nanoTime();
	       	 Arrays.parallelSort(arr);	
	         endTime = System.nanoTime();
		     duration = (endTime - startTime) / 1_000_000.0;
		     writer.write("Durata sortarii parallelStreams "+i +" : " + duration + " ms\n");
			  i++;

		}
		reader.close();
		writer.close();

	}}
