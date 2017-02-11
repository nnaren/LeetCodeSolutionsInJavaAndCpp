class Solution {
public:
    int uniquePaths(int m, int n) {
            int N = n + m - 2;// how much steps we need to do
            int k = m - 1; // number of steps that need to go down
            double res = 1;
            // here we calculate the total possible path number 
            // Combination(N, k) = n! / (k!(n - k)!)
            // reduce the numerator and denominator and get
            // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
            for (int i = 1; i <= k; i++)
                res = res * (N - k + i) / i;
            return (int)res;
        }
};

////////////////////////////////////////////////////////////////
// dp
class Solution {
public:
    int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (m == 1 || n == 1) return 1;
        vector<vector<int>>dp(m, vector<int>(n, 1));
        
        dp[0][0] = 0;
        
        for (int row = 1; row < m; row++)
        	for(int col = 1; col < n; col++)
        		dp[row][col] = dp[row-1][col] + dp[row][col-1];
        return dp[m-1][n-1];
    }
};
