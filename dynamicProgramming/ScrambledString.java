package dynamicProgramming;

public class ScrambledString {
	
	// we can further optimize by checking anagrams also
	// if not anagrams than definitely not scrambled
	
	static boolean scrambledString(String a, String b)
	{
		if(a.length() != b.length())
			return false;
		
		if(a.compareTo(b) == 0)
			return true;
		
		
		if(a.length() <= 1)
			return false;
		
		// Checking for conditions of anagrams
		// We can sort the string and compare them
//	    char a1[] = a.toCharArray();
//	    char b1[] = b.toCharArray();
//	    Arrays.parallelSort(a1);
//	    Arrays.parallelSort(b1);
//	    
//	    if(!Arrays.equals(a1, b1))
//	    	return false;
	    
		int n = a.length();
		
		boolean isScrambled = false;
		
		for(int i = 1; i<= n-1; i++)
		{
			
			// if swapped
			// s1 -> ABCDEF    s2-> BCDAEF
			// if make a cut after B than
			// func(AB,EF) && func(CDEF, BCDA)
			
			boolean cond1 = scrambledString(a.substring(0, i), b.substring(n - i)) &&
					scrambledString(a.substring(i), b.substring(0, n-i));
			
			// if not swapped
			// s1 -> ABCDEF    s2-> BCDAEF
			// if make a cut after B than
			// func(AB,BC) && func(CDEF, DAEF)
			
			boolean cond2 = scrambledString(a.substring(0, i), b.substring(0, i)) &&
					scrambledString(a.substring(i), b.substring(i));
			

			if(cond1 || cond2)
				isScrambled = true;
				
		}
		
		return isScrambled;
	}

	public static void main(String[] args) {
//		String a = "ocred";
//		String b = "coder";
		
		String a = "phqtrnilf";
		String b = "ilthnqrpf";
		
		System.out.println(scrambledString(a,b));
		


	}

}
