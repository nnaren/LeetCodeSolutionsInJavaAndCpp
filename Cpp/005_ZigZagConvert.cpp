#include<iostream>
#include<string>

using namespace std;


class Solution {
public:
    string convert(string s, int numRows) {
		
		if(numRows <= 1) 
			return s;

        int len = s.length();
		string *str = new string[numRows];
		
		
		int step = 1, row = 0;
		for (int i = 0; i < len; i++) {
			
			str[row].push_back(s[i]);

			if(row == 0) step = 1;
			else if(row == numRows-1) step = -1;
			row += step;
		}

		s.clear();

		for(int i = 0; i < numRows; i++) {
			s.append(str[i]);
		}
		return s;
    }

	/*string convert(string s, int nRows) {
    
    if (nRows <= 1)
        return s;

    const int len = (int)s.length();
    string *str = new string[nRows];

    int row = 0, step = 1;
    for (int i = 0; i < len; ++i)
    {
        str[row].push_back(s[i]);

        if (row == 0)
            step = 1;
        else if (row == nRows - 1)
            step = -1;

        row += step;
    }

    s.clear();
    for (int j = 0; j < nRows; ++j)
    {
        s.append(str[j]);
    }

    delete[] str;
    return s;
}*/
};

void main() {

	Solution s;
	string a = "PAYPALISHIRING";
	cout << s.convert(a, 3) << endl;
}
