package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSortByLeastHoursTest {
	private QuickSortByLeastHours test = new QuickSortByLeastHours(null);
	@Test
	public void testSort() {
		int[] values  = {45, 2, 15, 10, 55, 1};
		//int[] sortedArray = {8, 2, 55, 0, 5, -3};
		int[] sortedArray = {1, 2, 10, 15, 55};
		
		QuickSortByLeastHours.quicksort();
		
		assertArrayEquals(sortedArray, values);
		
	} 

}

