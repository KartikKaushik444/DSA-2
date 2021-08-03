package dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequence {
	
	// Recursive approach
	static int LCSRec(String x, String y, int m, int n)
	{
		if(m== 0 || n==0)
			return 0;
		
		if(x.charAt(m-1) == y.charAt(n-1))
			return 1+ LCSRec(x, y, m-1, n-1);
		
		else
		{
			return Math.max(LCSRec(x, y, m, n-1), LCSRec(x, y, m-1, n));
		}
	}
	
	// Top-Down(Memoization)
	
	static int TD_LCS(String x, String y)
	{
		int m = x.length();
		int n = y.length();
		
		for(int [] arr : t)
			Arrays.fill(arr, -1);
		
		return TD_LCS( x, y, m, n);
	}
	
	static int TD_LCS(String x, String y, int m, int n)
	{
		if(m== 0 || n==0)
			return 0;
		
		if(t[m][n] != -1)
			return t[m][n];
		
		if(x.charAt(m-1) == y.charAt(n-1))
			return t[m][n] = 1+ TD_LCS(x, y, m-1, n-1);
		
		else
		{
			return  t[m][n] = Math.max(TD_LCS(x, y, m, n-1), TD_LCS(x, y, m-1, n));
		}
	}

	// Bottom - UP
	
	static int BU_LCS(String x, String y)
	{
		int m = x.length();
		int n = y.length();
		
		int t[][] = new int [m+1][n+1];
		
		for(int i = 0; i< m+1;i++)
		{
			for(int j = 0; j< n+1; j++)
			{
				// Initialization
				if(i == 0 || j == 0)
					t[i][j] = 0;
				
				else if(x.charAt(i - 1) == y.charAt(j - 1))
					t[i][j] = 1 + t[i-1][j-1];
				
				else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				
				
			}
		}
		
		int i = m;
		int j = n;
		String ans="";
		while(i>0 && j>0)
		{
			if(x.charAt(i-1) == y.charAt(j-1))
			{
				ans = x.charAt(i-1) + ans; 
				i = i-1;
				j = j-1;
			}
			
			else
			{
				int a = t[i-1][j];
				int b = t[i][j-1];
				if(a>b)
				{
					i = i-1;
				}
				else
				{
					j = j-1;
				}
			}
		}
		
		System.out.println(ans);
		
		return t[m][n];
	}
	
	// space optimized version of lcs
	//IMP: In simple implementation, in each iteration loop we only need value from all columns of 
	// previous rows
	
	static void OpLCS(String x, String y)
	{
		int m = x.length();
		int n = y.length();
		
		int dp[][] = new int[2][n+1];
		
		int bi = 0;
		for(int i=0;i<=m;i++)
		{
			// using binary index
			// if i is odd than bi is 1 else 0
		    bi = i&1;
			for(int j=0;j<=n;j++)
			{
				if(i == 0 || j == 0)
					dp[bi][j] = 0;
				
				else if(x.charAt(i-1) == y.charAt(j-1))
					dp[bi][j] = 1 + dp[1 - bi][j-1];
				
				else
					dp[bi][j] = Math.max(dp[1 - bi][j], dp[bi][j-1]);
				
			}
		}
		System.out.println(dp[bi][n]);
	}
	
	
	static int t[][] = new int[500+1][500+1];
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "AGGTAB";
		String y = "GXTXAYB";
		
		System.out.println(LCSRec(x, y, x.length(), y.length()));
		System.out.println(TD_LCS(x, y));
		System.out.println(BU_LCS(x, y));
		OpLCS(x, y);

	}

}

//500068649
//G3UdKA@1
