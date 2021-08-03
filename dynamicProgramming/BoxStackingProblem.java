package dynamicProgramming;

import java.util.Arrays;

// variation of lis problem
// here multiple instance of same box are allowed
public class BoxStackingProblem {
	// 1-generate all 3 possible rotation of all boxes. The size of the rotation array becomes 3 times 
	// the size of original array. For simplicity, consider width always smaller than or equal to depth
	// 2- Sort the above generated boxes in decreasing order of base area
	// 3- after sorting the problem is same as lis problem with some variations
	
	
	static class Box implements Comparable<Box>
	{
		int h;  // height
		int w;  // width
		int d;  // depth or length
		int area;
		public Box(int h, int w, int d)
		{
			this.h = h;
			this.w = w;
			this.d = d;
		}

		@Override
		public int compareTo(Box o) {
			return o.area - this.area;
		}
		
		// comparator to sort the array on the basis of area in descending order
	}
	static void solve(Box arr[])
	{
		int n = arr.length;
		Box rot[] = new Box[n*3];
		for(int i=0;i<n;i++)
		{
			Box box = arr[i];
			// Original box
			rot[3*i] = new Box(box.h, Math.max(box.w, box.d), Math.min(box.w, box.d));
			
			// First rotation
			rot[3*i + 1] = new Box(box.w, Math.max(box.h, box.d), Math.min(box.h, box.d));
			
			// second rotation
			rot[3*i + 2] = new Box(box.d, Math.max(box.w, box.h), Math.min(box.w, box.h));
		}
		
		// calculate base area of each box
		for(int i=0;i<rot.length;i++)
		{
			rot[i].area = rot[i].w * rot[i].d;
		}
		
		Arrays.sort(rot);
		int count = 3*n;
		// create array same as lis array in lis problem
		int msh[] = new int[count];   
		// msh[i]-> Maximum possible stack height with box i on the top
	
		for(int i=0;i<count;i++)
		{
			Box box = rot[i];
			msh[i] = box.h;   // IMP:
			for(int j=0;j<i;j++)
			{
				Box prevBox = rot[j];
				if(box.w < prevBox.w && box.d < prevBox.d &&
						msh[j] + box.h > msh[i])
				{
					msh[i] = msh[j] + box.h;
				}
			}
			
		}
		
		int max = -1;
		for(int i=0;i<count;i++)
		{
			max = Math.max(max, msh[i]);
		}
		
		System.out.println(max);
	}

	public static void main(String[] args) {
		Box[] a = new Box[4];
		a[0] = new Box(4, 6, 7);
		a[1] = new Box(1, 2, 3);
		a[2] = new Box(4, 5, 6);
		a[3] = new Box(10, 12, 32);
		
		solve(a);

	}

}
