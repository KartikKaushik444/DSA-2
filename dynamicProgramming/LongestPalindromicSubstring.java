package dynamicProgramming;

public class LongestPalindromicSubstring {
	
	static int lps(String s)
	{
		int n = s.length();
		
		boolean dp[][] = new boolean[n][n];
		
		int a = 0;
		int b = 0;
		int len = 0;
		
		for(int g=0;g<n;g++)
		{
			for(int i = 0,j = g;j<n;j++, i++)
			{
				if(g==0)
					dp[i][j] = true;
				else if(g == 1)
				{
					if(s.charAt(i) == s.charAt(j))
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
				else
				{
					if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true)
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
				
				if(dp[i][j])
				{
					len = g+1;
					a = i;
					b = j;
				}
			}
		}
		
		System.out.println(s.substring(a, b+1));
		return len;
	}

	public static void main(String[] args) {
		String s = "forgeeksskeegfor";
		String s1 = "Geeks";
		System.out.println(lps(s));
		System.out.println(lps(s1));

	}

}
