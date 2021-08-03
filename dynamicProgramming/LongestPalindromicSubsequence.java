package dynamicProgramming;

// a variation could be minimum insertion or deletion to convert String a to String b
public class LongestPalindromicSubsequence {
	
	static int LPS(String x)
	{
		// Reverse the string
		StringBuilder y =new StringBuilder();
		y.append(x);
		y = y.reverse();
		
		// Now find lcs
		int m = x.length();
		int n = y.length();
		
		int t[][] = new int [m+1][n+1];
		
		for(int i = 0; i< m+1;i++)
		{
			for(int j = 0; j< n+1; j++)
			{
				// Initialization
				if(i == 0 || j == 0)
					t[i][j] = 0;
				
				else if(x.charAt(i - 1) == y.charAt(j - 1))
					t[i][j] = 1 + t[i-1][j-1];
				
				else
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
				
				
			}
		}
		 
		return t[m][n];
		
		// For minimum no of deletion to make it a palindrome
		// JUST APPEND THIS CODE:
		
		//  For minimum no of insertion to make it a palindrome also because deletion = insertion
		
//		return m - t[m][n];
	}

	
static int countPalindromicSubsequence(String s) {
        
	  int n = s.length();
      
      int left[][] = new int[n][26];
      
      for(int i=0;i<n;i++)
      {
          if(i != 0)
          for(int j=0;j<26;j++)
          {
              left[i][j] = left[i-1][j];
          }
          //System.out.println(left[i][s.charAt(i)-'a']++);
          left[i][s.charAt(i)-'a']++;
      }
       int right[][] = new int[n][26];
      for(int i=n-1;i>=0;i--)
      {
          if(i!=n-1)
          for(int j=0;j<26;j++)
          {
              right[i][j] = right[i+1][j];
          }
          right[i][s.charAt(i)-'a']++;
      }
      int ans = 0;
      boolean done[][] = new boolean[26][26];
      for(int i=1;i<n-1;i++)
      {
          for(int j=0;j<26;j++)
          {
              if(left[i-1][j] != 0 && right[i+1][j] != 0 &&  !done[j][s.charAt(i) - 'a'])
              {
                  done[j][s.charAt(i) - 'a'] = true;
                  ans++; 
              }  
          }
          //System.out.println(ans);
      }
      return ans;
    }
	public static void main(String[] args) {
//		String x = "AGBCBA";
//		
//		String y = "GEEKSFORGEEKS";
//		
//		System.out.println(LPS(x));
//		
//		System.out.println(LPS(y));
//		
//		System.out.println(LPS("abb"));
//		
//		System.out.println(LPS("abacdfgdcaba"));
//		System.out.println(LPS("aabca"));
		
		System.out.println(countPalindromicSubsequence("bbcbaba"));
	}

}
