package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

//count ways to reach the nth stair
//if the person can climb only 1 or 2 stairs at a time
// breakdown reached to a simple fibonnaci problem

public class StaircaseProblem{
	
	// returns no of ways to reach stairs recursively
	// O(2^n)
	
//	static int rec(int s, int m)
//	{
//		return countWaysUtil(s+1, m);
//	}
//	
//	static int countWaysUtil(int n, int m)
//	{
//		if(n <= 0)
//			return 0;
//		if(n == 1)
//			return n;
//		
//		int res = 0;
//		for(int i=1;i<=m;i++)
//		{
//			res += countWaysUtil(n-i, m);
//		}
//		return res;
//	}
	
	
	// Using dp
	// TC: O(mn)
	// SC:O(n)
	
//	static int countWays(int s, int m)
//	{
//		return countWaysUtil(s+1, m);
//	}
//	
//	static int countWaysUtil(int n, int m)
//	{
//		int res[] = new int[n];
//		res[0] = 1;
//		res[1] = 1;
//		
//		for(int i=2; i<n;i++)
//		{
//			res[i]  = 0;
//			for(int j = 1; j<=m && j<=i;j++)
//			{
//				res[i] += res[i-j];
//			}
//		}
//		return res[n-1];
//	}
	
	
	// Now we optimize dp solution by using a sliding window protocol
	// TC:O(n)
    // SC:O(n)	
	static int countWays(int n, int m)
	{
		int res[] = new int[n+1];
		int temp = 0;
		res[0] = 1;
		
		for(int i=1;i<=n;i++)
		{
			int start = i - m - 1;
			int e = i - 1;
			if(start >= 0)
			{
				temp -= res[start];
			}
			temp += res[e];
			res[i] = temp;
		}
		return res[n];
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	// get Stair path 
	// you are given a number n, allowed to jump down 1, 2, 3 at a time
	// fill all possible paths in an arraylist
	// recursive solution
	// this also gives answer for "the number of ways to break a number using 1, 2, 3 such that their
	// sum add up to the original number "
	// a variation can be to print paths like in print subsequences
	static ArrayList<String> solve(int n)
	{
		if(n == 0)
		{
			ArrayList<String> path = new ArrayList<>();
			path.add("");         // path does exist in this case
			return path; 
		}
		if(n < 0)
		{
			// path doesn't exist in this case
			ArrayList<String> path = new ArrayList<>();
			return path;         // return empty 
		}
		
		ArrayList<String> path1 = solve(n-1);
		ArrayList<String> path2 = solve(n-2);
		ArrayList<String> path3 = solve(n-3);
		
		ArrayList<String> paths = new ArrayList<>();       // this will contain answer
		
		for(String path:path1)
		{
			paths.add(1+path);
		}
		
		for(String path:path2)
		{
			paths.add(2+path);
		}
		
		for(String path:path3)
		{
			paths.add(3+path);
		}
		
		return paths;
	}
	
// count total paths (variation of above question)
	// recursive will be  O(2^n)
	// we use dp
	
	static void solveDP(int n)
	{
		int []dp = new int[n+1];
		dp[0] = 1;
		for(int i=1;i<n+1;i++)
		{
			if(i == 1)                     // corner case
				dp[i] = dp[i-1];
			else if(i == 2)
				dp[i] = dp[i-1] + dp[i-2];   // corner case
			else
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		System.out.println(dp[n]);
	}
	
	// now for variable jumps(this time jumping from 0 to n
	// input: n representing the number of stairs and an array representing
	//till how far from the step you could jump
	// dp solution
	static void solve1(int n, int a[])
	{
		int dp[] = new int[n+1];
		dp[n] = 1;
		
		for(int i=n-1;i>=0;i--)
		{
			for(int j=1;j<=a[i] && i+j <dp.length;j++)
			{
				dp[i] += dp[i+j];
			}
		}
		
		System.out.println(dp[0]);
	}
	
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
	
	// now find number of ways of climbing stairs if m jumps are allowed
	static void solve3(int n, int m)
	{
		int dp[] = new int[n+1];
		dp[n] = 1;
		
		for(int i=n-1;i>=0;i--)
		{
			for(int j=1;j<=m && i+j <dp.length;j++)
			{
				dp[i] += dp[i+j];
			}
		}
		
		System.out.println(dp[0]);
	}// this solution can be optimized further using sliding window protocol

	public static void main(String[] args) {
		int s = 5;
		int m = 3;     // means at most m stairs can be climbed at once
		System.out.println(countWays(s,m));
		
		System.out.println(solve(4));
		solveDP(10);
		int a[] = {3, 3, 0, 2, 2, 3};
		solve1(6, a);
		
		int a1[] = {3, 2, 4, 2,0, 2, 3, 1, 2, 2};
		solve2(10, a1);
		
		solve3(5, 3);
		
		int a3[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		solve2(a3.length, a3);

	}

}
