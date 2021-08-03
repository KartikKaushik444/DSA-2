package bitManipulation;

import java.util.ArrayList;

public class PowerSet {
	// TC : O( n* 2^n) , will work for n upto 15
	static ArrayList<ArrayList<Integer>> getSubsets(int num[])
	{
		int size = num.length;
		int subsetNum = (1<<size);         // 2^size
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
		for(int subsetMask = 0;subsetMask < subsetNum;subsetMask++)
		{
			ArrayList<Integer> subset = new ArrayList<>();
			// traversing each bit of bitMask
			for(int i=0;i<size;i++)
			{
				if((subsetMask & (1 << i)) != 0)
						subset.add(num[i]);
			}
			allSubsets.add(subset);
		}
		System.out.println(allSubsets);
		return allSubsets;
	}
	
	// Another variation: Given a collection of integers that might contain duplicates, nums,
	// return all possible subsets(must not contain duplicate subsets)
	
	// Another question
	//Given an array of size n(n<=15), find a subsequence such that xor of the subsequence is max
	static void solve(int num[])
	{
		ArrayList<ArrayList<Integer>> subsets = getSubsets(num);
		ArrayList<Integer> ans = new ArrayList<>();
		int mxXor = 0;
		for(ArrayList<Integer> subset:subsets)
		{
			int xr = 0;
			for(int ele:subset)
			{
				xr ^= ele;
			}
			if(xr > mxXor)
			{
				mxXor = xr;
				ans = subset;
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args) {
		int num[] = {1, 2, 3};
		getSubsets(num);

	}

}
