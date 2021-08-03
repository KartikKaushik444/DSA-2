package dynamicProgramming;
// You are given a pattern and a string. Pattern contains alphabets with two special character
// ? and *. ? can replace itself by anyone of the alphabets while * can replace itself with _ means
// nothing to any string of any length
// We have to find out whether it is possible to match the pattern with the string by changing
// special characters according to their properties

// Approach:
// create a 2d dp- dp[i][j] stores the ans for pattern(i to n) and string(j to m)
// three options are possible 
// character - if ch than if it matches than check for the remaining string otherwise it is false
// ? - it can be replaced with with any character hence just check for remaining answer
// * - we can take or value by making * as blank, than first character, than first two ch string and
// so on. This way it TC: O(n^3)
// it can be optimized by taking OR of dp[i+1][j] and dp[i][j+1] because dp[i][j+1] already stores
// OR value of the remaining operations

// TC = SC =:O(n^2)
// Can also be solved in O(n) time and O(1) space ( on gfg)
public class WildCardPatternMatching {
	
	// Approach
	static boolean solve(String str, String patt) // pattern contains special characters
	{
		int m = patt.length();
		int n = str.length();
		// pattern on y7-axis and string on x-axis
		boolean [][]dp = new boolean[m+1][n+1];
		// dp[i][j] stores the result of i....m and j.....n 
		// fill the dp from bottom
		for(int i=m;i>=0;i--)
		{
			for(int j=n;j>=0;j--)
			{
				if(i == m && j == n)      // last cell
				{
					dp[i][j] = true;
				}
				
				else if(i == m)        // last row
				{
					dp[i][j] = false;
				}
				
				else if(j == n)     // last column
				{
					// star has only one option against blank i.e to become blank
					// than simply put result of rest of the string
					if(patt.charAt(i) == '*')
						dp[i][j] = dp[i+1][j];
					else
						dp[i][j] = false;
				}
				
				else
				{
					if(patt.charAt(i) == '?')
						dp[i][j] = dp[i+1][j+1];
					
					else if(patt.charAt(i) == '*')
						dp[i][j] = dp[i+1][j] || dp[i][j+1];
					// if star stood for no character than look for dp[i+1][j]
					
					else if(patt.charAt(i) == str.charAt(j))
					{
						dp[i][j] = dp[i+1][j+1];
					}
					else
					{
						dp[i][j] = false;
					}
				}

			}
			
		}
		
		System.out.println(dp[0][0]);
		
		return dp[0][0];
	}

	public static void main(String[] args) {
		solve("baaabab", "ba*a?");
		solve("baaabab", "*****ba*****ab");
		solve("baaabab", "baaa?ab");
		solve("baaabab","ba*a?");
		solve("baaabab", "a*ab?");
		solve("aa", "*");
		
	}

}
