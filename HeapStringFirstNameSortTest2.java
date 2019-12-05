package application;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class HeapStringFirstNameSortTest2 {
	static Person[] ar = new Person[3];

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Person p = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		p.setFirstName("Ben");
		p2.setFirstName("Will");
		p3.setFirstName("Han");
		ar[0] = p;
		ar[1] = p2;
		ar[2] = p3;
	}
	
	static void testheapSort(Person[] arr) {
		for(Person p : arr) {
			System.out.print(p.getFirstName()+ ", ");
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(Arrays.asList(arr));
		HeapStringFirstNameSort a = new HeapStringFirstNameSort();
		arr = a.HEAPSort(arr);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		for(Person p : arr) {
			System.out.print(p.getFirstName()+ ", ");
		}
		
	}
	
	@Test
	public void test() {
		HeapStringFirstNameSortTest2.testheapSort(ar);
	}
}
