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
