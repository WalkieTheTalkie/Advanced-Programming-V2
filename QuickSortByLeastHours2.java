package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class QuickSortByLeastHours2 {

	private static EmployeeClass[] a;

	QuickSortByLeastHours2(EmployeeClass[] b) {
		a = b;
	}

	public static EmployeeClass[] quicksort() {

		printArray();

		sort();

		System.out.println("");

		printArray();

		return a;

	}

	public static void sort() {
		int left = 0;
		int right = a.length - 1;

		quickSort(left, right);
	}
	private static void quickSort(int left, int right) {

		if (left >= right)
			return;

		int pivot = a[right].getWorkinHours();
		int partition = partition(left, right, pivot);

		quickSort(0, partition - 1);
		quickSort(partition + 1, right);
	}

	private static int partition(int left, int right, int pivot) {
		int leftCursor = left - 1;
		int rightCursor = right;
		while (leftCursor < rightCursor) {
			while (a[++leftCursor].getWorkinHours() < pivot)
				;
			while (rightCursor > 0 && a[--rightCursor].getWorkinHours() > pivot)
				;
			if (leftCursor >= rightCursor) {
				break;
			} else {
				swap(leftCursor, rightCursor);
			}
		}
		swap(leftCursor, right);
		return leftCursor;
	}

	public static void printArray() {
		for (EmployeeClass i : a) {
			System.out.print(i.getWorkinHours() + " ");
		}
	}

	public static void swap(int left, int right) {
		EmployeeClass temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	public static int[] getArray() {
		int size = 10;
		int[] array = new int[size];
		int item = 0;
		for (int i = 0; i < size; i++) {
			item = (int) (Math.random() * 100);
			array[i] = item;
		}
		return array;
	}

}