package dynamicProgramming;
 // unbounded knapsack
public class RodCuttingProblem {
// this is cut strategy	
	static void solve(int price[])
	{
		int np[] = new int[price.length + 1];
		for(int i=1;i<np.length;i++)
		{
			np[i] = price[i-1];
		}
		
		int dp[] = new int[np.length];
		dp[0] = 0;
		dp[1] = np[1];
		for(int i=2;i<np.length;i++)
		{
			dp[i] = np[i];
			int li = 1;
			int ri = i-1;
			
			for(; li<i; li++, ri--)
			{
				if(np[li] + dp[ri] > dp[i])
				{	
					dp[i] = np[li] + dp[ri];	
				}
			}
		}	
		System.out.println(dp[np.length-1]);	
	}
	
	// this is left right strategy
	// this is a bit better
	static void solve1(int price[])
	{
		int np[] = new int[price.length + 1];
		for(int i=1;i<np.length;i++)
		{
			np[i] = price[i-1];
		}
		
		int dp[] = new int[np.length];
		dp[0] = 0;
		dp[1] = np[1];
		for(int i=2;i<np.length;i++)
		{
			dp[i] = np[i];
			int li = 1;
			int ri = i-1;
			
			while(li<=ri)
			{
				if(dp[li] + dp[ri] > dp[i])
					dp[i] = dp[li]+dp[ri];
				li++;
				ri--;
			}
		}	
		System.out.println(dp[np.length-1]);
		
	}

	public static void main(String[] args) {
		int a[] = {1, 5, 8, 9, 10, 17,17, 20};
		solve(a);
		solve1(a);

	}

}
