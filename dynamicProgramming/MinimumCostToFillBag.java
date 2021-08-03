package dynamicProgramming;

public class MinimumCostToFillBag {
	
// variation of rod cutting problem
// instead of max we need min
// here cost[i] denotes cost of i kg packet of anything(consider orange)
// where cost[i] = -1, means i kg packet is unavailable
// infinite amount of packets are  available
// find minimum cost to buy exactly W kg
	// used cut strategy
	static void solve(int cost[], int w)
	{
		int n = cost.length;	
		int dp[] = new int [w+1];
		dp[0] =0;
		for(int i=1; i<w+1 ;i++)
		{
			int min_cost = Integer.MAX_VALUE;
			for(int j=0;j<i;j++)
			{
				min_cost = Math.min(min_cost, cost[j] + dp[i-j-1]);
			}
			dp[i] = min_cost;
		}
		System.out.println(dp[n]);
	}
	public static void main(String[] args) {
		int cost[] = {20, 10, 4, 50, 100};
		solve(cost, 5);

	}

}
