package project1;

import java.text.DecimalFormat;
import java.util.Random;

public class CompareAlgorithms {
	//adding a comment to trigger the build
	
	public static void main(String args[]) {
		long inversionsBefore, inversionsAfter;
		double ratio;
		DecimalFormat format = new DecimalFormat("##.000");
		CompareAlgorithms compute = new CompareAlgorithms();
		
		System.out.println("Test Sample - size: 10");
		int[] sampleTest = generateRandomNumbers(10);
		System.out.print("Unsorted array: ");
		for (int i = 0; i < sampleTest.length; i++) {
			System.out.print(sampleTest[i] + " ");
		}
		System.out.println();
		compute.testingSortFunctions(sampleTest);		
		
		System.out.println("\nTest Sample - size: 20");
		int[] sampleTestTwo = generateRandomNumbers(20);
		System.out.print("Unsorted array: ");
		for (int i = 0; i < sampleTestTwo.length; i++) {
			System.out.print(sampleTestTwo[i] + " ");
		}
		System.out.println();
		compute.testingSortFunctions(sampleTestTwo);		
		
		System.out.println("\nSample size: 100");
		int[] sampleOne = generateRandomNumbers(100);
		inversionsBefore = compute.computeNumOfInversions(sampleOne);
		compute.lowerMedianViaMergeSort(sampleOne);		
		inversionsAfter = compute.lowerMedianViaSelection(sampleOne);
		ratio = (double)inversionsAfter/inversionsBefore;
		System.out.println("No of inversions - before: " + inversionsBefore + " after: " + inversionsAfter 
				+ " ratio: " + format.format(ratio));
		
		System.out.println("\nSample size: 1,000");
		int[] sampleTwo = generateRandomNumbers(1000);
		inversionsBefore = compute.computeNumOfInversions(sampleTwo);
		compute.lowerMedianViaMergeSort(sampleTwo);
		inversionsAfter = compute.lowerMedianViaSelection(sampleTwo);
		ratio = (double)inversionsAfter/inversionsBefore;
		System.out.println("No of inversions - before: " + inversionsBefore + " after: " + inversionsAfter 
				+ " ratio: " + format.format(ratio));
		
		System.out.println("\nSample size: 10,000");
		int[] sampleThree = generateRandomNumbers(10000);
		inversionsBefore = compute.computeNumOfInversions(sampleThree);
		compute.lowerMedianViaMergeSort(sampleThree);
		inversionsAfter = compute.lowerMedianViaSelection(sampleThree);
		ratio = (double)inversionsAfter/inversionsBefore;
		System.out.println("No of inversions - before: " + inversionsBefore + " after: " + inversionsAfter 
				+ " ratio: " + format.format(ratio));
		
		System.out.println("\nSample size: 100,000");
		int[] sampleFour = generateRandomNumbers(100000);
		inversionsBefore = compute.computeNumOfInversions(sampleFour);
		compute.lowerMedianViaMergeSort(sampleFour);
		inversionsAfter = compute.lowerMedianViaSelection(sampleFour);
		ratio = (double)inversionsAfter/inversionsBefore;
		System.out.println("No of inversions - before: " + inversionsBefore + " after: " + inversionsAfter 
				+ " ratio: " + format.format(ratio));
		
		System.out.println("\nSample size: 1,000,000");
		int[] sampleFive = generateRandomNumbers(1000000);
		compute.lowerMedianViaMergeSort(sampleFive);
		compute.lowerMedianViaSelection(sampleFive);
	}
	
	public void lowerMedianViaMergeSort(int[] array) {
		long startTime, endTime;
		startTime = System.currentTimeMillis(); 
		
		MergeSort m = new MergeSort(); 
		int[] sortedArray = m.mergeSort(array, 0, array.length - 1);
		int median = sortedArray[(array.length/2) - 1];

		endTime = System.currentTimeMillis(); 
		System.out.println("Median: " + median +   " MergeSort - Processing time (msec): " + (endTime - startTime));
	}
	
	public long lowerMedianViaSelection(int[] array) {
		long startTime, endTime;
		startTime = System.currentTimeMillis(); 

		SelectionViaPartition selection = new SelectionViaPartition();
		int[] sortedArray = selection.selectionViaPartition(array, (array.length/2) - 1);
		int median = sortedArray[(array.length/2) - 1];
		
		endTime = System.currentTimeMillis(); 
		System.out.println("Median: " + median +   " Selection - Processing time (msec): " + (endTime - startTime));
		
		long inversionsAfter =  computeNumOfInversions(sortedArray);
		return inversionsAfter;
	}
	
	public long computeNumOfInversions(int[] array) {
		long count = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
			    if (array[i] > array[j]) {
			    	count++;
			    }
			}
		}
		return count;	
	}
	
	public void testingSortFunctions(int[] array) {
		MergeSort m = new MergeSort(); 
		int[] sortedArray = m.mergeSort(array, 0, array.length - 1);
		System.out.print("MergeSort \nSorted array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
		int median = sortedArray[(array.length/2) - 1];
		System.out.println("\nMedian: " + median); 
		
		SelectionViaPartition selection = new SelectionViaPartition();
		sortedArray = selection.selectionViaPartition(array, (array.length/2) - 1);
		System.out.print("Selection \nSorted array: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(sortedArray[i] + " ");
		}
		median = sortedArray[(array.length/2) - 1];
		System.out.println("\nMedian: " + median);
	}
	
	public static int[] generateRandomNumbers(int size) {
		Random random = new Random();
		int[] array = new int[size];
		for(int i = 0; i < size; i++) {
			array[i] = random.nextInt(1000);
		}
		
		return array;
	}
}
