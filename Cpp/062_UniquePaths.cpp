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
