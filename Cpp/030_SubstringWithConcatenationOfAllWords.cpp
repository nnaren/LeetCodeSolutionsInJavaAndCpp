class Solution {
public:
     vector<int> findSubstring(string s, vector<string>& words) {
        unordered_map<string, int> count;
        for (string e : words) {
            count[e]++;
        }
        int n = s.length(), num = words.size(), len = words[0].length();
        vector<int> res;
        
        for (int i = 0; i < n - len * num + 1; i++) {
            int j = 0;
            unordered_map<string, int> seen;
            for (; j < num; j++) {
                string word = s.substr(i+j*len, len);
                if (count.find(word) != count.end()) {
                    seen[word]++;
                    if (seen[word] > count[word])
                    break;
                } else break;
            }
            if (j == num) 
                res.push_back(i);
        }
        return res;
     }
};
