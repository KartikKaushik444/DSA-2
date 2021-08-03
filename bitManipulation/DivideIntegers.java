package bitManipulation;
// Divide two integers without using mod, division and multiplication operator
// One method is successive subtraction
// in subtraction, we try to go from dividend to divisor

// dividend = quotient * divisor + remainder
// here we will try to go from divisor to dividend
public class DivideIntegers {
	
	static void divide(long dividend, long divisor)          // dividend / divisor
	{
		// calculate sign of divisor
		// i.e sign will be negative only if either one of them is negative
		// otherwise it will be positive
		long sign  = ((dividend < 0) ^ (divisor < 0)) ? -1:1;
		
		// remove sign of operands
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		
		// initialize the quotient
		long quotient = 0;
		long temp = 0;
		
		// 1<<31 behaves incorrectly and gives integer min value
		// so using 1L<<31
		for(int i=31;i>=0;i--)
		{
			if(temp + (divisor << i) <= dividend)
			{
				temp += (divisor << i);
				quotient |= 1L << i;         // Here L means long
//				// can also use => quotient += 1L<<i;
//				System.out.println(i);
//				System.out.println(temp);
//				System.out.println(quotient);
			}
		}
		
		// finally managing sign
		quotient = sign * quotient;
		System.out.println(quotient);
		
	}

	public static void main(String[] args) {
		divide(45L, 8L);
		//divide(24, 8);
	}

}
