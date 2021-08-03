package dynamicProgramming;

public class ShortestCommonSupersequence {
// given two strings str1 and str2, find the length of the shortest string that has both str1 and str2
// as subsequences
	// same concept can be used to solve minimum insertion or deletion to convert from a to b
	static int SCS(String x, String y)
	{
		// First find LCS
		
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
		
		int lcs = t[m][n];
		
		
		
		// For solving min insertion and deletion to convert from a to b
		// DO THIS:
//		int deletion = m - lcs;
//		int insertion = n - lcs;
//		
//		return insertion + deletion;
		
		
		// For printing SCS
		
		int i = m;
		int j = n;
		String ans ="";
		
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
					ans = x.charAt(i-1) + ans;
					i = i-1;
					
				}
				else
				{
					ans = y.charAt(j-1) + ans;
					j = j-1;
					
				}
				

				
			}
			

		}
		//System.out.println(ans);
		if(j == 0)
		{
			// means y string is empty. So print remaining x string
			while(i>0)
			{
				ans = x.charAt(i-1) + ans;
				i--;
			}
		}
		else
		{
			while(j>0)
			{
				ans = y.charAt(j-1) + ans;
				j--;
			}
		}
		
		System.out.println(ans);
		
		return m + n -lcs;
	}

	public static void main(String[] args) {
		
		String x = "geek";
		String y = "eke";
		System.out.println(SCS(x, y));
		String x1 = "heap";
		String y1 = "pea";
		
//		String x = "acbcf";
//		String y = "abcdaf";
		
		System.out.println(SCS(x1, y1));
		String x2 = "AGGTAB";
		String y2 = "GXTXAYB";
		System.out.println(SCS(x2, y2));

	}

}
