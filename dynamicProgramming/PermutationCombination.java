package dynamicProgramming;


// pattern
// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
// It is a pascal triangle.
// Any row can be calculated by previous row by adding ith element of prev row with i-1th element
// of prev row
// Since ncr = ncn-r, we can calculate the smaller one
// TC : O(n*r)
// SC : O(r)

// we can use inverse modulo to compute in O(r) time
   
public class PermutationCombination {
	// compute binary coefficient
	static int combination(int n, int r)
	{
		if(n<r)
		{
			System.out.println(0);
			return 0;
		}
		if(n-r < r)
			r = n-r;
		int mod = 1000000007;
		int dp[] = new int[r+1]; 
		
		dp[0] = 1;
			
		for(int i=1;i<=n;i++)
		{
			for(int j=Math.min(i, r);j>0;j--)  // taking min to avoid extra computation
			{
				dp[j] = (dp[j] + dp[j-1])%mod;
			}
		}
		System.out.println(dp[r]);
		return dp[r];
	}
	
////////////////////////////////////////////////////////////////////////////////////
	// compute permutaion coefficient
	// npr = n!/(n-r)!
	// simply calculate factorial
	// TC:O(n)
	// SC:o(n)
	static int permut(int n, int r)
	{
		int dp[] = new int[n+1];    // to store factorial
		dp[0] = 1;
		for(int i=1;i<=n;i++)
		{
			dp[i] = i*dp[i-1];
		}
		
		int ans = dp[n]/dp[n-r];
		System.out.println(ans);
		return ans;
	}
	// SC:O(1) solution
	// if we expand n! and cut (n-k)! than we just need to computer
	// n*n-1*n-2 ------ n-k+1
	
	static int permutation(int n, int r)
	{
		int ans = 1;
		for(int i=n;i>=n-r+1;i--)
		{
			ans *= i;
		}
		System.out.println(ans);
		return ans;
	}
	

	public static void main(String[] args) {
		combination(4, 2);
		combination(5, 2);
		combination(5, 1);
		permut(10, 2);
		permut(10, 3);
		permut(10, 0);
		permut(10, 1);
		permutation(10, 2);
		permutation(10, 3);
		permutation(10, 0);
		permutation(10, 1);
		permutation(5, 3);

	}

}
