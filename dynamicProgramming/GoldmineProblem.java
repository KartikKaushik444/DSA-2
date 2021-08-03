package dynamicProgramming;

public class GoldmineProblem {
	
	static void solve(int path[][])
	{
		int r = path.length;
		int c = path[0].length;
		int [][]dp = new int[r][c];
		// starting to fill dp from bottom right
		for(int j=c-1; j>=0; j--)
		{
			for(int i = r-1; i>=0; i--)
			{
				// initialization
				if(j == c-1)
					dp[i][j] = path[i][j];
				
				else if(i == 0)
					dp[i][j] = path[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
				
				else if(i == r-1)
					dp[i][j] = path[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);
				else
					dp[i][j] = path[i][j] + Math.max(dp[i][j+1], Math.max(dp[i-1][j+1], dp[i+1][j+1]));
			}
		}
		
		int max = dp[0][0];
		for(int i=1;i<dp.length;i++)
		{
			if(dp[i][0] > max)
			max = dp[i][0];
		}
		
		System.out.println(max);
	}

	public static void main(String[] args) {
		

	}

}
