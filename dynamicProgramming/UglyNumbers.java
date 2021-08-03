package dynamicProgramming;

import java.util.HashSet;
import java.util.PriorityQueue;

// ugly numbers are those whose only prime factors are 2, 3, or 5. The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10,
// 12, 15...shows the first 11 ugly numbers 
// given a number n task is to find the nth ugly number
public class UglyNumbers {
	
	// one method is to observe that all ugly numbers can be represented in the form of
	// 2^a. 3^b. 5^c
	// every next ugly number is min of 2*u, 3*u, 5*u and previous stored nominees
	// TC:for every ugly number we will have 3 more nominees and logn time to find min
	//   : O(3nlogn) = O(nlogn) 
	// SC :O(n) for storing nominees
	
	
	static void ugly(int n)
	{
		int count = 1;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		HashSet<Integer> set = new HashSet<>();
		pq.add(2);
		pq.add(3);
		pq.add(5);
		int ugly = 1;
		while(count < n)
		{
			ugly = pq.poll();
			count++;
			int t = 2*ugly;
			if(!set.contains(t))
			{
				pq.add(t);
				set.add(t);
			}
			
			t = 3* ugly;
			if(!set.contains(t))
			{
				pq.add(t);
				set.add(t);
			}
			t = 5*ugly;
			if(!set.contains(t))
			{
				pq.add(t);
				set.add(t);
			}
			
			
			
		}
		System.out.println(ugly);
		
		
	}
	
	// optimization can be done by using 3 pointer which will point at the 3 best possible
	// nominees, hence the minimum can be calculated in O(1) time
	
	// TC : O(n)
	// SC: O(n)
	static void solve(int n)
	{
		int ugly[] = new int[n];
		int i2 = 0, i3 = 0, i5 = 0;
		
		int nm2 = 2;   // next multiple of 2
		int nm3 = 3;
		int nm5 = 5;
		
		int nun = 1;   // next ugly number 
		ugly[0] = 1;
		
		for(int i=1;i<n;i++)
		{
			nun = Math.min(nm2, Math.min(nm3, nm5));     
			ugly[i] = nun;
			
			if(nun == nm2)
			{
				i2 = i2 + 1;
				nm2 = ugly[i2] * 2;
			}
			if(nun == nm3)
			{
				i3 = i3 + 1;
				nm3 = ugly[i3] * 3;
			}
			if(nun == nm5)
			{
				i5 = i5 + 1;
				nm5 = ugly[i5] * 5;
			}
		}
		
		System.out.println(ugly[n-1]);
	}

	public static void main(String[] args) {
		ugly(7);
		ugly(10);
		ugly(15);
		ugly(150);
		solve(7);
		solve(10);
		solve(15);
		solve(150);
		

	}

}
