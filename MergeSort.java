package org.vivek.sorting;

/**
 * @author Vivek Rajput
 * 
 */
public class MergeSort {

	// private constructor to prevent instantiation of this class
	private MergeSort() throws InstantiationException {
	}
	/**
	 * This method accepts an int array as input and returns a sorted array in
	 * ascending order.
	 * 
	 * @param a input int array
	 * @return sorted array in ascending order
	 */
	public static int[] sort(int[] a) {
		return doMergeSort(a);
	}

	private static int[] doMergeSort(int[] a) {

		if (a.length <= 1) {// an array of size 1 is already sorted so this is
							// our base case
			return a;
		}
		int[] a1 = new int[a.length / 2];
		int[] a2 = new int[(int) StrictMath.round(a.length / 2.0)];
		System.arraycopy(a, 0, a1, 0, a.length / 2);
		System.arraycopy(a, a.length / 2, a2, 0, a.length - a.length / 2);
		a1 = doMergeSort(a1); // recursive calls
		a2 = doMergeSort(a2);// recursive calls
		return merge(a1, a2);

	}

	private static int[] merge(int[] a1, int[] a2) {

		int[] s = new int[a1.length + a2.length];
		int a1Counter, a2Counter;
		a1Counter = a2Counter = 0;
		for (int i = 0; i < s.length; i++) {
			// all the elements of array a1 are copied and now directly copy
			// remaining a2 elements
			if (a1Counter == a1.length) {
				System.arraycopy(a2, a2Counter, s, i, a2.length - a2Counter);
				break;
			} // all the elements of array a2 are copied and now directly copy
				// remaining a1 elements
			else if (a2Counter == a2.length) {
				System.arraycopy(a1, a1Counter, s, i, a1.length - a1Counter);
				break;
			} else if (a1[a1Counter] > a2[a2Counter]) {
				s[i] = a2[a2Counter++];
			} else {
				s[i] = a1[a1Counter++];
			}
		}
		return s;
	}

}
