package dynamicProgramming;
// one more dp question on coins is present in recursion.WinCoinGame
// we can use a coin more than once
public class MinCoinChangeProblem {
	
	static int solve(int []coin, int sum)
	{
		int n = coin.length;
		int t[][] = new int[n+1][sum+1];
		
		
		for(int i = 0;i<n+1;i++)
		{
			for(int j =0 ;j<sum+1;j++)
			{
				// Initialization
				if(i ==0 || j==0 || i==1) {
					if(i==0)
						t[i][j] = Integer.MAX_VALUE - 1;
					if(j == 0)
						t[i][j] = 0;
					if(i == 1)
					{
						if(coin[i-1] > j)
							t[i][j] = Integer.MAX_VALUE-1;
						else if(j % coin[i-1] == 0)
							t[i][j] = j/coin[i-1];
						else
							t[i][j] = Integer.MAX_VALUE - 1;		
					}
				}
				// End of Initialization
				else {
					if(coin[i-1] > j)
						t[i][j] = t[i-1][j];
					else
						t[i][j] = Math.min(t[i-1][j], 1+t[i][j - coin[i-1]]);
				}
			}
		}
		
		return t[n][sum];
	}
	
	static void printMatrix(int [][]mat)
	{
		for(int i = 0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static void solve1(int a[], int n)
	{
		
		int dp[] = new int[n+1];
		dp[0] = 0;
		for(int i=1;i<=n;i++)
		{
			dp[i] = Integer.MAX_VALUE - 1;    // impossible
			// subtracting 1 bcoz if we add one to max value than it becomes min value 
			// which will give wrong answer
			// considering all option of coins one by one
			for(int j = 0; j<a.length;j++)
			{
				if(a[j] > i)
					continue;
				
				dp[i] = Math.min(dp[i], 1 + dp[i - a[j]]);
			}
			
		}
//	for(int i:dp)
//		System.out.print(i+" ");
		
		System.out.println(dp[n]);
	}
	
	
	public static void main(String[] args) {
		int coin[] = {3, 2, 1};
		int coint[] = {3, 2, 1};
		int coin1[] = {4, 6};
		
		int sum = 5;
		System.out.println(solve(coin1, sum));
		solve1(coin1, sum);
		int coins[] = {2, 3, 5};
		System.out.println(solve(coins,5));
		solve1(coins, 5);
		int rod[] = {2, 3, 5};
		System.out.println(solve(rod, 11));
		solve1(rod, 11);

	}

}
