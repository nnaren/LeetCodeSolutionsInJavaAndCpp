class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int flag = 0;
    	int len = digits.size();
    	for (int i = len-1; i >= 0; i--) {
    		int sum = (i == len-1) ? (digits[i]+1+flag) : (digits[i]+flag);
    		digits[i] = sum % 10;
			flag = sum / 10;
    	}
    	if (flag == 0) return digits;
    	else digits.insert(digits.begin(), 1);
		return digits;
    }
};
