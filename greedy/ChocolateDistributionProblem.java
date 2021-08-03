package greedy;

import java.util.Arrays;

//Given an array of n integers where each value represents the number of chocolates in a packet.
//Each packet can have a variable number of chocolates. There are m students, the task is to distribute 
//chocolate packets such that: 
//
//Each student gets one packet.
//The difference between the number of chocolates in the packet with maximum chocolates and packet with 
//minimum chocolates given to the students is minimum.

// Approach:

//A simple solution is to generate all subsets of size m of arr[0..n-1]. For every subset,
//find the difference between the maximum and minimum elements in it. Finally, return the minimum difference.
//An efficient solution is based on the observation that to minimize the difference, we must choose consecutive
//elements from a sorted packet. We first sort the array arr[0..n-1], then find the subarray of size m with
//the minimum difference between the last and first elements.


public class ChocolateDistributionProblem {
	
	static int solve(int a[], int m)
	{
		int n = a.length;
		Arrays.sort(a);
		int minDiff = Integer.MAX_VALUE;
		
		for(int i=0; i<=n- m;i++)
		{
			minDiff = Math.min(minDiff, a[i + (m-1)] - a[i]);
		}
		
		return minDiff;
	}
	
	// practice one more variation of question which can be solved using kadanes algorithms

	public static void main(String[] args) {
		int a[] = {7, 3, 2, 4, 9, 12, 56};
		System.out.println(solve(a, 3));
		
		int a1[] = {3, 4, 1, 9, 56, 7, 9, 12};
		System.out.println(solve(a1, 5));
		
		int a2[] = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
		System.out.println(solve(a2, 7));

	}

}
