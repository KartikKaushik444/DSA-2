package dynamicProgramming;

public class LCSThreeStrings {
	// Using 3D array
	static void LCS(String x, String y, String z)
	{
		int m = x.length();
		int n = y.length();
		int o = z.length();
		
		int t[][][] = new int [m+1][n+1][o+1];
		
		for(int i = 0; i< m+1;i++)
		{
			for(int j = 0; j< n+1; j++)
			{
				for(int k = 0;k < o+1;k++)
				{
					// Initialization
					if(i == 0 || j == 0 || k==0)
						t[i][j][k] = 0;
					
					else if(x.charAt(i - 1) == y.charAt(j - 1) && x.charAt(i - 1) == z.charAt(k-1))
						t[i][j][k] = 1 + t[i-1][j-1][k-1];
					
					else
						t[i][j][k] = Math.max(t[i-1][j][k], Math.max(t[i][j-1][k], t[i][j][k-1]));
				}
				
				
			}
		}
		System.out.println(t[m][n][o]);
	}

	public static void main(String[] args) {
		
		LCS("AGGT12", "12TXAYB", "12XBA");

	}

}
