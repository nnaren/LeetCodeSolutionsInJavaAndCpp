class Solution {
public:
    double myPow(double x, int n) {
        if(n == 0) return 1;
        double res = myPow(x, n/2);
        return n%2 == 0 ? res*res : (n < 0 ? res*res*(1/x) : res*res*x);
    }
};

//method 2
class Solution {
public:
    double myPow(double x, int n) {
        if(n == INT_MIN && x > 1) return 0;
        if(n == 0) return 1;
        if(n < 0) {
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
};

