package dynamicProgramming;

import java.util.Arrays;

public class Knapsack {
	
	// Using recursion
	// Time Complexity: O(2^n)
	// Space Complexity: O(1)
	static int knapsackRec(int value[], int weight[], int w)
	{
		return knapsackRec(value, weight, w, weight.length);
	}
	
	static int knapsackRec(int value[], int weight[], int w, int n)
	{
		if(w == 0 || n == 0)
			return 0;
		
		if(weight[n-1] > w)
			return knapsackRec(value, weight, w, n-1);
		else
		{
			return Math.max(value[n-1] + knapsackRec(value, weight, w - weight[n-1], n-1) , 
					knapsackRec(value, weight, w, n-1));
		}
	}
	
	// Using memoization and top down approach
	// Time complexity: O(n*w)
	// Space Complexity: O(nw)
	
	static int t[][] = new int [100+1][1000+1];     // The storage    t[n+1][w+1]
	
	
	static int knapsackTD(int value[], int weight[], int w)
	{
		int n = weight.length;
		int t[][] = new int [n+1][w+1];
		//Arrays.fill(t, -1);         will only work for 1d array
		for(int [] arr : t)
			Arrays.fill(arr, -1);
		return knapsackTD(value, weight, w, n, t);
	}
	
	
	static int knapsackTD(int value[], int weight[], int w, int n, int t[][])
	{
		if(w == 0 || n == 0)
			return 0;
		if(t[n][w]!= -1)
			return t[n][w];
		
		if(weight[n-1] > w)
			return t[n][w] = knapsackTD(value, weight, w, n-1, t);
		else
		{
			return t[n][w] = Math.max(value[n-1] + knapsackTD(value, weight, w - weight[n-1], n-1, t) , 
					knapsackTD(value, weight, w, n-1, t));
		}
	}
	
	// DP or Bottom-Up Or Iterative
	// Complexity : same as memoization
	
	static int knapsackDP(int value[], int weight[], int w)
	{
		int n = weight.length;
		int t[][] = new int[n+1][w+1];
		
		
		
		for(int i = 0;i < n+1 ;i++)
		{
			for(int j = 0; j< w+1; j++)
			{
				if(i == 0 || j == 0)             // Initialization
					t[i][j] = 0;
				
				else if(weight[i-1] > j)       //IMP: for weight & value array index always will be [ _ - 1] 
					t[i][j] = t[i-1][j];
				
				else
				{
					t[i][j] = Math.max(t[i-1][j], value[i-1] + t[i-1][j - weight[i-1]]);
				}
			}
		}
		
		return t[n][w];
		
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	// Another variation is when constraints for weight are too high but for values 
	// are low. So we can't prepare dp matrix of dp[x][weight] instead we must make
	// dp[x][value] which will store the min weight to get to achieve at least v
	
	// (W, V) => (200, 500) oR  (300, 500) 
	// definitely (200, 500) is better bcoz we are achieving same value with less
	// weight
	// dp[i][v] = min(dp[i+1][v]
	
	
//	static int vSumMax = 1000;
//	static int nMax = 100;
//	static int wMax = 10000000;
//	
//	static int dp[][] = new int[nMax][vSumMax+1];
//	static boolean v[][] = new boolean[nMax][vSumMax+1];
//	
//	
//	static void maxWeight(int val[], int weight[], int cap)
//	{
//		int n = val.length;
//		// calculate max value of val possible
//		// if we include all weight
//		
////		for(int i=vSumMax; i>= 0;i--)
////		{
////			System.out.println(i);
////			if(solveDp(i, 0, weight, val, n) <= cap)
////			{
////				System.out.println(i);
////				return;
////			}
////		}
//		
//		
//		System.out.println(solveDp(90, 0, weight, val, n));
//	}
//	
//	static int solveDp(int r, int i, int w[], int val[], int n)
//	{
//		System.out.println(i+" "+r);
//		// base case
//		if(r <= 0)
//			return 0;
//		
//		if(i == n)
//			return wMax;
//		
//		if(v[i][r])       // if value already calculated
//			return dp[i][r];
//		
//		// marking state as solved
//		v[i][r] = true;
//		
//		// recurrence relation
//		dp[i][r] = Math.min(solveDp(r, i+1, w, val, n), w[i] + 
//				solveDp(r - val[i], i+1, w, val, n));
//		System.out.println("cal "+dp[i][r]+" "+i+" "+r);
//		return dp[i][r];
//		
//		
//	}
	
	
	
//	 static final int V_SUM_MAX = 1000;
//	    static final int N_MAX = 100;
//	    static final int W_MAX = 10000000;
//	      
//	    // To store the states of DP 
//	    static int dp[][] = new int[V_SUM_MAX + 1][N_MAX]; 
//	    static boolean v[][] = new boolean [V_SUM_MAX + 1][N_MAX]; 
//	      
//	    // Function to solve the recurrence relation 
//	    static int solveDp(int r, int i, int w[],       
//	                          int val[], int n) 
//	    { 
//	    	System.out.println(i+" "+r);
//	        // Base cases 
//	        if (r <= 0) 
//	            return 0; 
//	              
//	        if (i == n) 
//	            return W_MAX; 
//	              
//	        if (v[r][i]) 
//	            return dp[r][i]; 
//	      
//	        // Marking state as solved 
//	        v[r][i] = true; 
//	      
//	        // Recurrence relation 
//	        dp[r][i] = Math.min(solveDp(r, i + 1, w, val, n), 
//	                     w[i] + solveDp(r - val[i], 
//	                                    i + 1, w, val, n)); 
//	        System.out.println("cal "+dp[r][i]+" "+i+" "+r);
//	        return dp[r][i]; 
//	    } 
	
	static int vSumMax = 1000;
	static int nMax = 100;
	static int wMax = 10000000;
	
	static int dp[][] = new int[nMax][vSumMax+1];
	static boolean v[][] = new boolean[nMax][vSumMax+1];
	

	    
		static int solveDp(int r, int i, int w[], int val[], int n)
		{
			System.out.println(i+" "+r);
			// base case
			if(r <= 0)
				return 0;
			
			if(i == n)
				return wMax;
			
			if(v[r][i])       // if value already calculated
				return dp[r][i];
			
			// marking state as solved
			v[r][i] = true;
			
			// recurrence relation
			dp[r][i] = Math.min(solveDp(r, i+1, w, val, n), w[i] + 
					solveDp(r - val[i], i+1, w, val, n));
			System.out.println("cal "+dp[r][i]+" "+i+" "+r);
			return dp[r][i];
			
			
		}
	      
	    // Function to return the maximum weight 
	    static int maxWeight(int w[], int val[], 
	                          int c) 
	    { 
	    	int n = w.length;
	        // Iterating through all possible values 
	        // to find the the largest value that can 
	        // be represented by the given weights 
//	        for (int i = V_SUM_MAX; i >= 0; i--)
//	        { 
//	            if (solveDp(i, 0, w, val, n) <= c) 
//	            { 
//	            	System.out.println(i);
//	                return i; 
//	            } 
//	        } 
	        
	        System.out.println(solveDp(90, 0, w, val, n));
	        return 0; 
	    } 
	    
	    
	    static void solve(int val[], int w[], int cap)
	    {
	    	int n = w.length;
	    	int sum = 0;
	    	for(int i:val)
	    		sum += i;
	    	int dp[][] = new int[n+1][sum+1];
	    	for(int i=0;i<=n;i++)
	    	{
	    		for(int j=0;j<=sum;j++)
	    		{
	    			if(i == 0 || j== 0)
	    				dp[i][j] = Integer.MAX_VALUE;
	    			else
	    			{
	    				int val1 = dp[i-1][j];
	    				int val2 = Integer.MAX_VALUE;
	    				if(j - val[i-1] >= 0)
	    				{
	    					val2 = dp[i-1][j - val[i-1]];
	    				}
	    				
	    				dp[i][j] = Math.min(val1, val2);
	    			}
	    		}
	    	}
	    	for(int i=0;i<=n;i++)
	    	{
	    		for(int j=0;j<=sum;j++)
	    		{
	    			System.out.print(dp[i][j] +"   ");
	    		}
	    		System.out.println();
	    	}
	    }

	public static void main(String[] args) {
//		int value[] = {60,100, 120};
//		int weight[] = {10, 20, 30};
//		int w = 50;
		
//		int value[] = {3, 4, 5, 6};
//		int weight[] = {2, 3, 4, 5};
//		int w = 5;
//		
//		System.out.println(knapsackRec(value, weight, w));
//		System.out.println(knapsackTD(value, weight, w));
//		System.out.println(knapsackDP(value, weight, w));
		
		///////////////////////////////////////////////////////////////
//		int wght[] = {3, 4, 5};
//		int val[] = {30, 50, 60};
//		int cap = 8;
//		//maxWeight(wght, val, cap);
//		//maxWeight(wght, val,  cap);
//		solve(val, wght, cap);
		
		for(int i=0;i<5;i++)
		{
			System.out.println(i);
			
		}
		

	}

}
