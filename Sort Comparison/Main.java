package com.mattnguyencs.sortcomparison;

import java.util.*;
import org.apache.commons.lang3.*;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BasicSorter sorter = new BasicSorter();

		System.out.println("Enter number of words:");
		int n = Integer.parseInt(scan.nextLine());

		System.out.println("Enter length for all words:");
		int wordLength = Integer.parseInt(scan.nextLine());

		String[] unsortedWords = new String[n];
		for (int x = 0; x < n; x++) {
			unsortedWords[x] = RandomStringUtils.randomAlphabetic(wordLength).toUpperCase();
		}

		System.out.print("\nUnsorted Array: [ ");
		for (int u = 0; u < n; u++) {
			if (u != n-1) {
				System.out.print(unsortedWords[u] + ", ");
			} else {
				System.out.print(unsortedWords[u] + " ]\n");
			}
		}
		
		String[] sorted = unsortedWords.clone();
		Arrays.sort(sorted);
		System.out.print("\nSorted Array using JavaUtils: [ ");
		for (int q = 0; q < n; q++) {
			if (q != n-1) {
				System.out.print(sorted[q] + ", ");
			} else {
				System.out.print(sorted[q] + " ]\n");
			}
		}

		String[] testQuick = unsortedWords.clone();
		sorter.quickSort(testQuick,0,n);
		
		System.out.print("\nQuicksorted Array: [ ");
		for (int q = 0; q < n; q++) {
			if (q != n-1) {
				System.out.print(testQuick[q] + ", ");
			} else {
				System.out.print(testQuick[q] + " ]\n");
			}
		}
		
		String[] testInsertion = unsortedWords.clone();
		sorter.insertionSort(testInsertion,0,n);
		
		System.out.print("\nInsertion Sorted Array: [ ");
		for (int i = 0; i < n; i++) {
			if (i != n-1) {
				System.out.print(testInsertion[i] + ", ");
			} else {
				System.out.print(testInsertion[i] + " ]\n");
			}
		}
		
		String[] testMerge = unsortedWords.clone();
		sorter.mergeSort(testMerge,0,n);
		
		System.out.print("\nMerge Sorted Array: [ ");
		for (int m = 0; m < n; m++) {
			if (m != n-1) {
				System.out.print(testMerge[m] + ", ");
			} else {
				System.out.print(testMerge[m] + " ]\n");
			}
		}
		
		String[] testHeap = unsortedWords.clone();
		sorter.heapSort(testHeap);

		System.out.print("\nHeap Sorted Array: [ ");
		for (int h = 0; h < n; h++) {
			if (h != n-1) {
				System.out.print(testHeap[h] + ", ");
			} else {
				System.out.print(testHeap[h] + " ]\n");
			}
		}
		
		System.out.println("\nRun the JUnit test for more test info.");
		
		scan.close();
	}
}
