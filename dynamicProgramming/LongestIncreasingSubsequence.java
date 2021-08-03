package dynamicProgramming;

public class LongestIncreasingSubsequence {
	
	
	// One method of finding LIS is using LCS(longest common subsequence)
	// 1. create copy of original array a to b
	// 2. than sort b
	// 3. Finally find LCS of a and b, it will be LIS
	// TC : O(n^2 + nlogn)

	static int LISrec(int a[])
	{
		int n = a.length;
		
		return LISRec(a, n, Integer.MAX_VALUE);
	}
	
	static int LISRec(int a[], int n, int v)
	{
		if( n == 0)
			return 0;
		
		if(a[n-1] >= v)
			return LISRec(a, n-1, v);
		
		return Math.max(LISRec(a, n-1, v), 1 + LISRec(a, n-1, a[n-1]));
		
	}
	
	
	static int LISdp(int a[])
	{
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
				if(a[i] > a[j] && lis[j] + 1 > lis[i] )
					lis[i] = lis[j] + 1;
			}
		}
		
		
		// select the max out of all the lis
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++)
		{
			max = Math.max(max, lis[i]);
		}
		return max;
	}
	
	
	static int maxSumIS(int []a)
	{
		int n = a.length;
		
		int MIS[] = new int[n];
		// Initialization
		for(int i=0;i<n;i++)
		{
			MIS[i] = a[i];
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(a[i] > a[j] && MIS[j] + a[i] >MIS[i])
				{
					MIS[i] = MIS[j] + a[i];
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i : MIS)
		{
			max = Math.max(max, i);
		}
		
		return max;
	}

	public static void main(String[] args) {
		int a[]= {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(LISrec(a));
		System.out.println(LISdp(a));
		
		int a1[] = {3, 10, 2, 1, 20};
		System.out.println(LISrec(a1));
		System.out.println(LISdp(a1));
		
		int a2[] = {3, 2};
		System.out.println(LISrec(a2));
		System.out.println(LISdp(a2));
		
		int a3[] = {50, 3, 10, 7, 40, 80};
		System.out.println(LISrec(a3));
		System.out.println(LISdp(a3));
		
		int a4[] = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(maxSumIS(a4));
		
		int a5[] = { 3, 4, 5, 10};
		System.out.println(maxSumIS(a5));
		
		int a6[] = {10, 5, 4, 3};
		System.out.println(maxSumIS(a6));
	}

}
