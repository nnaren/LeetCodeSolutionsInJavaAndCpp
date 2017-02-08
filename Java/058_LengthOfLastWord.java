public class Solution {
    public int lengthOfLastWord(String s) {
		int len = 0, lastLen = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') len = 0;
			else lastLen = ++len; 
		}
		return lastLen;
    }
}

// slow
public class Solution {
    public int lengthOfLastWord(String s) {
		int len = s.length();
		if(len == 0) return 0;
		int from = 0, to = len-1;
		while(from < len && s.charAt(from) == ' ' ) from++;
		while(to > from && s.charAt(to) == ' ') to--;
		return length(s, from, to);
    }
	
	private int length(String s, int from, int to) {
		int lastBlank = Integer.MAX_VALUE;	
		for(int i = from, j = 0; i <= to; i++, j++) {
			if(s.charAt(i) == ' ') { 
				lastBlank = j;
			}
		}
		if(lastBlank == Integer.MAX_VALUE) return to-from+1;
		return to-from+1-(lastBlank+1);
	}
}
