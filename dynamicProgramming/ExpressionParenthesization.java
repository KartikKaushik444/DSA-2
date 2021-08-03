package dynamicProgramming;

// return no of ways of parenthesization such that given expression gives the true output

public class ExpressionParenthesization {
	
	static int solve(String s, int i, int j, boolean isTrue)
	{
		if(i > j)
			return 0;
		if(i == j)
		{
			if(isTrue)
			{
				if(s.charAt(i) == 'T')
					return 1;
				else
					return 0;
			}
			else
			{
				if(s.charAt(i) == 'F')
					return 1;
				else
					return 0;
			}
		}
		
		int ans = 0;
		
		for(int k = i+1; k<=j-1; k+=2)   // k should always point at the operand
		{
			// ways to create true from left side
			int lt = solve(s, i, k-1, true);
			//similarly calculating others
			int lf = solve(s, i, k-1, false);
			int rt = solve(s, k+1, j, true);
			int rf = solve(s, k+1, j, false);
			
			if(s.charAt(k) == '&')
			{
				if(isTrue == true)
					ans = ans + lt * rt;
				else
					ans = ans + lf * rf + lf * rt + lt * rf;
			}
			
			else if(s.charAt(k) == '|')
			{
				if(isTrue == true)
					ans = ans + lt * rt + lt * rf + lf * rt;
				else
					ans = ans + lf * rf;
			}
			
			else if(s.charAt(k) == '^')
			{
				if(isTrue == true)
					ans = ans + lt * rf + lf * rt;
				else
					ans = ans + lf * rf + lt * rt; 
			}
			
		}
		
		return ans;
		
	}
	
	// dp solution
	// s1 will contain operands and s2 will contain operators(so size will always be one less than s1)
	static void solveDP(String s1, String s2)
	{
		int n = s1.length();
		int[][] dpt = new int[n][n];    // to store true values
		int[][] dpf = new int[n][n];    // to store false values
		
		for(int g=0;g<n;g++)
		{
			for(int i=0, j=g;j<n;i++, j++)
			{
				if(g == 0)
				{
					char ch = s1.charAt(i);
					
					if(ch == 'T')
					{
						dpt[i][j] = 1;
						dpf[i][j] = 0;
					}
					else
					{
						dpt[i][j] = 0;
						dpf[i][j] = 1;
					}
				}
				
				else
				{
					// k is always going to point at operator
					for(int k=i;k<=j-1;k++) // here we are breaking this string at every operand
					{
						char opr = s2.charAt(k);
					
						int lt = dpt[i][k];    // left true count
						int rt = dpt[k+1][j];
						int lf = dpf[i][k];
						int rf = dpf[k+1][j];
						
						if(opr == '&')
						{
							dpt[i][j] +=  lt * rt;            //IMP : +=
							dpf[i][j] +=  lf * rf + lf * rt + lt * rf;
						}
						else if(opr == '|')
						{
							
							dpt[i][j] +=  lt * rt + lt * rf + lf * rt;
						
							dpf[i][j] +=  lf * rf;
						}
						else // '^'
						{
							dpt[i][j] += lt * rf + lf * rt;
							
							dpf[i][j] += lf * rf + lt * rt; 
						}
					}
				}
			}
		}
		
		System.out.println(dpt[0][n-1]);
	}

	public static void main(String[] args) {
//		String s = "T^F&T";
//		String s = "T^F|F";
		String s = "T|T&F^T";
		boolean isTrue = true;
		
		System.out.println(solve(s, 0, s.length()-1, isTrue));
		
		// This  question can also be given in the below  format
		// symbol[] = {T, T, F, T}
		// operator[] = {|, &, ^}
		solveDP("TTFT", "|&^");
		

	}

}
