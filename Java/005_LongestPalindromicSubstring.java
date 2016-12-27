package leetCode;

public class reverseSubString {

	private int lo;
	private int maxLen;
	public String longestPalindrome(String s) {
		int len = s.length();
		if(len < 2) {
			return s;
		}
		
		for(int i = 0; i < len-1; i++) {
			extendLongestPalindrome(s, i, i);
			extendLongestPalindrome(s, i, i+1);
		}
		
		return s.substring(lo, lo + maxLen);
	}
	
	private void extendLongestPalindrome(String s, int left, int right) {
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		
		if(maxLen < right - left - 1) {
			maxLen = right -left - 1;
			lo = left + 1;
		}
	}
	

//		private int lo, maxLen;
//
//		public String longestPalindrome(String s) {
//			int len = s.length();
//			if (len < 2)
//				return s;
//			
//		    for (int i = 0; i < len-1; i++) {
//		     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
//		     	extendPalindrome(s, i, i+1); //assume even length.
//		    }
//		    return s.substring(lo, lo + maxLen);
//		}
//
//		private void extendPalindrome(String s, int j, int k) {
//			while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
//				j--;
//				k++;
//			}
//			if (maxLen < k - j - 1) {
//				lo = j + 1;
//				maxLen = k - j - 1;
//			}
//		}
	
	public static void main(String[] args) {
		reverseSubString r = new reverseSubString();
		String s = "abcbaddeerfabcdeedcba";
		System.out.println(r.longestPalindrome(s));
	}
}
