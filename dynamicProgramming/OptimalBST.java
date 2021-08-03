package dynamicProgramming;

public class OptimalBST {
	
	static void solve(int keys[], int freq[])
	{
		// it is important that keys are present in sorted order
		int n = keys.length;
		int [][]dp = new int[n][n];
		
		for(int g=0;g<n;g++)
		{
			for(int i=0,j=g;j<n;i++,j++)
			{
				if(g == 0)
					dp[i][j] = freq[i];
				else if(g == 1)
				{
					int f1 = freq[i];
					int f2 = freq[j];
					dp[i][j] = Math.min(f1 + 2*f2 , f2 + 2*f1);
				}
				else
				{
					int min = Integer.MAX_VALUE;
					int fs=0;
					// this fs is important to add because for each node depth increases by one
					
					for(int f=i;f<=j;f++)
					{
						fs += freq[f];
					}
					// we can use prefix sum to optimize this calculation of fs
					// here k represents root and trying every possible root from i to j
					// fs will also include cost of root, so no need to add again 
					for(int k=i;k<=j;k++)
					{
						int left = k == i? 0:dp[i][k-1];      // IMP: corner case
						int right = k == j? 0:dp[k+1][j];
						min = Math.min(min, left + right + fs);
					}
					dp[i][j] = min;
				}
			}
		}
		System.out.println(dp[0][n-1]);
	}

	public static void main(String[] args) {
		int keys[] = {10,12};
		int f[] = {34, 50};
		solve(keys, f);
		
		int keys1[] = {10, 12, 20};
		int f1[] = {34, 8, 50};
		solve(keys1, f1);
	}

}
