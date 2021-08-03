package dynamicProgramming;

public class CountSubsetsForGivenSum {
	
	static int countSubsets(int arr[], int sum)
	{
		int n = arr.length;
		int t[][] = new int [n+1][sum+1];
		
		// Initialization
				for(int j = 0; j< sum+1; j++)
				{
					t[0][j] = 0;
				}
				
				for(int i = 0; i <n+1; i++)
				{
					t[i][0] = 1;
				}
				
		for(int i = 1; i< n+1 ;i++)
		{
			for(int j = 1; j < sum+1; j++)
			{
				if(arr[i-1] > j)
					t[i][j] = t[i-1][j];
				
				else
				{
					t[i][j] = t[i-1][j] + t[i-1][j - arr[i-1]];		
				}
			}
		}
		
		return t[n][sum];
	}

	public static void main(String[] args) {
		int arr[] = {2, 3, 5, 6, 8, 10};
		int sum = 10;
		
		System.out.println(countSubsets(arr, sum));

	}

}
