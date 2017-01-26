class Solution {
public:
    string multiply(string num1, string num2) {
		int lenA = num1.length();
		int lenB = num2.length();

		vector<int> num3(lenA+lenB);

		for (int i = lenA - 1; i >= 0; i--) {
			for (int j = lenB - 1; j >= 0; j--) {
				int p1 = i + j, p2 = i + j + 1;
				int mul = (num1[i]-'0') * (num2[j]-'0');
				int sum = mul + num3[p2];

				num3[p1] += sum / 10;
				num3[p2] = sum % 10;
			}
		}

		string res;
		for(int i = 0; i < num3.size(); i++) {
			if(res.size() != 0 || num3[i] != 0) {
				res.push_back(num3[i]+'0');
			}
		}
		return res.size() == 0 ? "0" : res;
    }
};
