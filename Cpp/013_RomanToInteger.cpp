class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> table = {
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000}
        };
        
        int num = table[s.back()];
        
        for(int i = s.length()-2; i >= 0; i--) {
            num = table[s[i]] < table[s[i+1]] ? num - table[s[i]] : num + table[s[i]];  
        }
        
        return num;
    }
};
