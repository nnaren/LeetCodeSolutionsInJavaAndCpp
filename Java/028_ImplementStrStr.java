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

////KMP Algorithm
// package leetCode;

// public class KMPSearch {
	
// 	public void kmpSearch(String txt, String pat) {
// 		int M = pat.length();
// 		int N = txt.length();
// 		int j = 0;
// 		int[] lps = new int[M];
// 		computeLPSArray(pat, M, lps);
// 		int i = 0;
// 		while (i < N) {
// 			if (pat.charAt(j) == txt.charAt(i)) {
// 				i++;
// 				j++;
// 			}
// 			if(j == M) {
// 				System.out.println("index:" + (i-j));
// 				j = lps[j-1];
// 			} else if (i < N && pat.charAt(j) != txt.charAt(i)) {
// 				if (j != 0)
// 					j = lps[j-1];
// 				else 
// 					i = i+1;
// 			}
// 		}
// 	}
	
// 	void computeLPSArray(String pat, int M, int[] lps) {
// 		// length of the previous longest prefix suffix
// 		int len = 0;
// 		int i = 1;
// 		lps[0] = 0;  // lps[0] is always 0
		
// 		// the loop calculates lps[i] for i = 1 to M-1
// 		while (i < M) {
// 			if (pat.charAt(i) == pat.charAt(len)) {
// 				len++;
// 				lps[i] = len;
// 				i++;
// 			} else { // (pat[i] != pat[len])
// 				// This is tricky. Consider the example.
//                 // AAACAAAA and i = 7. The idea is similar 
//                 // to search step.
// 				if (len != 0) {
// 					len = lps[len-1];
// 				} else {
// 					lps[i] = len;
// 					i++;
// 				}
// 			}
// 		}
// 	}
	
// 	public static void main(String[] args) {
// 		// TODO Auto-generated method stub

// 	}

// }
