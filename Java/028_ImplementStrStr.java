//brute-force algorithm
class Solution {
public: 
    int strStr(string haystack, string needle) {
        int m = haystack.length(), n = needle.length();
        if (!n) return 0;
        for (int i = 0; i < m - n + 1; i++) {
            int j = 0;
            for (; j < n; j++)
                if (haystack[i + j] != needle[j])
                    break;
            if (j == n) return i;
        }
        return -1;
    }
};

//RabinKarp
public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (haystack.equals("") && !needle.equals("")) return -1;
        return rabinKarp(haystack, needle, 10, 2);
    }
	
	public int rabinKarp(String text, String pattern, int d, int q) {
		int n = text.length();
		int m = pattern.length();
		if(n < m) return -1; 
		int h = 1;
		int p = 0;
		int t = 0;
		int i;
		
		for (i = 0; i < m-1; i++) {
			h = (h * d) % q;
		}
		
		for (i = 0; i < m; i++) {
			t = (t * d + (text.charAt(i) - 'a')) % q;
			p = (p * d + (pattern.charAt(i) - 'a')) % q;
		}
		
		for(i = 0; i < n-m+1; i++) {
			String temp = text.substring(i, i+m);
			if(p == t && pattern.equals(temp)) {
				break;
			}
			if(i == n-m) return -1;
			t = (d * (t - (text.charAt(i) - 'a') * h) + (text.charAt(i+m) - 'a')) % q;
		}
		return i;
	}
}
