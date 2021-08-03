package dynamicProgramming;
// sequence of positive integers are given
// 1. Maximum subsequence sum such that no two are adjacent
// 2. Maximum subsequence sum such that no three are adjacent
public class MaxSubsequenceSum {
	
	static void solve(int a[])
	{
		int n = a.length;
		int inc = a[0];
		int exc = 0;
		
		for(int i=1;i<n;i++)
		{
			int ninc = exc + a[i];
			int nexc = Math.max(inc, exc);
			
			inc = ninc;
			exc = nexc;
		}
		System.out.println(Math.max(inc, exc));
	}
	
	static void solve1(int a[])
	{
		int n = a.length;
		int sum[] = new int[n];
//		sum[i] stores answer of subproblem a[0...i]
		
		// Initialization
		if(n>=1)
			sum[0] = a[0];
		if(n>=2)
			sum[1] = a[0] + a[1];
		if(n>2)
			sum[2] = Math.max(Math.max(a[1] + a[2], a[0] + a[2]), sum[1]);
		
		
		// we have 3 cases
//		1: exclude a[i], i.e, sum[i] = sum[i-1]
//		2: exclude a[i-1], i.e, sum[i] = sum[i-2] + a[i]
//		3: exclude a[i-2], i.e, sum[i] = sum[i-3] + a[i] + a[i-1]
//		sum[i] would be maximum of above cases
		for(int i=3;i<n;i++)
		{
			sum[i] = Math.max(Math.max(sum[i-1], sum[i-2] + a[i]), a[i] + a[i-1] + sum[i-3]);
		}
		System.out.println(sum[n-1]);
	}
	
	public static void main(String[] args) {
		int a[] = {1, 2, 3};
		solve1(a);
		
		int a1[] = {3000, 2000, 1000,3, 10};
		solve1(a1);
		
		int a2[] = {100, 1000, 100, 1000, 1};
		solve1(a2);
		
		int a3[] = {1, 1, 1, 1, 1};
		solve1(a3);
		
		int a4[] = {1, 2, 3, 4, 5, 6, 7, 8};
		solve1(a4);
		

	}

}
