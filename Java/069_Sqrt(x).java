牛顿迭代法（Newton's method）又称为牛顿-拉夫逊方法（Newton-Raphson method），
它是牛顿在17世纪提出的一种在实数域和复数域上近似求解方程的方法。多数方程不存在求根公式，
因此求精确根非常困难，甚至不可能，从而寻找方程的近似根就显得特别重要。
方法使用函数f(x)的泰勒级数的前面几项来寻找方程f(x) = 0的根。
牛顿迭代法是求方程根的重要方法之一，其最大优点是在方程f(x) = 0的单根附近具有平方收敛，
而且该法还可以用来求方程的重根、复根。另外该方法广泛用于计算机编程中。
设r是f(x) = 0的根，选取x0作为r初始近似值，过点（x0,f(x0)）做曲线y = f(x)的切线L，
L的方程为y = f(x0)+f'(x0)(x-x0)，求出L与x轴交点的横坐标 x1 = x0-f(x0)/f'(x0)，
称x1为r的一次近似值。
过点（x1,f(x1)）做曲线y = f(x)的切线，并求该切线与x轴交点的横坐标 x2 = x1-f(x1)/f'(x1)，
称x2为r的二次近似值。重复以上过程，得r的近似值序列，其中x(n+1)=x(n)－f(x(n))/f'(x(n))，
称为r的n+1次近似值，上式称为牛顿迭代公式。
根据牛顿迭代的原理，可以得到以下的迭代公式：X(n+1)=[X(n)+p/Xn]/2
一般性的编程方法如下：
double sqr(double n) { 
    double k=1.0; 
    while(abs(k*k-n)>1e-9) { 
        k=(k+n/k)/2; 
    } 
    return k; 
}

// CODE
public class Solution {
    public int mySqrt(int n) {
        long x = n;
	while (x * x > n)
	    x = (x + n/x) / 2;
        return (int)x;
    }
}


//method 2 binary search
public class Solution {
    public int mySqrt(int x) {
        if (0 == x) return 0;
        int left = 1, right = x, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
