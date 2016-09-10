package org.vivek.sorting;

import java.util.Random;

public class QuickSort {

	// private constructor to prevent instantiation of this class
	private QuickSort() {
	}
	/**
	 * Perform QuickSort on the given array in ascending order
	 * 
	 * @param a input unsorted array
	 */
	public void sort(int[] a) {
		doQuickSort(a, 0, a.length - 1);
	}

	/**
	 * 1) Find the pivot element, it could be any random element from the array
	 * within the boundary of the iteration<br>
	 * 2) Swap the pivot element with the first element <br>
	 * 3) Now sequentially scan each element from left to right, excluding pivot
	 * <br>
	 * 4) If encounter element larger than pivot, keep iterating<br>
	 * 5) If encounter element smaller than pivot, swap it with the first
	 * leftmost element that is larger than pivot (will use splitIdx to track
	 * it)<br>
	 * 6) After each iteration the pivot element would come to final place as in
	 * the sorted array<br>
	 * 7) Perform the sort recursively for left and right arrays by excluding
	 * the pivot element as its already sorted
	 * 
	 * @param si Start index of the array boundary
	 * @param ei End index of the array boundary
	 */
	private void doQuickSort(int[] s, int si, int ei) {

		if (si >= ei)// this is our exit condition from the recursive calls
			return;

		Random random = new Random();
		// choosing any random element as the pivot
		int pivotIdx = random.nextInt(ei - si + 1) + si;
		int p = s[pivotIdx];
		// swapping the pivot element with first element in the array
		swap(s, si, pivotIdx);
		// well this is a flag that is set to true when we encounter first
		// element large than the pivot. Swap is required only if we encounter a
		// small value after a bigger value
		boolean swap = false;
		// assigning the variable to si value
		int splitIdx = si;

		for (int i = si; i <= ei; i++) {
			if (s[i] > p) {
				swap = true;
			}
			if (s[i] < p) {
				splitIdx++;
				if (swap) {
					swap(s, splitIdx, i);
				}
			}
		}
		swap(s, si, splitIdx);// splitIdx gives the sorted position of
								// the pivot element at the end of this
								// iteration

		// do quick sort for left and right arrays recursively
		doQuickSort(s, si, splitIdx - 1);
		doQuickSort(s, splitIdx + 1, ei);

	}

	private void swap(int[] s, int i, int j) {
		int temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

}
