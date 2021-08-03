package dynamicProgramming;

import java.util.Arrays;

public class EggDroppingProblem {
	
	static int t[][] = new int[21][51];         // take this value from constraints
	
//	static int solve(int e, int f)
//	{
//		if(e == 1 || e == 0)
//			return f;
//		
//		if(f == 1 || f == 0)
//			return f;
//		
//		int ans = Integer.MAX_VALUE;
//		
//		for(int k=1; k<=f; k++)
//		{
//			int temp = 1 + Math.max(solve(e - 1, k - 1), solve(e, f - k));    // max due to worst case
//			
//			ans = Math.min(ans, temp);          // min because we have to minimize attempts
//		}
//		
//		return ans;
//	}
 //optimized memoized problem	
	static int solve(int e, int f)
	{
		if(e == 1 || e == 0)
			return t[e][f] = f;
		
		if(f == 1 || f == 0)
			return t[e][f] =f;
		
		int ans = Integer.MAX_VALUE;
		
		for(int k=1; k<=f; k++)
		{
//			int temp = 1 + Math.max(solve(e - 1, k - 1), solve(e, f - k));    // max due to worst case
			
			int low = 0;
			int high = 0;
			
			if(t[e-1][k-1] == -1)
				low = solve(e-1, k-1);
			else
				low = t[e-1][k-1];
			
			if(t[e][f-k] == -1)
				high = solve(e, f-k);
			else
				high = t[e][f-k];
			
			int temp =  1 + Math.max(low, high);
			
			ans = Math.min(ans, temp);          // min because we have to minimize attempts
		}
		
		return t[e][f] = ans;
	}
	static void eggDropDP(int e, int f)
	{
		int [][]dp = new int[e+1][f+1];
		// row denotes eggs and columns denotes floors
		for(int i=1;i<=e;i++)
		{
			for(int j=1;j<=f;j++)
			{
				if(i == 1)
					dp[i][j] = j;
				else if(j == 1)
					dp[i][j] = 1;
				else
				{
					int min = Integer.MAX_VALUE;
					// comparing with the results of every possible floor
					for(int mj = j-1, pj = 0; mj>=0 ;mj--, pj++)
					{
						// mj will move from right to left in same row
						// and pj from left to right in prev row
						int v1 = dp[i][mj];   // egg survives
						int v2 = dp[i-1][pj]; // egg breaks
						int val = Math.max(v1, v2);
						
						min = Math.min(val, min);
					}
					
					dp[i][j] = min + 1;
				}
			}
		}
		System.out.println(dp[e][f]);
	}
	public static void main(String[] args) {
		for(int a[] : t)
		{
			Arrays.fill(a, -1);
		}
		System.out.println(solve(2, 10));
		System.out.println(solve(1, 10));
		eggDropDP(2, 10);
		eggDropDP(1, 10);
		eggDropDP(2, 36);

	}

}
