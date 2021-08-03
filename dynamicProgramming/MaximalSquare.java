package dynamicProgramming;
// this same concept can be used to solve count square submatrices with all ones
public class MaximalSquare {
	
	static void solve(int a[][])
	{
		int r = a.length;
		int c = a[0].length;
		int ans = Integer.MIN_VALUE;
		int dp[][] =new int[r+1][c+1];
		
		for(int i=1;i<=r;i++)
		{
			for(int j=1;j<=c;j++)
			{
//				if(a[i-1][j-1] == 0)
//					dp[i][j] = 0;
//				else if(dp[i-1][j-1] == dp[i-1][j] &&dp[i-1][j] == dp[i][j-1])
//				{
//					dp[i][j] = dp[i-1][j] + 1;
//					ans = Math.max(ans, dp[i][j]);
//				}
//				else
//				{
//					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
//				}
				// simply we could have written
				if(a[i-1][j-1] == 1)
				{
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
					ans = Math.max(ans, dp[i][j]);
				}
				
			}
		}
//		for(int i=0;i<r+1;i++)
//		{
//			{
//				System.out.println();
//		
//				for(int j=0;j<c+1;j++)
//					System.out.print(dp[i][j] + " ");
//			}
//		}
		System.out.println(ans);
		
	}

	public static void main(String[] args) {
		int a[][] = {
				{1, 0, 1, 1, 1},
				{1, 0, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 0, 0, 1, 0}
		};
		solve(a);

	}

}
