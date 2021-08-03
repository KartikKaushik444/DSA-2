package dynamicProgramming;

public class LongestRepeatingSubsequence {
	
	static int LRS(String x)
	{
		 String y = x;
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
					
					else if(x.charAt(i - 1) == y.charAt(j - 1) && i!=j)  // not including diagonal element
						t[i][j] = 1 + t[i-1][j-1];						// because they denote one character
					
					else
						t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
					
					
				}
			}
			
			
			return t[m][n];
			
			
	}
	
	

	public static void main(String[] args) {
		  String x = "AABEBCDD";
		  System.out.println(LRS(x));
		  String y = "AXXXY";
		  System.out.println(LRS(y));
		  String z = "AACAAB";
		  System.out.println(LRS(z));

	}

}
