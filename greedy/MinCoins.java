package greedy;

import java.util.Arrays;

public class MinCoins {
	
	static void coins(int coins[] ,int value)
	{
		int n = coins.length;
		Arrays.sort(coins);
		int j=n-1;
		while(value > 0 && j>=0)
		{
			if(coins[j] <= value)
			{
				System.out.print(coins[j]+" ");
				value -= coins[j];
			}
			else
			{
				j--;
			}
			
		}
		if(value!=0)
			System.out.println("sNot possible");
	}

	public static void main(String[] args) {
		
		int coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 1000};
		int coins1[] = {1, 5, 6, 9};
		int value2 = 11;
		// will give wrong answer for this because for this we must use dp
		int value = 121;
		int value1 = 70;
		coins(coins1, value2);

	}

}
