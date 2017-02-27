class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> res;
        string ans;
        int len = s.size();
        for (int a=1; a<=3; a++)
        for (int b=1; b<=3; b++)
        for (int c=1; c<=3; c++) {
            int d = len - a - b - c;
            if (d > 0 && d <= 3 && a+b+c+d == s.size()) {
                int A = stoi(s.substr(0, a));
                int B = stoi(s.substr(a, b));
                int C = stoi(s.substr(a+b, c));
                int D = stoi(s.substr(a+b+c, d));
                if (A > 255 || B > 255 || C > 255 || D > 255) continue;
                ans = to_string(A) + "." + to_string(B) + "." + to_string(C) + "." + to_string(D);
                if (ans.size() == len + 3)
                    res.push_back(ans);
            }  
        }
        return res;
    }
};
