package dynamicProgramming;
// maximum sum of pairs with specific difference
// maximize the sum of all pairs with difference strictly less than k

import java.util.Arrays;

public class MaxSumPairLessThanKDiff {
	
	static void solveDP(int a[], int k)
	{
		Arrays.sort(a);
		int n = a.length;
		int dp[] = new int[n];
		dp[0] = 0;
		dp[1] = 0;
		if(a[1] - a[0] < k )
			dp[1] = Math.max(0, a[0]+a[1]);
		for(int i=2;i<n;i++)
		{
			dp[i] = dp[i-1];
			if(a[i] - a[i-1]<k)
			{
				 // either not to include it or include it
				dp[i] = Math.max(dp[i-1], dp[i-2] + a[i] + a[i-1]);
			}
		}
		System.out.println(dp[n-1]);
	}
	// this is without dp 
	// SC : O(n)
	static void solve(int a[], int k)
	{
		// first sort the array
		int n =a.length;
		Arrays.sort(a);
		int maxSum = 0;
		// to get largest sum we iterate backwards to give priority to bigger elements
		for(int i=n-1;i>0;i--)
		{
			if(a[i] - a[i-1] < k)
			{
				// assuming only positive numbers
				maxSum += a[i];
				maxSum += a[i-1];
				
				// when match is found than skip this pair
				i--;
			}
		}
		System.out.println( maxSum);
	}

	public static void main(String[] args) {
		int a[] = {3, 5, 10, 15, 17, 12, 9};
		solveDP(a, 4);
		solve(a, 4);
		
		int a1[] = {5, 15, 10,300};
		solve(a1, 12);
		solveDP(a1, 12);

	}

}
