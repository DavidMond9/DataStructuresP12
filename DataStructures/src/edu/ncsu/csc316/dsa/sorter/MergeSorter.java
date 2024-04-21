package edu.ncsu.csc316.dsa.sorter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * MergeSorter sorts arrays of comparable elements using the merge sort
 * algorithm. This implementation ensures O(nlogn) worst-case runtime to sort an
 * array of n elements that are comparable.
 * 
 * @author Dr. King
 *
 * @param <E> the type of elements to sort; elements must be {@link Comparable}
 */
public class MergeSorter<E extends Comparable<E>> extends AbstractComparisonSorter<E> {

    /**
     * Constructs a new MergeSorter with a specified custom Comparator
     * 
     * @param comparator a custom Comparator to use when sorting
     */
    public MergeSorter(Comparator<E> comparator) {
        super(comparator);
    }

    /**
     * Constructs a new MergeSorter with comparisons based on the element's natural
     * ordering
     */ 
    public MergeSorter() {
        this(null);
    }
    /**
     * Sorts a list of elements using the MergeSort method.
     * @param data list of elements to sort.
     */
	public void sort(E[] data) {
		if(data.length < 2) {
			return;
		}
		int mid = data.length / 2;
		E[] left = Arrays.copyOfRange(data, 0, mid);
		E[] right = Arrays.copyOfRange(data, mid, data.length);
		sort(left);
		sort(right);
		merge(left, right, data);
	}
	
	/**
	 * Merges the left and right arrays into the output sorted array.
	 * @param s1 the array containing the sorted left half
	 * @param s2 the array containing the sorted right half
	 * @param s3 the original array data of elements
	 */
	private void merge(E[] s1, E[] s2, E[] s3) {
		int leftIdx = 0;
		int rightIdx = 0;
		while(leftIdx + rightIdx < s3.length) {
			if(rightIdx == s2.length || (leftIdx < s1.length && compare(s1[leftIdx], s2[rightIdx]) < 0)) {
				s3[leftIdx + rightIdx] = s1[leftIdx];
				leftIdx++;
			}
			else {
				s3[leftIdx + rightIdx] = s2[rightIdx];
				rightIdx++;
			}
		}
	}
}