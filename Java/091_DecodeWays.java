class Solution {
public:
    int numDecodings(string s) {
    	int len = s.size();
    	if (len == 0 || s[0] == '0')
    		return 0;
    	if (len == 1) return 1;
    	int left = 1, right = 1, num = 0;
    	for (int i = 1; i < len; i++) {
    		num = 0;
    		if (!isValid(s[i]) && !isValid(s[i-1], s[i]))
    			return 0;
    		if (isValid(s[i])) 
    			num = right;
    		if (isValid(s[i-1], s[i]))
    			num += left;
    		left = right;
    		right = num;
    	}
    	return num;
    }
    
    bool isValid(char a, char b) {
    	return a == '1' || (a == '2' && b <= '6');
    }
    
    bool isValid(char a) {
    	return a != '0';
    }
};

// method 2
public class Solution {
    public int numDecodings(String s) {
    	int len = s.length();
    	if (len == 0 || s.charAt(0) == '0')
    		return 0;
    	if (len == 1) return 1;
    	int left = 1, right = 1, num = 0;
    	for (int i = 1; i < len; i++) {
    		num = 0;
    		if (!isValid(s.charAt(i)) && !isValid(s.charAt(i-1), s.charAt(i)))
    			return 0;
    		if (isValid(s.charAt(i))) 
    			num = right;
    		if (isValid(s.charAt(i-1), s.charAt(i)))
    			num += left;
    		left = right;
    		right = num;
    	}
    	return num;
    }
    
    boolean isValid(char a, char b) {
    	return a == '1' || (a == '2' && b <= '6');
    }
    
    boolean isValid(char a) {
    	return a != '0';
    }
}


// method 2
public class Solution {
    public int numDecodings(String s) {
    	int len = s.length();
    	if(len == 0 || s.charAt(0) == '0')
    		return 0;
    	int[] dp = new int[len+1];
    	Arrays.fill(dp, 1);
    	for (int i = 2; i <= len; ++i) {
    		if (s.charAt(i-1) == '0') dp[i] = 0;
    		else dp[i] = dp[i-1];
    		if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')
    			dp[i] += dp[i-2];
    	}
    	return dp[len];
    }
}
