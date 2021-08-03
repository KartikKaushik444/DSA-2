package greedy;

import java.util.Arrays;

public class MinPlatforms {
	// Min Heap Approach: 
	// One way is by creating pair of arrival and departure time and then sorting on the  basis
	// of arrival time. Than use min heap using departure time to make decisions accordingly.
	// TC : O(nlogn)
	// SC : O(n)
	
	// Two pointer approach (implemented below): 
	// idea is to sort the arrival time and departure time. No need to consider
	// train number. Than we can use two pointer approach to calculate answer
	// TC : O(nlogn)
	// SC : O(1)
	
	public static void findPlatform(int arr[], int dept[]) {
		Arrays.sort(arr);
		Arrays.sort(dept);
		int n = arr.length;
		int plat_needed = 1;   
		
		int i=1; // this will pointer at the arrival train time
		int j=0; // this will point at the least departure time
		while(i < n)
		{
			if(arr[i] <= dept[j])   // will need another platform
			{
				plat_needed++;
				
			}
			
			else if(arr[i] > dept[j]) // because jth train is going to leave before ith arrive, hence no increment  
			{                           // needed
				j++;     // move to next departing time
			}
			i++;             // move to next arriving time or train
			
			
		}
		
		System.out.println(plat_needed);
		
	}

	public static void main(String[] args) {
		 int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
	        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
	        
//	        int arr[] = { 900, 940, 950};
//	        int dep[] = { 910, 1200, 1120 };
//	       
	
	        findPlatform(arr, dep);

	}

}
