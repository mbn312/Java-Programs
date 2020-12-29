package com.mattnguyencs.sortcomparison;

public class BasicSorter implements Sorter {

	@Override
	public void insertionSort(String[] data, int fi, int n) {
		for (int i = fi + 1; i <= fi + n - 1; i++) {
			String temp = data[i];
			int ProperNdx = i - 1;
			while (ProperNdx >= fi && temp.compareTo(data[ProperNdx]) < 0) {
				ProperNdx--;
			}
			System.arraycopy(data, ProperNdx + 1, data, ProperNdx + 2, (i - ProperNdx - 1));
			data[ProperNdx + 1] = temp;
		}
	}


	@Override
	public void quickSort(String[] data, int fi, int n) {
		// TODO Auto-generated method stub
		if (n <= 15) {
			insertionSort(data, fi, n);
		} else {
			if (n > 1) {
				int partition = partition(data, fi, n);
				int left = partition - fi;
				int right = (fi + n - partition - 1);
				quickSort(data, fi, left);
				quickSort(data, partition + 1, right);
			}
		}
	}


	@Override
	public int partition(String[] data, int fi, int n) {
		// TODO Auto-generated method stub
		String pivot = getMedian(data, fi, n);
		int TooBigNdx = fi + 1;
		int TooSmallNdx = (fi + n - 1);
		while (TooBigNdx < TooSmallNdx) {
			while ((TooBigNdx < TooSmallNdx) && (data[TooBigNdx].compareTo(pivot) <= 0)) {
				TooBigNdx++;
			}
			while ((TooSmallNdx > fi) && (data[TooSmallNdx].compareTo(pivot) > 0)) {
				TooSmallNdx--;
			}
			if (TooBigNdx < TooSmallNdx) {
				swap(data, TooBigNdx, TooSmallNdx);
			}
		}
		if (pivot.compareTo(data[TooSmallNdx]) >= 0) {
			swap(data, fi, TooSmallNdx);
			return TooSmallNdx;
		} else {
			return fi;
		}
	}


	@Override
	public void mergeSort(String[] data, int fi, int n) {
		// TODO Auto-generated method stub
		if (n <= 15) {
			insertionSort(data, fi, n);
		} else {
			if (n > 1) {
				int h1, h2;
				if (n % 2 == 0) {
					h1 = (n / 2);
					h2 = (n / 2);
				} else {
					h1 = (n / 2);
					h2 = (n / 2) + 1;
				}
				mergeSort(data, fi, h1);
				mergeSort(data, fi + h1, h2);
				merge(data, fi, h1, h2);
			}
		}
	}


	@Override
	public void merge(String[] data, int fi, int nl, int nr) {
		// TODO Auto-generated method stub
		String[] right = new String[nr];
		String[] left = new String[nl];
		for (int i = 0; i < nr; i++) {
			if (i < nl)
				left[i] = data[fi + i];
			right[i] = data[fi + nl + i];
		}
		int l = 0;
		int r = 0;
		while (l != nl && r != nr) {
			if (right[r].compareTo(left[l]) <= 0) {
				data[fi++] = right[r++];
			} else {
				data[fi++] = left[l++];
			}
		}
		if (l != nl) {
			System.arraycopy(left, l, data, fi, nl - l);
		} else if (r != nr) {
			System.arraycopy(right, r, data, fi, nr - r);
		}

	}


	@Override
	public void heapSort(String[] data) {
		// TODO Auto-generated method stub
		int size = data.length;

		heapify(data);

		for (int i = size - 1; i >= 0; i--) {
			swap(data, 0, i);
			reheapify(data, i, 0);
		}
	}


	@Override
	public void heapify(String[] data) {
		// TODO Auto-generated method stub
		int largest;
		int left;
		int right;
		int size = data.length;
		for (int i = size / 2 - 1; i >= 0; i--) {
			largest = i;
			left = 2 * i + 1;
			right = 2 * i + 2;
			if (right < size && data[right].compareTo(data[largest]) > 0) {
				largest = right;
			}
			if (left < size && data[left].compareTo(data[largest]) > 0) {
				largest = left;
			}
			if (largest != i) {
				swap(data, i, largest);
				reheapify(data, size, largest);
			}
		}
	}


	public void reheapify(String[] data, int size, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (right < size && data[right].compareTo(data[largest]) > 0) {
			largest = right;
		}
		if (left < size && data[left].compareTo(data[largest]) > 0) {
			largest = left;
		}
		if (largest != i) {
			swap(data, i, largest);
			reheapify(data, size, largest);
		}
	}


	public void swap(String[] data, int i1, int i2) {
		String temp = data[i1];
		data[i1] = data[i2];
		data[i2] = temp;
	}


	public String getMedian(String[] data, int fi, int n) {
		int last = fi + n - 1;
		int middle = (fi + last) / 2;
		if (data[last].compareTo(data[fi]) < 0) {
			swap(data, last, fi);
		}
		if (data[last].compareTo(data[middle]) > 0) {
			swap(data, last, middle);
		}
		if (data[middle].compareTo(data[fi]) < 0) {
			swap(data, middle, fi);
		}
		swap(data, fi, last);
		return data[fi];
	}


}