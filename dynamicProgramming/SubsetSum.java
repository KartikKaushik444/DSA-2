package dynamicProgramming;
// return true if an array contains a subset with given sum
public class SubsetSum {
	
	static boolean subsetSum(int a[], int sum)
	{
		int n = a.length;
		boolean t[][] = new boolean[n+1][sum+1];
		
		// Initialization
		for(int j = 0; j< sum+1; j++)
		{
			t[0][j] = false;
		}
		
		for(int i = 0; i <n+1; i++)
		{
			t[i][0] = true;
		}
		
		for(int i = 1;i<n+1; i++)
		{
			for(int j=1; j< sum+1; j++)
			{
				if(a[i-1] > j)
					t[i][j] = t[i-1][j];
				else
				{
					t[i][j] = t[i-1][j] || t[i-1][j - a[i-1]];
				}
			}
		}
		
		return t[n][sum]; 
	}

	public static void main(String[] args) {
		int arr[] = {2, 3, 7, 8, 10};
		int sum  = 14;
		System.out.println(subsetSum(arr, sum));

	}

}
