package dynamicProgramming;

import java.util.Arrays;

public class MinJumpsToReachEnd {
	// O[n^n] solution for recursive approach
	// if use memoization than time complexity reduces
	static int count = 0;
	static int jump[] = new int[100];
	static int solve(int a[], int n, int i)
	{
		count++;
		
		// if index is equal to last than one step is required
		if(i == n-1)      
		{
			return 1;
		}
		int jumps = Integer.MAX_VALUE;
		for(int j = 1; j<=a[i] && i+j < n; j++)     // condition for removing out of index calls
		{
			// checking for all values of available jumps
			if(jump[i+j] != -1)
			{
				jumps = Math.min(jumps, jump[i+j]);
			}
			else
				jumps = Math.min(jumps, solve(a, n, i+j));
			
			// if jumps not possible than continue
			if(jumps == Integer.MAX_VALUE)
			{
				continue;
			}
			
		}
		// if at starting 
		if(i == 0)
			return jump[i] = jumps;
		// if not
		else
			return jump[i] = jumps+1;
	}
	
	// use staircase.solve2() to solve in O(n^2)
	
	// now find min no of jumps required
		static void solve2(int n, int a[])
		{
			int dp[] = new int[n+1];
			Arrays.fill(dp,Integer.MAX_VALUE);// for ignoring the values from which no path exists
			dp[n] = 0;
			
			for(int i=n-1;i>=0;i--)
			{
				if(a[i] >=0)
				{
					int min = Integer.MAX_VALUE;
					for(int j=1;j<=a[i] && i+j <dp.length;j++)
					{
						min = Math.min(min, dp[i+j]);
					}
					
					if(min!=Integer.MAX_VALUE)
						dp[i] = 1 + min;
				}
			}
			
			System.out.println(dp[0]);
		}

	public static void main(String[] args) {
		
		int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		int a1[] = {4, 8, 11, 15, 4, 36, 48, 79, 57};   
		int a2[] = {1,1,1,1,1,1,1,1,1,1,1}; 
		int a3[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		Arrays.fill(jump, -1);
		System.out.println(solve(a3, a3.length, 0));
		System.out.println(count);
		

	}

}
// O(n) solution present at gfg
