public class Searching{
	public static void main(String args[]){
		char [] str = "AABAACAADAABAAABAA".toCharArray();
		char [] pattern = "AABA".toCharArray();
		search(str,pattern);
	}
	/**
	* Naive pattern Searching.
	* Complexity  O (k (n-k))  where k = pattern lenght and n length of str
	*/
	public static void search(char str[], char pattern[]){
		int limit = str.length - pattern.length + 1;
		for(int i = 0; i < limit; i++){
			int j = 0;
			for( j = 0; j < pattern.length; j ++){
				if(str[i+j] != pattern[j])
					break;
			}
			if(j == pattern.length){
				System.out.println("Pattern found at: " + i);
			}
		}
	}
	
	public static boolean match(char [] str,int i, char pattern[], int j){
	    if(i < str.length && j == pattern.length)return false;
		if(i == str.length && j == pattern.length){
			return true;
		}
		if(i == str.length && j+1< pattern.length && pattern[j] == '*'){
			return false;
		}
		
		if(pattern[j] == '?' || pattern[j] == str[i]){
			return match(str,i+1,pattern,j+1);
		}
		if(pattern[j] == '*'){
			return match(str,i,pattern,j+1) || match(str,i+1,pattern,j);
		}
		
		return false;
	}
	public static char[] getLongestPalindrome(char str[]){
		int max = 0;
		char longest [] = new char[0];
		for(int i = 0; i < str.length; i++){
			char t[] = getPalindrome(str,i,i);
			if(max < t.length){
				max = t.length;
				longest = t;
			}
			t = getPalindrome(str,i, i+1);
			if(max < t.length){
				max = t.length;
				longest = t;
			}
		}
		
		System.out.println(longest);
		return longest;
	}
	public static char[] getPalindrome(char str[], int i, int j){
		while(i>=0 && j < str.length && str[i] == str[j]){
			i--;
			j++;
		}
		
		char result[] = new char[(j-i)+1];
		int index = 0;
		for(int k=i+1; k < j; k++){
			result[index++] = str[k];
		}
		return result;
	}
	
	public static void printParenthesis(char buffer[],int p,int n, int open, int close){
	
	if( close == n){
		System.out.println(new String(b));
		return;
	}else{
		if(open > close){
			buffer[p] = '}';
			printP(b,p+1,n,open,close+1);
		}	
		if(open < n){
			buffer[p] = '{' ;
			printP(buffer,p+1,n,open+1,close);
		}
	}
}
}
