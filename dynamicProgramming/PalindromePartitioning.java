package dynamicProgramming;

import java.util.Arrays;

public class PalindromePartitioning {
	
	static int t[][] = new int[10000][10000];
	
	static int solve(String s, int i, int j)
	{
		if(i >= j)
			return 0;
		
		if(isPalindrome(s.substring(i, j+1)))
			return 0;
		
		if(t[i][j] != -1)
			return t[i][j];
		int ans = Integer.MAX_VALUE;
		for(int k = i; k<= j - 1; k++)
		{
			int left, right;
			if(t[i][k]!=-1)
				left = t[i][k];
			else
				left = solve(s, i, k);
			
			if(t[k+1][j]!=-1)
				right = t[k+1][j];
			else
				right = solve(s, k+1, j);
				
			int temp = 1+ left + right;
			
			ans = Math.min(ans, temp);
		}
		
		return ans;
		
		
	}

	static boolean isPalindrome(String s)
	{
		if(s.length() == 0)
			return true;
		int i = 0;
		int j = s.length() - 1;
		
		while(i<j)
		{
			if(s.charAt(i) != s.charAt(j))
				return false;
			i++;
			j--;
		}
		
		return true;
	}
	
	// DP solution : O(n^3) approach similar to MCM
	static void DP(String s)
	{
		int n = s.length();
		boolean dp[][] = new boolean[n][n];
		// create a dp which will store whether a substring is a palindrome or  not
		for(int g=0;g<n;g++)
		{
			for(int i=0,j=g;j<n;i++, j++)
			{
				if(g == 0)
					dp[i][j] = true;
				else if(g == 1)
				{
					dp[i][j] = s.charAt(i) == s.charAt(j);
				}
				else
				{
					if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true)
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
			}
		}
		
		int [][]cuts = new int[n][n];
		for(int g=0;g<n;g++)
		{
			for(int i=0, j=g;j<n;i++, j++)
			{
				if(g == 0)
					cuts[i][j] = 0;
				else if(g == 1)
				{
					if(s.charAt(i) == s.charAt(j))
						cuts[i][j] = 0;
					else
						cuts[i][j] = 1;
				}
				else
				{
					if(dp[i][j])       //IMP
						cuts[i][j] = 0;
					else
					{
						int min = Integer.MAX_VALUE;
						// here k denotes that the cut will be after that character
						for(int k=i;k<=j-1;k++)
						{
							int left = cuts[i][k];
							int right = cuts[k+1][j];
							
							if(left + right + 1 < min)
								min = left + right + 1;
						}
						cuts[i][j] =  min;
					}
				}
				
			}
		}
		System.out.println(cuts[0][n-1]);
	}
	// Optimized approach is to use suffix or prefix cut technique as used in backtracking 
	// code using suffix cut
	// O(n^2)
	static void solveDP(String s)
	{
		int n = s.length();
		boolean dp[][] = new boolean[n][n];
		// create a dp which will store whether a substring is a palindrome or  not
		for(int g=0;g<n;g++)
		{
			for(int i=0,j=g;j<n;i++, j++)
			{
				if(g == 0)
					dp[i][j] = true;
				else if(g == 1)
				{
					dp[i][j] = s.charAt(i) == s.charAt(j);
				}
				else
				{
					if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true)
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
			}
		}
		
		int []cuts = new int[n];
		cuts[0] = 0;
		// running loop this way is imp to match i and j with dp
		for(int j=1;j<s.length();j++)
		{
			// string is from 0 to j
			// if i to j is valid suffix(palindrome)
			// than 0 to i-1 is prefix
			if(dp[0][j])
				cuts[j] = 0;          // IMPORTANT
			else
			{
				int min = Integer.MAX_VALUE;
				for(int i=j;i>=1;i--)
				{
					if(dp[i][j])
					{
						if(cuts[i-1] < min)
							min = cuts[i-1];
					}
					
					cuts[j] = min + 1;
				}
			}
		}
		
		System.out.println(cuts[n-1]);

	}
	public static void main(String[] args) {
		//String s = "nitiw";
		String s = "abccbc";
		for(int a[]:t)
			Arrays.fill(a, -1);
		
		System.out.println(solve(s, 0, s.length()-1));
		DP(s);
		solveDP(s);
		
	}

}
