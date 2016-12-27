//#include <iostream>
//#include <string>
//#include <stack>
//#include <algorithm>
//using namespace std;
//
//class Solution {
//public:
//	string longestPalindrome(string s) {
//		string maxStr = "";
//		for (int i = 0; i < s.length(); i++) {
//			for (int j = 1; j <= s.length()-i; j++) {
//				string tempStr = s.substr(i, j);
//				if(isReverse(tempStr) && tempStr.length() >= maxStr.length()) {
//					maxStr.clear();
//					maxStr = tempStr;
//				}
//			}
//		}
//		return maxStr;
//	}
//
//	bool isReverse(string s) {
//		/*if (s.length() > 1000 || s.length() < 1) {
//			return false;
//		}*/
//		stack<char> stack;
//		auto first = s.begin();
//		auto last = s.end();
//		while (first != last) {
//			stack.push(*first);
//			first++;
//		}
//		string reverse("");
//		while (!stack.empty()) {
//			char c = stack.top();
//			stack.pop();
//			reverse += c; 
//		}
//
//		return s == reverse;
//	}
//};
//
//void main() {
//
//	Solution s;
//	string str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
//	cout << "haha" << endl;
//	bool isreverse = s.isReverse(str);
//	if (isreverse) {
//		cout << "yes" << endl;
//	} else {
//		cout << "no" << endl;
//	}
//
//	string longest = s.longestPalindrome(str);
//	cout << longest <<endl;
//}


#include <iostream>
#include <string>
#include <stack>
#include <algorithm>
using namespace std;

class Solution {
public:
	int lo;
	int maxLen;

public:
	string longestPalindrome(string s) {

		int len = s.length();
		if (len < 2) {
			return s;
		}
		
		for (int i = 0; i < len-1; i++) {

			extendPalindrome(s, i, i);

			extendPalindrome(s, i, i+1);
		}

		return s.substr(lo, maxLen);
	}

	void extendPalindrome(string s, int left, int right) {


		while (left >= 0 && right < s.length() && s[left] == s[right]) {

			left--;

			right++;

		}
		if (maxLen < right - left - 1) {

			maxLen = right - left - 1;

			lo = left + 1;

		}
	}
};

void main() {

	Solution s;
	string str = "babad";
	/*cout << "haha" << endl;
	bool isreverse = s.isReverse(str);
	if (isreverse) {
		cout << "yes" << endl;
	} else {
		cout << "no" << endl;
	}*/

	

	string longest = s.longestPalindrome(str);
	cout << longest <<endl;
}
