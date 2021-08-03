package greedy;

// only positive integers are allowed in array

//Given an array of positive integers. We need to make the given array a ‘Palindrome’. 
//The only allowed operation is”merging” (of two adjacent elements). Merging two adjacent elements means 
//replacing them with their sum. The task is to find the minimum number of merge operations required to 
//make the given array a ‘Palindrome’.
//To make any array a palindrome, we can simply apply merge operation n-1 times where n is the size 
//of the array (because a single-element array is always palindromic, similar to single-character string).
//In that case, the size of array will be reduced to 1. But in this problem, we are asked to do it in the 
//minimum number of operations.
public class MinimumMergeOperartions {

	static void solve(int a[])
	{
		int n = a.length;
		int i=0;
		int j = n-1;
		int count = 0;
		while(i<j)
		{
			if(a[i] == a[j])
			{
				i++;
				j--;
			}
			else
			{
				// do merging
				
				if(a[i] > a[j])
				{
					// merge j with adjacent
					a[j-1] = a[j-1] + a[j];
					j--;
					count++;
				}
				else
				{
					a[i+1] = a[i+1] + a[i];
					i++;
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
	public static void main(String[] args) {
		int a[] = {15, 4, 15};
		solve(a);
		
		int a1[] = {1, 4, 5, 1};
		solve(a1);
		
		int a2[] = {11, 14, 15, 99};
		solve(a2);

	}

}
