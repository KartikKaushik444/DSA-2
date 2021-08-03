package dynamicProgramming;

public class StockSpan {
	//If only one transactions is allowed
	// idea is to try selling everyday to gain maximum profit on that day
	// and than take max of all the profits
	static int maxProfit(int price[])
	{
		// just maintain a least so far variable to know the best buying price for max profit
		int n = price.length;
		int lsf = Integer.MAX_VALUE;
		int op = 0;   // overall profit
		int pist = 0;  // profit if sold today
		
		for(int i=0;i<n;i++)
		{
			if(price[i] < lsf)
				lsf = price[i];
			pist = price[i] - lsf;
			op = Math.max(pist, op);
		}
		return op;
	}

	public static void main(String[] args) {
		
		int price[] = {2, 30, 15, 10, 8, 25, 80};
		System.out.println(maxProfit(price));

	}

}
