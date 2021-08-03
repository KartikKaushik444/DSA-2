package bitManipulation;

// count the number of bits to flip to convert from a to b

public class FlipBits {
	
// the idea is to take xor of a and b because it gives one for different bits and 0 for same bits
	// and than count the number of set bits
	
	static void solve(int a,int b)
	{
		int xor = a^b;
		// using kerninghan's algorithm to count set bits
		
		int count = 0;
		while(xor != 0)
		{
			int rsbm = xor & -xor;
			xor -= rsbm;
			count++;
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args) {
		solve(7, 8);

	}

}
