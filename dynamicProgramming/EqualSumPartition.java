package dynamicProgramming;

public class EqualSumPartition {
	
	static boolean equalSumPartition(int arr[])
	{
		int n = arr.length;
		int sum = 0;
		for(int i:arr)
		{
			sum+=i;
		}
		if(sum%2 != 0)
			return false;
		
		sum = sum/2;
		// Rest code is same as subset sum
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
		
		for(int i = 1; i<n+1; i++)
		{
			for( int j =0; j< sum+1; j++)
			{
				if(arr[i-1] > j)
					t[i][j] = t[i-1][j];
				else
				{
					t[i][j] = t[i-1][j] || t[i-1][j - arr[i-1]];
				}
			}
		}
		
		
		return t[n][sum];
		
	}

	public static void main(String[] args) {
		int arr[] = {1, 5, 13, 5};
		//int arr[] = {1, 5, 11, 5};
		
		System.out.println(equalSumPartition(arr));
		
	}

}
