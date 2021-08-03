package greedy;

import java.util.ArrayList;


//Gergovia consists of one street, and every inhabitant of the city is a wine salesman.
//Everyone buys wine from other inhabitants of the city. Every day each inhabitant decides how much wine he
//wants to buy or sell. Interestingly, demand and supply is always the same, so that each inhabitant gets what
//he wants.
//
//There is one problem, however: Transporting wine from one house to another results in work. Since all wines
//are equally good, the inhabitants of Gergovia don't care which persons they are doing trade with, they are
//only interested in selling or buying a specific amount of wine.
//
//In this problem you are asked to reconstruct the trading during one day in Gergovia. For simplicity we will
//assume that the houses are built along a straight line with equal distance between adjacent houses.
//Transporting one bottle of wine from one house to an adjacent house results in one unit of work.

//If ai >= 0, it means that the inhabitant living in the ith house wants to buy ai bottles of wine. 
//If ai < 0, he wants to sell -ai bottles of wine.


public class Gergovia {

	static class Pair
	{
		int x;
		int i;
		Pair(int a, int b)
		{
			x = a;
			i = b;
		}
	}
	
	static void solve(int a[])
	{
		int n = a.length;
		// make two seperate arrays for buy and sell
		ArrayList<Pair> buy = new ArrayList<>();
		ArrayList<Pair> sell = new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			if(a[i] < 0)
			{
				sell.add(new Pair(a[i], i));
			}
			else
			{
				buy.add(new Pair(a[i], i));
			}
		}
		int ans = 0;
		int i = 0;
		int j = 0;
		while(i < buy.size() && j < sell.size())
		{
			int b = buy.get(i).x;
			int s =  sell.get(j).x;
			// find minimum value which can be traded
			int min = Math.min(b, -s);
			
			// now make changes
			buy.set(i, new Pair(b-min, buy.get(i).i));
			sell.set(j, new Pair(s+min, sell.get(j).i));
			
			int diff = Math.abs(buy.get(i).i - sell.get(j).i);
			ans += (min * diff);
			
			if(buy.get(i).x == 0)
				i++;
			if(sell.get(j).x == 0)
				j++;
			
		}
		System.out.println(ans);
		
	}
	public static void main(String[] args) {
		int a[] = {5, -4, 1, -3, 1};
		solve(a);
		
		int a1[] = {-1000, -1000, -1000, 1000, 1000, 1000};
		solve(a1);

	}

}
