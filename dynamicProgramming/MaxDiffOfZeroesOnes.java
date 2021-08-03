package dynamicProgramming;
// find length of substring which is having maximum difference of zeroes and ones(0s - 1s)
public class MaxDiffOfZeroesOnes {
	// variation of kadanes algorithm
	static void solve(String s)
	{
		int ans = 0;
		int curSum = 0;
		// if all are one than print -1
		for(int i=0;i<s.length();i++)
		{
			int val = 0;
			if(s.charAt(i) == '0')
				val = +1;
			else if(s.charAt(i) == '1')
				val = -1;
//			if(curSum > 0)
//				curSum += val;
//			else
//				curSum = val;
//			if(curSum > ans)
//				ans = curSum;
			curSum += val;
			if(curSum > ans)
				ans = curSum;
			if(curSum < 0)
				curSum = 0;				
		}
		if(ans == 0)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	public static void main(String[] args) {
		solve("11000010001");
		solve("1111");

	}

}
