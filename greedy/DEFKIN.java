package greedy;

import java.util.Arrays;

// Defense of Kingdom SPOJ

//Theodore implements a new strategy game “Defense of a Kingdom”. 
//On each level a player defends the Kingdom that is represented by a rectangular grid of cells.
//The player builds crossbow towers in some cells of the grid. The tower defends all the cells in 
//the same row and the same column. No two towers share a row or a column.
//
//The penalty of the position is the number of cells in the largest undefended rectangle
public class DEFKIN {
	
	
	static void solve(int x[] , int y[], int m, int n)  // here m and n are coordinates of grid
	{
		int towers = x.length;
		
		int nx[] = new int[towers + 2];
		int ny[] = new int[towers + 2];
		
		nx[0] = 0;
		ny[0] = 0;
		
		nx[nx.length - 1] = n;
		ny[ny.length - 1] = m;
		
		for(int i=0;i<towers;i++)
		{
			nx[i+1] = x[i];
			ny[i+1] = y[i];
		}
		
		Arrays.sort(nx);
		Arrays.sort(ny);;
		
		// find max width
		int maxWidth = 0;
		int maxHeight = 0;
		
		
		for(int i=1;i<nx.length;i++)
		{
			//System.out.println(nx[i] + " "+ny[i]);
			maxWidth = Math.max(maxWidth, nx[i] - nx[i-1] - 1);
			maxHeight = Math.max(maxHeight, ny[i] - ny[i-1] - 1);
			//System.out.println(maxWidth + " "+maxHeight);
		}
		
		int maxArea = maxWidth * maxHeight;
		System.out.println(maxArea);
		
		
		
	}

	public static void main(String[] args) {
		
		int n = 15;
		int m = 8;
		int x[] = {3, 11,  8};
		int y[] = {8, 2, 6};
		
		solve(x, y, m, n);

	}

}
