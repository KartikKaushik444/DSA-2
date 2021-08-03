package dynamicProgramming;

// Cn = C0*Cn-1 + C1*Cn-2 +C2*Cn-3 + ------Cn-1*C0
public class CatalanNumber {
// catalan number can be used to give number of binary search tree possible with n nodes
// bsts possible are 
	// n = 0    1
	// n = 1    1
	// n = 2    2
	// n = 3    5
	// n = 4    14
	// for n = 4 take 4 values [10, 20, 30, 40]
	// now make each one of them root one by one 
	// than total bsts = f(0).f(3) + f(1).f(2) + f(2).f(1) + f(3).f(0) = 14
	// It is nothing but catalan numbers
// same code can be used
	static void solve(int n)
	{
		int []dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i=2; i<dp.length;i++)
		{
			for(int j = 0;j<i;j++)
			{
				dp[i] += dp[j] * dp[i-j-1];
				
			}
		}
		
		System.out.println(dp[n]);
	}

	public static void main(String[] args) {
		solve(5);
		solve(4);

	}

}
