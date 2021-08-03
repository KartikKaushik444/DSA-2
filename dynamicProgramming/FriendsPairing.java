package dynamicProgramming;


// given n friends output the total number of ways in which they can be paired up
// any one friend can either remain single or make a pair with another friend
// only pair of two is allowed not more than than 2
// Eg - for n = 3
// 1-2-3, 1-23, 13-2, 12-3. So, answer is 4
// IMP: No permuatations (1-2 and 2-1 are counted as same only)
public class FriendsPairing {
	// one member can make a new group or combine with any one of the left
	

	static void solve(int n)
	{
		int []dp = new int[n+1];
		dp[1] =1;
		dp[2] = 2;
		// if n-th person remains single than recur for f(n-1)
		//else it pairs with any of the remaining n-1 persons and after pairing with any one n-2 will be left
		for(int i=3;i<=n;i++)
		{
			dp[i] = dp[i-1] + (i-1) * dp[i-2];
		}
		
		System.out.println(dp[n]);
	}

	public static void main(String[] args) {
	
		solve(4);

	}

}
