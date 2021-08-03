package bitManipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// sort an array according to count of set bits, if same number of bits than sort according to position
// means stable sort

// IMP: Merge Sort is stable sort and quick sort is unstable sort
// Collection.sort uses merge sort, and Arrays.sort uses quick sort

public class SortArrayOnBits {
	// using mergeSort
	// TC : O(nlogn) 
	static void solve(int a[])
	{
	
		ArrayList<Integer> arr= new ArrayList<>();
		for(int i:a)
			arr.add(i);
		
		Collections.sort(arr, new Comparator<>()
				{

					@Override
					public int compare(Integer o1, Integer o2) {
						return Integer.bitCount(o2) - Integer.bitCount(o1);
						
					}
			
				});
		
		System.out.println(arr);
		
	}

	public static void main(String[] args) {
		int a[] = {5, 2, 3, 9, 4, 6, 7, 15, 32};
		solve(a);

	}

}
