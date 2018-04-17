package competitive;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SortingAlgorithm {

	public static void main(String[] args) {
		int[] arr = new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
		System.out.println("arr: " + arr);
		System.out.println(Arrays
				.toString(bubbleSort(arr)));
	}
	
	// 9 8 7 6 5 4 3 2 1 
	private static int[] bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length-1-i; j++) {
				System.out.print("iterazione: " );
				if(arr[j] > arr[j+1]) {
					final int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
					System.out.print(Arrays.toString(arr));
				}
				System.out.println();
			}
		}
		return arr;
	}
}
