package dynamicProgramming;

public class MaxSumIncreasingSubsequence {
	
	static void solve(int a[])
	{
		int n = a.length;
		
		int dp[] = new int[n];
		
		int final_max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			Integer max = null;
			for(int j=0;j<i;j++)
			{
				if(a[j] <= a[i])
				{
					if(max == null)
						max = dp[j];
					else if(dp[j] > max)
						max = dp[j];
				}
			}
			if(max == null)
				dp[i] = a[i];
			else
				dp[i] = max + a[i];
			
			if(dp[i] > final_max)
				final_max = dp[i];
		}
		
		System.out.println(final_max);
	}

	public static void main(String[] args) {
		int a[] = {1, 101, 2, 3, 100, 4, 5};
		solve(a);
		
		int a1[] = {3, 4, 5, 10};
		solve(a1);
		
		int a2[] = {10, 5, 4, 3};
		solve(a2);

	}

}
