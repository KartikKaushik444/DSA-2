package bitManipulation;
// count all set bits in an integer
public class KernighansAlgorithm {
	
	// right most set bit mask of x = x & (2s compliment of x)
	
	// x = A 1's & 0s....1....B 0s
	// 1's compliment OR ~x = A 0s and 1s..0..B 1s
	// 2's compliment OR ~x+1 = A 0s and 1s.1..B 0s
	// rsb OR x&x`` = A 0s.. 1..B 0s
	
	
	static void rsbm(int n)  
	{
		int rsbm = n & -n;
		// 2s compliment is same as negative of a number
		System.out.println(Integer.toBinaryString(rsbm));
	}
	
	// kerninghan's algorithm is used to calculate count of set bits which uses rsbm
	
	static void count(int n)
	{
		int count = 0;
		while(n != 0)
		{
			int rsbm = n & -n;
			n -= rsbm;
			count++;
		}
		System.out.println(count);
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	// check if a number is power of 2
	// Important observation :-
	// if n = 6 => 0110 
	// n-1 = 5  => 0101
	// 5 & 6    => 0100
	// if we unset the right most significant bit of n and flip all the bits after it than we 
	// get n-1
	// if we do (n & (n-1)) than we get same bits before rsb and 0 starting from rsb
	
	// n   = 8 => 1000
	// n-1 = 7 => 0111
	// 8 & 7   => 0000
    // if we do (n & (n-1)) on power of 2 than we always get result as 0 
	
	static boolean isPowerOf2(int n)
	{
		if(n == 0)
			return false;
		if((n&(n-1)) == 0)
			return true;
		else 
			return false;
	}
	
	// using this approach also we can find count of set bits
	
	static void countOnes(int n)
	{
		int count = 0;
		while(n != 0)
		{
			n = n & (n-1);
			count++;
		}
		System.out.println(count);
	}
	public static void main(String[] args) {
		rsbm(72);
		count(567);
		System.out.println(isPowerOf2(8));
		System.out.println(isPowerOf2(6));
		countOnes(567);
		
	}

}
