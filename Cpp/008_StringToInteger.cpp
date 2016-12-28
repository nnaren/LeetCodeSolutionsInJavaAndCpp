//#include <iostream>
//#include <string>

//using namespace std;


//class Solution {
//public:
//	int myAtoi(string str) {
//		int sign = 1, base = 0, i = 0;
//		while (str[i] == ' ') { i++; }
//		if (str[i] == '-' || str[i] == '+') {
//			sign = 1 - 2 * (str[i++] == '-'); 
//		}
//		while (str[i] >= '0' && str[i] <= '9') {
//			if (base >  INT_MAX / 10 || (base == INT_MAX / 10 && str[i] - '0' > 7)) { //  INT_MAX = 2147483647 最后一位是7
//				if (sign == 1) return INT_MAX;
//				else return INT_MIN;
//			}
//			base  = 10 * base + (str[i++] - '0');
//		}
//		return base * sign;
//	}
//};


//void main() {
//	Solution s;	
//string str = "-2147483649";	
//cout << s.myAtoi(str) << endl;
	//cout << INT_MAX;
//}
#include <iostream>
#include <string>

using namespace std;


class Solution {
public:
	int myAtoi(string str) {
		long long result = 0;
		int indicator = 1;
		for(int i = 0; i<str.size();)
		{
			i = str.find_first_not_of(' ');
			if(str[i] == '-' || str[i] == '+')
				indicator = (str[i++] == '-')? -1 : 1;
			while('0'<= str[i] && str[i] <= '9') 
			{
				result = result*10 + (str[i++]-'0');
				if(result*indicator >= INT_MAX) return INT_MAX;
				if(result*indicator <= INT_MIN) return INT_MIN;                
			}
			return result*indicator;
		}
	}
};


void main() {
	Solution s;
	string str = "-2147483649";
	cout << s.myAtoi(str) << endl;
	//cout << INT_MAX;
	//cout << str[0] << endl;
}
