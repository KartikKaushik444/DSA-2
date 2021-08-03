package dynamicProgramming;
// is x a subsequence of y
public class SequencePatternMatching {
	// try recursive code as well
	static boolean SPM(String x, String y)
	{
		int m = x.length();
		int n = y.length();
		
		int t[][] = new int [m+1][n+1];
		// find the length of the longest common subsequence
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
		
		if( t[m][n] == m)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String x = "AXY";
		String y = "ADXCPY";
		
		System.out.println(SPM(x, y));
		
		

	}

}
