class Solution {
public:
    int lengthOfLastWord(string s) {
        int len = 0, lastLen = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s[i] == ' ') len = 0;
			else lastLen = ++len; 
		}
		return lastLen;
	}
};

// slow
class Solution {
public:
    int lengthOfLastWord(string s) {
        int len = s.length();
        if(len == 0) return 0;
        int from = 0, to = len-1;
		while(from < len && s[from] == ' ' ) from++;
		while(to > from && s[to] == ' ') to--;
		return length(s, from, to);
    }
    
    int length(string& s, int from, int to) {
		int lastBlank = INT_MAX;	
		for(int i = from, j = 0; i <= to; i++, j++) {
			if(s[i] == ' ') { 
				lastBlank = j;
			}
		}
		if(lastBlank == INT_MAX) return to-from+1;
		return to-from+1-(lastBlank+1);
	}
};

	
	
