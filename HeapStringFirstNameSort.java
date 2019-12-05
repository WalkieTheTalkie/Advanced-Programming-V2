package application;

public class HeapStringFirstNameSort {
	static Person[] are = new Person[20];

	HeapStringFirstNameSort() {
		
	}
	
	public static void  heaper(Person[] are2) 
    { 
        int len = are2.length; 
  
        // step1: build heap 
        for (int i = len / 2 - 1; i >= 0; i--) 
            maxHeapify(are2, len, i); 
  
        // step2: extract each string in the list
        for (int i=len-1; i>=0; i--) 
        { 
            // Put current node at bottom
            Person temp = are2[0]; 
            are2[0] = are2[i]; 
            are2[i] = temp; 
  
            // change tree to be constrained by maximum of parent vs child
            maxHeapify(are2, i, 0); 
        } 
    } 
  
    static void maxHeapify(Person[] are2, int n, int i) 
    { 
        int largest = i;   // initiate  
        int l = 2 * i + 1; // left = 2 x i + 1 
        int r = 2 * i + 2; // right = 2 x i + 2 
  
        // check if left child exists and compare to root
        if (l < n && are2[l].getFirstName().compareToIgnoreCase(are2[largest].getFirstName()) > 0) 
            largest = l; 
  
        // Check if right child exits and compare to root
        if (r < n && are2[r].getFirstName().compareToIgnoreCase(are2[largest].getFirstName()) > 0) 
            largest = r; 
  
        // If tree structure needs to change
        if (largest != i) 
        { 
            Person swap = are2[i]; 
            are2[i] = are2[largest]; 
            are2[largest] =  swap; 
  
            // Recursively deal with the sub-tree 
            maxHeapify(are2, n, largest); 
        } 
    } 
  
    static void printArray(Person[] are2) 
    { 
        int n = are2.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(are2[i].getFirstName()+" "); 
        System.out.println(); 
    } 

		// Driver Code
		public static Person[] HEAPSort(Person[] are) {

			 
	        System.out.println("array ");
	        for(int i = 0;i < are.length;i++) {
	        	System.out.print(are[i] + " ");
	        }
	        System.out.println();
	 
	        HeapStringFirstNameSort.heaper(are); 
	  
	        System.out.println("Sorted array is"); 
	        printArray(are);
	        
			return are; 
		}
	}
