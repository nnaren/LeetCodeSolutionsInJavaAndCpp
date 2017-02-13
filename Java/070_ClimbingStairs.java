// http://www.2cto.com/kf/201509/442774.html
// 利用离散时间信号系统令输入响应的模型来求解斐波那契问题 f(n) = f(n-1) + f(n-2)
public class Solution {
    public int climbStairs(int n) {
    	double sqrtNum = Math.sqrt(5);
    	return (int)(((Math.pow((1 + sqrtNum) / 2, n+1) - Math.pow((1 - sqrtNum) / 2, n+1)) / sqrtNum));
    }
}

// dp
public class Solution {
    public int climbStairs(int n) {
    	if (n <= 0) return 0;
    	if (n == 1) return 1;
    	
    	int[] dp = new int[n+1];
    	dp[0] = 0;
    	dp[1] = 1;
    	dp[2] = 2;
    	
    	for (int i = 3; i <= n; i++) {
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	return dp[n];
    }
}
