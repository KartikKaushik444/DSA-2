package dynamicProgramming;
// you are given pair of numbers. In every pair, the first number is always smaller than the second
// number.
// A pair (c,d) can follow another pair(a, b) if b<c => (a, b)(c, d) 
public class MaxChainLength {
	// variation of lis
	static void solve(int a[][])
	{
		// for this array must be sorted in increasing order with respect to start(or smaller value in pair)
		// considering array is sorted with respect to start
		int n =a.length;
		
		int lis[] = new int[n];
		
		// Initialisation
		for(int i=0;i<n;i++)
		{
			lis[i] = 1;
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(a[i][0] > a[j][1] && lis[j] + 1 > lis[i] )
					lis[i] = lis[j] + 1;
			}
		}
		
		
		// select the max out of all the lis
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			max = Math.max(max, lis[i]);
		}
		System.out.println(max);
	}
	
	

	public static void main(String[] args) {

		int a[][] = {
				{5, 24},
				{15, 28},
				{27, 40},
				{39, 60},
				{50, 90}
				
		};
		solve(a);
		
		int a1[][] = {
				{5, 10},
				{1, 11},
				
		};
		solve(a1);

	}

}
