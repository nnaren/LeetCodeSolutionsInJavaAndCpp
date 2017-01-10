class Solution {
public:
    int divide(int dividend, int divisor) {
        if (divisor == 0 || (dividend == INT_MIN && divisor == -1))
            return INT_MAX;
        
        if (divisor == 1) return dividend;
        if (divisor == -1) return -dividend;
        
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long long a = labs(dividend);
        long long b = labs(divisor);
        int res = 0;
        while (a >= b) {
            long long temp = b, multipal = 1;
            while (a >= (temp << 1)) {
                temp <<= 1;
                multipal <<= 1;
            }
            a -= temp;
            res += multipal; 
        }
        return sign == 1 ? res : -res; 
    }
};
