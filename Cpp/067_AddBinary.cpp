class Solution {
public:
    string addBinary(string a, string b) {
		string res;
		int flag = 0;
		int lenA = a.length()-1, lenB = b.length()-1;
		while (lenA >= 0 || lenB >= 0) {
		    int key = flag;
            if(lenA >= 0) key += (a[lenA--] - '0'); 
            if(lenB >= 0) key += (b[lenB--] - '0');
			flag = key / 2;
			res.push_back(key%2+'0');
		}
		if(flag == 1) res.push_back('1');
		reverse(res.begin(), res.end());
		return res;
	}
};

////////////////////////////////////////////////////////////////////
// class Solution {
// public:
//     string addBinary(string a, string b) {
// 		string res;
// 		int flag = 0;
// 		int lenA = a.length()-1, lenB = b.length()-1;
// 		int key = 0;
// 		while (lenA >= 0 || lenB >= 0) {
// 			if(lenA < 0) {
// 				key = flag + (b[lenB--] - '0');
// 			} else if(lenB < 0) {
// 				key = flag + (a[lenA--] - '0');
// 			} else {
// 				key = flag + (a[lenA--] - '0') + (b[lenB--] - '0');
// 			}
// 			flag = key > 1 ? 1 : 0;
// 			res.push_back(key%2+'0');
// 		}
// 		if(flag == 1) res.push_back('1');
// 		reverse(res.begin(), res.end());
// 		return res;
// 	}
// };
