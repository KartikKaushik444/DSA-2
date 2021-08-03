package greedy;

// count the total number of digits that changes every time from moving from 0 to x by adding 1 at a time
// x = 2 -> 6
// x = 12 -> 13
public class CountChangedDigits {
	
	static long count(int x)
	{
		long ans = 0;
		long waysToGetHere = 0;
		
		for(char c:(x+"").toCharArray())
		{
			waysToGetHere*=10;
			//System.out.println(waysToGetHere);
			ans+=(c-'0')+waysToGetHere;
			//System.out.println(ans);
			waysToGetHere += (c-'0');
			//System.out.println(waysToGetHere);
		}
		System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
//		count(9);
//		count(97);
//		count(102);
//		count(10000);
		count(224);

	}

}
