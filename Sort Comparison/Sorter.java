package com.mattnguyencs.sortcomparison;

public interface Sorter {

	/**
	 * Uses the insertion sort algorithm to sort part or all of a list in ascending
	 * order.
	 * 
	 * @param data
	 *            The list of elements to sort
	 * @param fi
	 *            Index of the first element to be sorted.
	 * @param n
	 *            The number of elements in the section to be sorted.
	 */
	public void insertionSort(String[] data, int fi, int n);


	/**
	 * Uses the quick sort algorithm to sort all or part of the data in ascending
	 * order. quickSort calls insertion sort for segments of size 15 or less and
	 * calls on partition function to do its partitioning.
	 * 
	 * @param data
	 *            The list of elements to sort
	 * @param fi
	 *            Index of the first element to be sorted.
	 * @param n
	 *            The number of elements in the section to be sorted.
	 */
	public void quickSort(String[] data, int fi, int n);


	/**
	 * Partitions part (or all) of the list. The range of indices included in the
	 * partitioning is [firstIndex, firstIndex + numberToPartition -1].
	 * 
	 * partition uses the median-of-three method to prevent O(n^2)
	 * running time for sorted data sets.
	 * 
	 * 
	 * 
	 * @param data
	 * @param fi
	 * @param n
	 * @return The index, relative to data[0], where the pivot value is located at
	 *         the end of this partitioning.
	 */
	public int partition(String[] data, int fi, int n);


	/**
	 * Uses the merge sort algorithm to sort part or all of a list in ascending
	 * order. It calls insertionSort on segments of size 15 or less and calls
	 * on the merge function to do its merging.
	 * 
	 * @param data
	 *            list of elements to sort
	 * @param fi
	 *            Index of the first element to be sorted.
	 * @param n
	 *            The number of elements in the section to be sorted.
	 */
	public void mergeSort(String[] data, int fi, int n);


	/**
	 * Merges two sorted segments into a single sorted segment. The left and right
	 * segments are contiguous.
	 * 
	 * @param data
	 *            The list of elements to merge
	 * @param fi
	 *            Index of the first element of the left segment.
	 * @param nl
	 *            The number of elements in the left segment.
	 * @param nr
	 *            The number of elements in the right segment.
	 */
	public void merge(String[] data, int fi, int nl, int nr);


	/**
	 * 
	 * Use the heap sort algorithm to sort the list in ascending order. This method
	 * uses the heapify method for initial heapification.
	 * 
	 * @param data
	 *            The list of elements to sort
	 */
	public void heapSort(String[] data);


	/**
	 * 
	 * Heapifies the given list.
	 * 
	 * @param data
	 *            The list to heapify.
	 */
	public void heapify(String[] data);
}