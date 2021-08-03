package dynamicProgramming;

import java.util.ArrayDeque;

public class MinCostPath {
	 // not efficient
//	static int rec(int [][]path, int i, int j, int desti, int destj)
//	{
//		int n = path.length;
//		int m = path[0].length;
//		
//		if(i<0 || i>=n || j<0 || j>=m)
//			return Integer.MAX_VALUE - 100;
//		
//		if(i == desti && j == destj)
//			return path[i][j];
//		
//		return Math.min(rec(path, i+1, j, desti, destj), 
//				Math.min(rec(path, i+1, j+1, desti, destj), rec(path, i, j+1, desti, destj))) + path[i][j];
//	}
//	
//	static int rec(int [][]path, int i, int j)
//	{
//		
//		if(i<0 || j<0)
//			return Integer.MAX_VALUE;
//		
//		if(i == 0 && j == 0)
//			return path[i][j];
//		
//		return path[i][j] + Math.min(rec(path, i-1, j), 
//				Math.min(rec(path, i-1, j-1), rec(path, i, j-1)));
//	}
//	
//	
//	// Use dp
//	 private static int minCost(int cost[][], int m, int n) 
//		    { 
//		        int i, j; 
//		        int tc[][]=new int[m+1][n+1]; 
//		  
//		        tc[0][0] = cost[0][0]; 
//		  
//		        /* Initialize first column of total cost(tc) array */
//		        for (i = 1; i <= m; i++) 
//		            tc[i][0] = tc[i-1][0] + cost[i][0]; 
//		  
//		        /* Initialize first row of tc array */
//		        for (j = 1; j <= n; j++) 
//		            tc[0][j] = tc[0][j-1] + cost[0][j]; 
//		  
//		        /* Construct rest of the tc array */
//		        for (i = 1; i <= m; i++) 
//		            for (j = 1; j <= n; j++) 
//		                tc[i][j] = min(tc[i-1][j-1],  
//		                               tc[i-1][j], 
//		                               tc[i][j-1]) + cost[i][j]; 
//		  
//		        return tc[m][n]; 
//		    } 
//	 
//	 private static int min(int x, int y, int z) 
//	    { 
//	        if (x < y) 
//	            return (x < z)? x : z; 
//	        else
//	            return (y < z)? y : z; 
//	    } 
	 
	 
	 // we can also use dijkstra algorithm for this
	
	private static class Pair{
		String psf;
		int i;
		int j;
		
		public Pair(String psf, int i, int j)
		{
			this.psf = psf;
			this.i = i;
			this.j = j;
		}
	}
// we can move either down or right, find min cost
  static int minCostPath(int a[][])
  {
	  int n = a.length;
	  int m =  a[0].length;
	  int dp[][] = new int[n][m];
	   
	   for(int i= n-1;i>=0;i--)
	   {
		   for(int j = m-1; j>=0 ;j--)
		   {
			   // Initialization
			   if(i == n-1 && j== m-1)     // if last cell
				   dp[i][j] = a[i][j];      
			   else if( i == n-1)     // last row      
				   dp[i][j] = a[i][j] + dp[i][j+1];
			   else if(j == m-1)      // last column
				   dp[i][j] = a[i][j] + dp[i+1][j];
			   // Initialization
			   
			   else
			   {
				   dp[i][j] = a[i][j] + Math.min(dp[i][j+1] , dp[i+1][j]);
			   }
		   }
	   }
	   
	   // to print the path
	   ArrayDeque<Pair> q = new ArrayDeque<>();
	   q.add(new Pair("", 0, 0));
	   while(!q.isEmpty())
	   {
		   Pair rm = q.removeFirst();
		   
		   if(rm.i == n-1 && rm.j == m-1)
		   {
			   System.out.println(rm.psf);
		   }
		   else if(rm.i == n-1)
		   {
			   q.add(new Pair(rm.psf + " H", rm.i, rm.j+1));
		   }
		   else if(rm.j == m-1)
		   {
			   q.add(new Pair(rm.psf + " V", rm.i+1, rm.j));
		   }
		   else
		   {
			   if(dp[rm.i][rm.j + 1] < dp[rm.i + 1][rm.j])
			   {
				   q.add(new Pair(rm.psf + " H", rm.i, rm.j+1));
			   }
			   else if(dp[rm.i][rm.j + 1] > dp[rm.i + 1][rm.j])
			   {
				   q.add(new Pair(rm.psf + " V", rm.i+1, rm.j));
			   }
			   else
			   {
				   q.add(new Pair(rm.psf + " H", rm.i, rm.j+1));
				   q.add(new Pair(rm.psf + " V", rm.i+1, rm.j));
			   }
		   }
	   }
	   return dp[0][0];
	   
  }
	public static void main(String[] args) {
		int path[][] = {
				{1, 2, 3},
				{4, 8, 2},
				{1, 5, 3},
		};
		
		int a[][] = {
				{2, 8, 4, 1, 6, 4, 2},
				{6, 0, 9, 5, 3, 8, 5},
				{1, 4, 3, 4, 0, 6, 5},
				{6, 4, 7, 2, 4, 6, 1},
				{1, 0, 3, 7, 1, 2, 7},
				{1, 5, 3, 2, 3, 0, 9},
				{2, 2, 5, 1, 9, 8, 2}
		};
		
		//System.out.println(rec(path, 2, 2));
		System.out.println(minCostPath(a));
		System.out.println(minCostPath(path));
		

	}

}
