package dynamicProgramming;
// given a non negative array count the number of subsequences having product less than k

public class SubsequencesWithProductLessK {
	// variation of count of subsets with a given sum
	static void solve(int []a, int k)
	{
		int n = a.length;
		int dp[][] = new int[n+1][k+1];
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=k;j++)
			{
				// number of subsequences using i-1 terms
				dp[i][j] = dp[i-1][j];
				
				// if a[i-1] > k, then it will definitely not contribute
				
				
				if(a[i-1] <= j && a[i-1] > 0)
					dp[i][j] = dp[i-1][j] +  (1 + dp[i-1][j/a[i-1]]) ; 

			}
		}
		System.out.println(dp[n][k]);
	}

	public static void main(String[] args) {

		int a[] = {1, 2, 3, 4};
		solve(a, 10);
		int a1[] = {4, 8, 7, 2};
		solve(a1, 50);
		

	}

}
