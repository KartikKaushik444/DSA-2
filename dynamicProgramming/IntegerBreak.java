package dynamicProgramming;
// given a number n task is to break the n in such a way that multiplication of its parts is maximized
// number has to be broken in at least two parts. Return maximum product possible
public class IntegerBreak {
	
	static void solve(int n)
	{
		int dp[] =  new int[n+1];
		dp[1]  = 1;
		dp[2] = 2;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<i;j++)
			{
				// IMP: it is important to take max of dp[i-j] and i-j bcoz dp will store max product
				// possible for value which can not include the number itself due to constraint
				// Eg - dp[3] will store 2, but if we want the max value of product we can simply use
				// number 3, which will not violate the constraint
				dp[i] = Math.max(dp[i], j * (Math.max(dp[i-j], i-j)));
			}
		}
		
		System.out.println( dp[n]);
	}

	public static void main(String[] args) {
		solve(10);
		solve(8);
		solve(45);

	}

}
