package bitManipulation;
// 3 different variation are present
public class NonRepeatingElement {
	
	// 1. find element that appears once while all other element appears twice
	// XOR with Bits
	// b^1 = ~b   toggle the bit
	// b^0 = b    doesn't do anything
	
	// XOR with decimal
	// x^x = 0     because all bits are same, hence result is 0
	// x^0 = x     because xor with 0 doesn't do anything
	// x^y^z = x^(y^z)   OR it is associative in nature
	// x^y = y^x         OR it is commutative in nature
	
	static void solve1(int a[])
	{
		int unique = 0;
		for(int val : a)
		{
			unique = unique ^ val;  // all duplicates will cancel out each other
		}
		System.out.println(unique);
	}
	
	// 2. find two unique elements while all other elements occur twice
	static void solve2(int a[])
	{
		int xxory = 0;
		for(int val : a)
		{
			xxory = xxory ^ val;  // all duplicates will cancel out each other
		}
		// now xxory contains xor value of two unique elements
		// also it is the xor value of all elements of array
		// if we look at the rsb of this xor than for sure out of unique elements one element will have
		// that bit on and other will have off( 1 ^ 0 = 0 ^ 1 = 1)
		// also all the elements will have odd number of 1s on that bit
		// now we make two sets, one will contain element that have that bit as on and other set will have off
		// now both the elements can't be in the same set, hence we will use same approach as solve1 afterwards
		
		int rsbm = xxory & -xxory;
		int x = 0;
		int y = 0;
		
		for(int val:a)
		{
			if((val & rsbm) == 0)
			{
				x = x^val;
			}
			else
			{
				y = y^val;
			}
		}
		
		System.out.println(x+" "+ y);
	}
	
	// 3. find one repeating and one missing element from an array containing n elements from 1 to n
	// idea is to create duplicates and take xor of all of them 
	// than we will come in the same position as solve2
	
	static void solve3(int a[])
	{
		int xor = 0;
		int n = a.length;
		for(int i=0;i<n;i++)
		{
			xor ^= a[i];
		}
		// now creating duplicates
		for(int i=1;i<=n;i++)
		{
			xor ^= i;
		}
	
		int rsbm = xor & -xor;
		
		int x = 0;
		int y = 0;
		
		for(int val:a)
		{
			if((val & rsbm) == 0)
			{
				x = x^val;
			}
			else
			{
				y = y^val;
			}
		}
		// doing the same for duplicate numbers
		for(int i=1;i<=n;i++)
		{
			int val = i;
			if((val & rsbm) == 0)
			{
				x = x^val;
			}
			else
			{
				y = y^val;
			}
		}
	
		// to check which one is duplicate
		for(int val:a)
		{
			if(val == x)
			{
				System.out.println("Missing number = "+ y );
				System.out.println("Duplicate number = "+ x );
				break;
			}
			else if(val == y)
			{
				System.out.println("Missing number = "+ x );
				System.out.println("Duplicate number = "+ y );
				break;
			}
		}
		
	}
	
	// 4. write a program to find a unique number in an array where all numbers except one, are present
	// thrice
	
	static boolean getBit(int n, int pos)
	{
		return (n & (1<<pos)) != 0;
	}
	
	static int setBit(int n, int pos)
	{
		return (n | (1<<pos));
	}
	
	static void unique(int a[])
	{
		int n = a.length;
		int result = 0;
		for(int i=0;i<64;i++)
		{
			int sum = 0;
			for(int j=0;j<n;j++)
			{
				if(getBit(a[j], i))    // if ith position bit is set in a[j]
				{
					sum++;
				}
			}
			if((sum%3)!=0)
			{
				result = setBit(result, i);
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		int a1[] = {1, 2, 3, 4, 4, 3, 2, 1, 5, 6, 5};
		solve1(a1);
		
		int a2[] = {1, 2, 3, 4, 3, 2, 1, 5, 6, 5};
		solve2(a2);
		
		int a3[] = {3, 6, 2, 5, 1, 2, 7};
		solve3(a3);
		
		int a4[] = {1, 2, 3, 4, 1, 2, 3, 1, 2, 3};
		unique(a4);
	
		
	}

}
