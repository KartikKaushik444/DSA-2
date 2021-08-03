package dynamicProgramming;
// given a rod of length l, the task is to cut the rod in such a way that the total number of segments
// of length p, q and r is maximized. The segments can only be of length p, q and r
public class MaximizeTheCutSequence {
	// same code as min Coin change problem
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
						t[i][j] = Integer.MIN_VALUE;  // Used min instead instead of max
					if(j == 0)
						t[i][j] = 0;
					if(i == 1)
					{
						if(coin[i-1] > j)
							t[i][j] = Integer.MIN_VALUE;
						else if(j % coin[i-1] == 0)
							t[i][j] = j/coin[i-1];
						else
							t[i][j] = Integer.MIN_VALUE;		
					}
				}
				// End of Initialization
				else {
					if(coin[i-1] > j)
						t[i][j] = t[i-1][j];
					else
						t[i][j] = Math.max(t[i-1][j], 1+t[i][j - coin[i-1]]);
				}
			}
		}
		
		return t[n][sum];
	}
	
	// can also be done in O(n)
	
	static void solve1(int arr[], int n)
	{
		int a = arr[0];
		int b = arr[1];
		int c = arr[2];
		int dp[] = new int[n+1];
		dp[0] = 0;
		for(int i=1;i<=n;i++)
		{
			dp[i] = Integer.MIN_VALUE;    // impossible
			
			if(i >= a)
				dp[i] = Math.max(dp[i], dp[i-a] + 1);  // considering a  option
			
			if(i >= b)
				dp[i] = Math.max(dp[i], dp[i-b] + 1);  // considering b option
			
			if(i >= c)
				dp[i] = Math.max(dp[i], dp[i-c] + 1);  // considering c option 
			
			
		}
		
		System.out.println(dp[n]);
	}

	public static void main(String[] args) {
		int a[] = {2, 3, 5};
		System.out.println(solve(a, 11));
		
		int a1[] = {2, 5, 5};
		System.out.println(solve(a1, 7));
		
		solve1(a, 11);
		solve1(a1,7);

	}

}
