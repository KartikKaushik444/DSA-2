package greedy;

import java.util.Arrays;

// maximize array sum after k negations

//Given an array of size n and a number k. We must modify array K number of times.
//Here modify array means in each operation we can replace any array element arr[i] by -arr[i].
//We need to perform this operation in such a way that after K operations, sum of array must be maximum?
//
//Examples : 
//
//Input : arr[] = {-2, 0, 5, -1, 2} 
//        K = 4
//Output: 10
//Explanation:
//1. Replace (-2) by -(-2), array becomes {2, 0, 5, -1, 2}
//2. Replace (-1) by -(-1), array becomes {2, 0, 5, 1, 2}
//3. Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}
//4. Replace (0) by -(0), array becomes {2, 0, 5, 1, 2}
//
//Input : arr[] = {9, 8, 8, 5} 
//        K = 3
//Output: 20

//Time Complexity: O(n*logn) 
//Auxiliary Space: O(1)
//
//Approach (Using Sort):
//The above approach 2 is optimal when there is a need to negate at most k elements.
//To solve when there are exactly k negations the algorithm is given below.

//Sort the array in ascending order. Initialize i = 0.
//Increment i and multiply all negative elements by -1 till k becomes or a positive element is reached.
//Check if the end of the array has occurred. If true then go to (n-1)th element.
//If k ==0 or k is even, return the sum of all elements. Else multiply the absolute of minimum of ith or
//(i-1) th element by -1.
//Return sum of the array.
public class MaximizeArraySum {
	
	
	// Function to calculate sum of the array
	static int sumArray( int[] arr, int n)
	{
	    int sum = 0;
	    
	    // Iterate from 0 to n - 1
	    for(int i = 0; i < n; i++)
	    {
	        sum += arr[i];
	    }
	    return sum;
	}
	
	
	static int maximizeSum(int arr[], int n, int k)
	{
	    Arrays.sort(arr);
	    int i = 0;
	    
	    // Iterate from 0 to n - 1
	    for(i = 0; i < n; i++)
	    {
	        if (k != 0 && arr[i] < 0)
	        {
	            arr[i] *= -1;
	            k--;
	            continue;
	        }
	        break;
	    }
	    if (i == n)
	        i--;
	  
	    // if remaining operations left are even than the answer will be same as sum of array
	    // because we will choose the minimum element and reverse it even times than it will remain same
	    if (k == 0 || k % 2 == 0)
	    {
	        return sumArray(arr, n);
	    }
	  
	    // now simply change sign of minimum element and do sum array
	    if (i != 0 && Math.abs(arr[i]) >=
	        Math.abs(arr[i - 1]))
	    {
	        i--;
	    }
	  
	    arr[i] *= -1;
	    return sumArray(arr, n);
	}

	public static void main(String[] args) {
		
		int n = 5;
	    int k = 4;
	    int arr[] = { -3, -2, -1, 5, 6 };
	    
	    // Function Call
	    System.out.print(maximizeSum(arr, n, k));
	}

}
