package bitManipulation;
// count total set bits in n natural numbers
public class SetBitsInN {
	// idea is to first take the nearest 2^x which is less than n
	// eg - for 11, we take 2^3 = 8 and than count bits 
	// for first 8 elements we will have 2^(3-1) * 3 bits
	// for counting msb of 8-11 elements we add n - 2^x + 1 bits
	// than we solve recursively for the remaining elements
	static int solve(int n)
	{
		int x = largestPowerOf2InRange(n);
		
		int bitstill2x = x * (1 << (x-1));  // x * 2^(x-1)
		int msb2xton = n - (1 << (x-1)) + 1;
		int rest = n - (1 << x);
		int ans = bitstill2x + msb2xton + solve(rest);
		return ans;
		
	}
	
	static int largestPowerOf2InRange(int n)
	{
		int x = 0;
		
		while((1 << x) <= n)
		{
			x++;
		}
		
		return x-1;
	}

	public static void main(String[] args) {
		

	}

}
