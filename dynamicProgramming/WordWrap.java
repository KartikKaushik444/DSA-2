package dynamicProgramming;
import java.util.*;


public class WordWrap {
// m total spaces in a line and length of words is provided in l array
// cost of storing is calculated by (idle space)^2
	static void solve(int l[], int m)
	{
		int n = l.length;
		// extras[i][j] will have number of extra spaces if words from i to j are put in 
		// a single line
		int extras[][] = new int[n+1][n+1];
		
		// lc[i][j] will have cost of a line which has words from i to j
		int lc[][] = new int[n+1][n+1];
		
		// c[i] will have total cost of optimal arrangement of words from 1 to i
		int c[] = new int[n+1];
		
		// p[] is used to print the solution
		int p[] = new int[n+1];
		
		// calculate extra spaces in a single line. The value extra[i][j] indicates
		// extra spaces if words from word number i to j are placed in a single line
		for(int i=1;i<=n;i++)
		{
			extras[i][i] = m - l[i-1];   // only one word
			for(int j=i+1;j<=n;j++)
			{
				extras[i][j] = extras[i][j-1] - l[j-1] - 1;
				// this value can become negative which we will handle later 
			}
		}
		
		// calculate line cost corresponding to the above calculated extra spaces.
		// The value lc[i][j] indicates cost of putting words from word number i to j
		// in a single line
		
		for(int i=1;i<=n;i++)
		{
			for(int j=i;j<=n;j++)
			{
				if(extras[i][j] < 0)
					lc[i][j] = Integer.MAX_VALUE;
				
				else if(j == n && extras[i][j] >= 0) // no cost if it is last line
				{
					lc[i][j] = 0;
				}
				else
					lc[i][j] = extras[i][j] * extras[i][j];
			}
		}
		
		// calculate min cost and find cost arrangement 
		// c[j] contains optimized cost from word number 1 to j
		c[0] = 0;
		for(int j=1;j<=n;j++)
		{
			c[j] = Integer.MAX_VALUE;
			// now try every possible value of i for which i to j can be placed in next line for minimum cost
			for(int i=1;i<=j;i++)
			{
				if(c[i-1] != Integer.MAX_VALUE && lc[i][j] != Integer.MAX_VALUE &&
						(c[i-1] + lc[i][j] < c[j]))
				{
					c[j] = c[i-1] + lc[i][j];
					p[j] = i;
				}
			}
		}
		printSolution(p, n);
	
	}
	
	static int printSolution(int p[], int n)
	{
		int k;
		if(p[n] == 1)
			k = 1;
		else
			k = printSolution(p, p[n]-1) + 1;
		System.out.println("Line Number "+k+": From word number "+p[n]+" to "+n);
		return k;
	}
	public static void main(String[] args) {
		
		int l[] = {3, 2, 2, 5};
		
		int m = 6;
		solve(l, m);
	
	}

}
