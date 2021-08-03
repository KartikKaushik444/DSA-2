package bitManipulation;
// given two numbers a and b, and left boundary and right boundary turn the bits ON of b to which a corresponds
// 1 in a given range
// also known as copy set bits in a range
public class ToggleBitsInRange {
	
	static void solve(int a, int b, int left, int right)
	{
		int mask = (1 << right - left + 1);
		mask--;
		mask = (mask << (left - 1));
		
		mask = mask & a;
		// copy the bits
		b = b | mask;
		// if we want to toggle the bits than we can use XOR instead of OR
		System.out.println(b);
	}

	public static void main(String[] args) {
		
		solve(13, 10, 2, 3);
		solve(7, 8, 1, 2);
	}

}
