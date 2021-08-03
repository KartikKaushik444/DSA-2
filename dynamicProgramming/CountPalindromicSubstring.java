package dynamicProgramming;

public class CountPalindromicSubstring {
	
	static int countPS(String s)
	{
		int n = s.length();
		// x-axis is start , y-axis is end
		boolean dp[][] = new boolean[n][n];
		
		int count = 0;
		for(int g=0;g<n;g++)
		{
			for(int i=0, j=g; j < n;i++, j++)
			{
				// start of Initialization
				if(g==0)
					dp[i][j] = true;
				else if(g == 1)
				{
					if(s.charAt(i) == s.charAt(j))
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
				// End of Initialization
				else
				{
					if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true)
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
				
				if(dp[i][j])
				{
					count++;
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		String s = "abccbc";
		System.out.println(countPS(s));

	}

}
