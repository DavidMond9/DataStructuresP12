package edu.ncsu.csc316.dsa.sorter;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Quick Sorter with lists of integers.
 * @author David Mond
 */
public class QuickSorterTest {
	/**
	 * Test list 1.
	 */
	private Integer[] dataAscending = { 1, 2, 3, 4, 5 };
	/**
	 * Test list 2.
	 */
	private Integer[] dataDescending = { 5, 4, 3, 2, 1 };
	/**
	 * Test list 3.
	 */
	private Integer[] dataRandom = { 4, 1, 5, 3, 2 };
	/**
	 * Test sorter for QuickSort.
	 */
	private QuickSorter<Integer> integerSorter;
	/**
	 * Test sorter 2 for QuickSort.
	 */
	private QuickSorter<Integer> integerSorter2;
	/**
	 * Test sorter 3 for QuickSort.
	 */
	private QuickSorter<Integer> integerSorter3;
	/**
	 * Test sorter 4 for QuickSort.
	 */
	private QuickSorter<Integer> integerSorter4;
	/**
	 * Sets up the sorter.
	 */
	@Before
	public void setUp() {
		integerSorter = new QuickSorter<Integer>();
		integerSorter2 = new QuickSorter<Integer>(integerSorter2.FIRST_ELEMENT_SELECTOR);
		integerSorter3 = new QuickSorter<Integer>(integerSorter2.LAST_ELEMENT_SELECTOR);
		integerSorter4 = new QuickSorter<Integer>(integerSorter2.MIDDLE_ELEMENT_SELECTOR);
	}
	/**
	 * Tests the sorter with random pivot with the integers.
	 */
	@Test
	public void testIntegerSorter() {
		integerSorter.sort(dataAscending);
		assertTrue(dataAscending[0].equals(1));
		assertTrue(dataAscending[1].equals(2));
		assertTrue(dataAscending[2].equals(3));
		assertTrue(dataAscending[3].equals(4));
		assertTrue(dataAscending[4].equals(5));

		integerSorter.sort(dataDescending);
		assertTrue(dataDescending[0].equals(1));
		assertTrue(dataDescending[1].equals(2));
		assertTrue(dataDescending[2].equals(3));
		assertTrue(dataDescending[3].equals(4));
		assertTrue(dataDescending[4].equals(5));

		integerSorter.sort(dataRandom);
		assertTrue(dataRandom[0].equals(1));
		assertTrue(dataRandom[1].equals(2));
		assertTrue(dataRandom[2].equals(3));
		assertTrue(dataRandom[3].equals(4));
		assertTrue(dataRandom[4].equals(5));
	}
	
	/**
	 * Tests the sorter with first pivot with the integers.
	 */
	@Test
	public void testIntegerSorter2() {
		integerSorter2.sort(dataAscending);
		assertTrue(dataAscending[0].equals(1));
		assertTrue(dataAscending[1].equals(2));
		assertTrue(dataAscending[2].equals(3));
		assertTrue(dataAscending[3].equals(4));
		assertTrue(dataAscending[4].equals(5));

		integerSorter2.sort(dataDescending);
		assertTrue(dataDescending[0].equals(1));
		assertTrue(dataDescending[1].equals(2));
		assertTrue(dataDescending[2].equals(3));
		assertTrue(dataDescending[3].equals(4));
		assertTrue(dataDescending[4].equals(5));

		integerSorter2.sort(dataRandom);
		assertTrue(dataRandom[0].equals(1));
		assertTrue(dataRandom[1].equals(2));
		assertTrue(dataRandom[2].equals(3));
		assertTrue(dataRandom[3].equals(4));
		assertTrue(dataRandom[4].equals(5));
	}
	
	/**
	 * Tests the sorter with last pivot with the integers.
	 */
	@Test
	public void testIntegerSorter3() {
		integerSorter3.sort(dataAscending);
		assertTrue(dataAscending[0].equals(1));
		assertTrue(dataAscending[1].equals(2));
		assertTrue(dataAscending[2].equals(3));
		assertTrue(dataAscending[3].equals(4));
		assertTrue(dataAscending[4].equals(5));

		integerSorter3.sort(dataDescending);
		assertTrue(dataDescending[0].equals(1));
		assertTrue(dataDescending[1].equals(2));
		assertTrue(dataDescending[2].equals(3));
		assertTrue(dataDescending[3].equals(4));
		assertTrue(dataDescending[4].equals(5));

		integerSorter3.sort(dataRandom);
		assertTrue(dataRandom[0].equals(1));
		assertTrue(dataRandom[1].equals(2));
		assertTrue(dataRandom[2].equals(3));
		assertTrue(dataRandom[3].equals(4));
		assertTrue(dataRandom[4].equals(5));
	}
	
	/**
	 * Tests the sorter with middle pivot with the integers.
	 */
	@Test
	public void testIntegerSorter4() {
		integerSorter4.sort(dataAscending);
		assertTrue(dataAscending[0].equals(1));
		assertTrue(dataAscending[1].equals(2));
		assertTrue(dataAscending[2].equals(3));
		assertTrue(dataAscending[3].equals(4));
		assertTrue(dataAscending[4].equals(5));

		integerSorter4.sort(dataDescending);
		assertTrue(dataDescending[0].equals(1));
		assertTrue(dataDescending[1].equals(2));
		assertTrue(dataDescending[2].equals(3));
		assertTrue(dataDescending[3].equals(4));
		assertTrue(dataDescending[4].equals(5));

		integerSorter4.sort(dataRandom);
		assertTrue(dataRandom[0].equals(1));
		assertTrue(dataRandom[1].equals(2));
		assertTrue(dataRandom[2].equals(3));
		assertTrue(dataRandom[3].equals(4));
		assertTrue(dataRandom[4].equals(5));
	}
}
