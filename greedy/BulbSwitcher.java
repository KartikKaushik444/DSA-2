package greedy;

// There are n bulbs that are initially off. You first turn on the bulbs, then you turn off every second bulb.
// On the third round, you toggle every third bulb (turning on if it's off or turning off if its on).
// For the ith round you toggle every ith bulb. For nth round you toggle the last bulb.

// Return the number of bulbs that are on after n rounds.

public class BulbSwitcher {
	
	// Approach:
	// Only those bulb will remain on which are toggled odd number of times
	// every ith bulb will be toggled factors(i) times. Eg - 5th bulb will be toggled on 1st and 5th
	// round. Similarly 6(1,2,3,6). Prime number have only two factors(even)
	// One observation is that if n is 10 than only two numbers have odd factors which are 4 and 9
	// and the reason is because they are perfect squares,
	// So, only perfect squares have odd number of factors.
	// We just need to find how many numbers are perfect squares ranging between 1 to n excluding 1

	
	static void solve(int n)
	{
		double sqroot = Math.sqrt((double)n);
		
		double perfectSquares = Math.floor(sqroot);
		
		System.out.println(perfectSquares);
	}
	public static void main(String[] args) {
		solve(3);
		solve(10);
		solve(6);

	}

}
