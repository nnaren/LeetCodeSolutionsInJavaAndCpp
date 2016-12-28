public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || ((x != 0) && (x%10 == 0))) {
            return false;
        }
        int reverseInt = 0;
        while(x > reverseInt) {
            reverseInt = reverseInt*10+x%10;
            x /= 10;
        }
        
        return (reverseInt == x) || (reverseInt/10 == x);
    }
}
