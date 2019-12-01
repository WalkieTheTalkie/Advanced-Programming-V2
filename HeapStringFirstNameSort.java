package application;

public class HeapStringFirstNameSort {
	static Person[] are = new Person[10];

	HeapStringFirstNameSort(Person[] ARE) {
		are = ARE;
	}


		// Used for index in heap
		static int x = -1;

		// Predefining the heap array
		static Person[] heap = new Person[1000];

		// Defining formation of the heap
		static void heapForm(Person arr) {
			x++;

			heap[x] = arr;

			int child = x;

			Person tmp;

			int index = x / 2;

			// Iterative heapiFy
			while (index >= 0) {

				// Just swapping if the element
				// is smaller than already
				// stored element
				if (heap[index].getFirstName().compareToIgnoreCase(heap[child].getFirstName()) > 0) {

					// Swapping the current index
					// with its child
					tmp = heap[index];
					heap[index] = heap[child];
					heap[child] = tmp;
					child = index;

					// Moving upward in the
					// heap
					index = index / 2;
				} else {
					break;
				}
			}
		}

		// Defining heap sort
		static void heapSort() {
			int left1, right1;
			Person[] ki = new Person[are.length];
			int in = 0;
			while (x >= 0) {
				
				Person k;
				k = heap[0];

				// Taking output of
				// the minimum element
				System.out.print(k.getFirstName() + " ");
				ki[in] = k;
				in++;
				

				// Set first element
				// as a last one
				heap[0] = heap[x];

				// Decrement of the
				// size of the string
				x = x - 1;

				Person tmp;

				int index = 0;

				int length = x;

				// Initilizing the left
				// and right index
				left1 = 1;

				right1 = left1 + 1;

				while (left1 <= length) {

					// Process of heap sort
					// If root element is
					// minimum than its both
					// of the child then break
					if (heap[index].getFirstName().compareToIgnoreCase(heap[left1].getFirstName()) <= 0
							&& heap[index].getFirstName().compareToIgnoreCase(heap[right1].getFirstName()) <= 0) {
						break;
					}

					// Otherwise checking that
					// the child which one is
					// smaller, swap them with
					// parent element
					else {

						// Swapping
						if (heap[left1].getFirstName().compareToIgnoreCase(heap[right1].getFirstName()) < 0) {
							tmp = heap[index];
							heap[index] = heap[left1];
							heap[left1] = tmp;
							index = left1;
						}

						else {
							tmp = heap[index];
							heap[index] = heap[right1];
							heap[right1] = tmp;
							index = right1;
						}
					}

					// Changing the left index
					// and right index
					left1 = 2 * left1;
					right1 = left1 + 1;
				}
			}
			are = ki; 
		}

		// Utility function
		static void sort(Person[] arr, int n) {

			// To heapiFy
			for (int i = 0; i < n; i++) {
				heapForm(arr[i]);
			}

			// Calling heap sort function
			heapSort();
		}

		// Driver Code
		public static Person[] HEAPSort() {

			int n = are.length;

			sort(are, n);

			return are;
		}
	}
