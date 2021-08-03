package dynamicProgramming;
// convert string a to string b if only three opertions are allowed
// Insert
// Remove
// Replace
public class EditDistance {
	
	static int solve(String a,String b, int m, int n)
	{
		if(m == 0)
			return n;              // we have to insert all characters
		
		if(n == 0)                  // we have to remove all characters
			return m;
		
		if(a.charAt(m-1) == b.charAt(n-1))
			return solve(a, b, m-1, n-1);
		
		else {
			// than we have three option
			// delete
			int delete = 1 + solve(a, b, m-1, n);
			// insert
			int insert = 1 + solve(a, b, m, n-1);
			// replace
			int replace = 1 + solve(a, b, m-1, n-1);
			
			return Math.min(delete, Math.min(insert, replace));
		}
	}
	
	
	// dp solution
	
	static int edit(String a, String b)
	{
		int t[][] = new int[a.length() + 1][b.length() + 1];
		
		//Initialization
		for(int i=0;i<=a.length();i++)
		{
			t[i][0] = i;    // only operation possible is to delete all characters of a to make it empty
		}
		
		for(int i=0;i<=b.length();i++)
		{
			t[0][i] = i;   // only operation possible is to insert all characters of b to a
		}
		
		for(int m=1;m<=a.length();m++)
		{
			for(int n=1; n<=b.length();n++)
			{
				if(a.charAt(m-1) == b.charAt(n-1))
					t[m][n] = t[m-1][n-1];
				else
				{
					int delete = 1 + t[m-1][n];
		
					int insert = 1 + t[m][n-1];
					
					int replace = 1+ t[m-1][n-1];
					
					t[m][n] = Math.min(delete, Math.min(insert, replace));
				}
			}
		}
		
//		for(int i=0;i<t.length;i++)
//		{
//			System.out.println();
//			for(int j=0;j<t[0].length;j++)
//				System.out.print(t[i][j] + " ");
//		}
		
			
		return t[a.length()][b.length()];
	}
	
	
	
	public static void main(String[] args) {
		String a = "abc";
		String b = "bcd";
		System.out.println(solve(a, b, a.length(), b.length()));
		
		System.out.println(solve("geek", "gesek", 4, 5));
		
		System.out.println(solve("cat", "cut", 3, 3));
		
		System.out.println(solve("sunday", "saturday", 6, 8));
		
System.out.println(edit("geek", "gesek"));
		
		System.out.println(edit("cat", "cut"));
		
		System.out.println(edit("sunday", "saturday"));
		

	}

}
