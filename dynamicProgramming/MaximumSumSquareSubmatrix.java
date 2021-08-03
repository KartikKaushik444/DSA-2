package dynamicProgramming;
// return the maximum sum of a sqaure of given size in the matrix
public class MaximumSumSquareSubmatrix {
	// Bruteforce : O(n^4)
	static void solve(int[][] mat, int n)    // here n is the size of sqaure
	{
		int r = mat.length;
		int c = mat[0].length;
		int maxSum = Integer.MIN_VALUE;
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(i+n <= r && j+n<=c)
				{
					int sum = 0;
					for(int k=i;k<i+n;k++)
					{
						for(int l=j;l<j+n;l++)
						{
							sum += mat[k][l];
							
						}
					}
					maxSum = Math.max(sum, maxSum);
				}
			}
		}
		
		System.out.println(maxSum);
	}
	
	
	static void solveDP(int [][]mat, int n)
	{
		int r = mat.length;
		int c = mat[0].length;
		int maxSum = Integer.MIN_VALUE;
		
		int dp[][] = new int[r+1][c+1];
		// for total sum
		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[0].length;j++)
			{
				dp[i][j] = mat[i-1][j-1] + (dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] );
				// add from left and right and subtract diagonal because it is added twice
			}
		}
		
		// for processing
		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[0].length;j++)
			{
				if(i-n >= 0 && j-n >= 0)
				{
					int sum = (dp[i][j] - dp[i-n][j] - dp[i][j-n]) + dp[i-n][j-n];
					maxSum = Math.max(sum, maxSum);
				}	
			}
		}
		
		System.out.println(maxSum);
	}

	public static void main(String[] args) {
		int mat[][] = {
				{1, 2, -1, 4},
				{-8, -3, 4, 2},
				{3, 8, 10, -8},
				{-4, -1, 1, 7}
		};
		solve(mat, 3);
		solveDP(mat, 3);
	

	}

}
