package dynamicProgramming;

public class UnboundedKnapsack {
	
	//static int t[][] = new int [200+1][500+1];
// this can be optimized in terms of space	
	static int UKnapsack(int[] weight, int[] value, int w)
	{
		int n = weight.length;	
		int t[][] = new int [n+1][w+1];
		for(int i=0; i<n+1 ;i++)
		{
			for(int j=0; j<w+1;j++)
			{
				if(i==0 || j==0)
				{
					t[i][j] = 0;
				}
				
				else if(weight[i-1] > j)
				{
					t[i][j] = t[i-1][j];
				}
				else
				{
					// we don't need previous row, so only 1D array is enough
					t[i][j] = Math.max(t[i-1][j],value[i-1] + t[i][j - weight[i-1]]);
				}
			}
		}
		
		
		return t[n][w];
	}
	// SC : O(n) solution
	static void solve(int weight[], int value[], int w)
	{
		int dp[] = new int[w+1];
		for(int i=0;i<=w;i++)
		{
			for(int j=0;j<weight.length;j++)
			{
				if((weight[j] <= i) && (value[j] + dp[i - weight[j]] > dp[i]))
				{
					dp[i] = value[j] + dp[i - weight[j]];
				}
					
					
			}
		}
		
		System.out.println(dp[w]);
	}

	public static void main(String[] args) {
		int weight[] = {1, 3, 4, 5};
		int value[] = {10, 40, 50, 70};
		int w = 8;
		System.out.println(UKnapsack(weight, value, w));
		solve(weight, value, w);
		
		int weight1[] = {1, 50};
		int value1[] = {1, 3, 4, 5};
		int w1 = 100;
		System.out.println(UKnapsack(weight1, value1, w1));
		solve(weight1, value1, w1);
		// Same code can solve rod cutting problem
		
		int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int profit[] = {1, 5, 8, 9, 10, 17, 17, 20};
		int n = 8;
		
		System.out.println(UKnapsack(length, profit, n));
		solve(length, profit, n);
		
		
		

	}

}
