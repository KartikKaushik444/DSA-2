package dynamicProgramming;

public class CountNoOfSubsetsOfGivenDiff {
	
	// This same code can be used for target sum problem(how many ways to assign + and - to get a given sum)
	
	static int countSubsets(int arr[], int diff)
	{
		// s1-s2 = diff
		// s1 - (range - s1) = diff                     here range is sum of all elements of array
		// s1 - range + s1 = diff
		// 2s1 = diff+range
		// s1 = (diff + range) / 2
		// Now find out how many subsets of sum s1 are present in array by same code as count subsets 
		// for given sum
		
		int n =arr.length;
		int range = 0;
		for(int i:arr)
			range += i;
		
		// corner case
		// if (diff + range) is not divisible by 2(or is even), than such a division is not possible
		if(((diff + range) & 1) == 1)
			return 0;
		int sum = (diff + range)/2;    
		
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
		int arr[] = {1, 1, 2, 3};
		int diff = 1;
		
		System.out.println(countSubsets(arr, diff));
		
		int a[] = {1, 1, 2};
		System.out.println(countSubsets(a, 1));

	}

}
