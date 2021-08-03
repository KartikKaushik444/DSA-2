package dynamicProgramming;

import java.util.ArrayList;
import java.util.Vector;

public class MinimumSubsetSumDiff {
	
	static int minDiff(int arr[])
	{
		int n = arr.length;
		int sum = 0;
		for(int i:arr)
			sum+=i;
		
		boolean t[][] =new boolean[n+1][sum+1];
		
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
				if(arr[i-1] > j)
					t[i][j] = t[i-1][j];
				else
				{
					t[i][j] = t[i-1][j] || t[i-1][j - arr[i-1]];
				}
			}
		}
		ArrayList<Integer> v = new ArrayList<Integer>();
		
		for(int j = 0;j<= (sum+1)/2; j++)
		{
			if(t[n][j] == true)
				v.add(j);
		}
		
		
		
		int mn = Integer.MAX_VALUE;
		
		for(int i = 0; i<v.size();i++)
		{
//			mn = Math.min(mn, sum-2*v.get(i));
			mn = Math.min(mn, Math.abs(v.get(i) - (sum-v.get(i)) ) );
		}
		
		return mn;
	}
	
	

	public static void main(String[] args) {
		int arr[] = { 6, 12, 7};
		
		System.out.println(minDiff(arr));
		
	

	}

}
