package dynamicProgramming;

public class TotalWaysCoinChangeProblem {
	// same code as count subsets for given sum with one change of unbounded knapsack
	// same code can be used for count number of ways to reach a given score in game
	// it will give combinations and not permutations
	// for 2, 3, 5 coins and sum 7 :combinations - 2, 2, 3 & 2,5    permutations:- 2,2,3&3,2,2&2,3,2&5,2&2,5 
	static int totalWays(int []coin, int sum)
	{
		int n = coin.length;
		int t[][] = new int [n+1][sum+1];
		//Initialization
		
		for(int j =0; j<sum+1;j++)
		{
			t[0][j] = 0;
		}
		for(int i =0; i<n+1;i++)
		{
			t[i][0] = 1;
		}
		
		for(int i=1; i<n+1 ;i++)
		{
			for(int j=1; j<sum+1;j++)
			{
				
				if(coin[i-1] > j)
				{
					t[i][j] = t[i-1][j];
				}
				else
				{
					t[i][j] = t[i-1][j] + t[i][j - coin[i-1]];
				}
			}
		}
		
		
		return t[n][sum];
	}
	// the above solution for combination can be optimized memory wise
	static void combinations(int coins[], int sum)
	{
		int dp[] = new int[sum+1];
		dp[0] = 1;
		for(int i=0;i<coins.length;i++)   // trying every possible coin
		{
			for(int j=coins[i];j<=sum;j++)  // fill dp for each sum value using ith coin
			{
				dp[j] += dp[j - coins[i]];
			}
		}
		System.out.println(dp[sum]);
	}
	
	static void permutations(int coins[], int sum)
	{
		int []dp = new int[sum+1];
		dp[0] = 1;
		for(int i=0;i<=sum;i++)
		{
			for(int coin:coins)
			{
				if(coin <= i)
				{
					dp[i] += dp[i - coin];
				}
			}
		}
		System.out.println(dp[sum]);
	}

	public static void main(String[] args) {
		int coin[] = {1, 2, 3, 4};
		int sum = 5;
		
		System.out.println(totalWays(coin, sum));
		combinations(coin, 5);
		int point[] = {3, 5, 10};
		System.out.println(totalWays(point, 20));
		combinations(point, 20);
		System.out.println(totalWays(point, 13));
		combinations(point, 13);
		int coins[] = {2, 3, 5};
		System.out.println(totalWays(coins,7));
		combinations(coins, 7);
		int coins1[] = {2, 4, 6, 8};
		System.out.println(totalWays(coins1, 8));
		combinations(coins1, 8);
		
		
		permutations(coins, 7);

	}

}
