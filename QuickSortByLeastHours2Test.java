package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortByLeastHours2Test {
	private QuickSortByLeastHours2 test = new QuickSortByLeastHours2(null);
	@Test
	public void testSort() {
		int[] values  = {45, 2, 15, 10, 55, 1};
		//int[] sortedArray = {8, 2, 55, 0, 5, -3};
		int[] sortedArray = {1, 2, 10, 15, 55};
		
		QuickSortByLeastHours2.quicksort();
		
		assertArrayEquals(sortedArray, values);
		
	} 

}
