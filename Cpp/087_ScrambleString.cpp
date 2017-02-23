class Solution {
public:
    bool isScramble(string s1, string s2) {
        if (s1 == s2) return true;
        if (s1.size() != s2.size()) return false;
        
        vector<int> letters(26, 0);
        for (int i = 0; i < s1.length(); i++) {
        	letters[s1[i] - 'a']++;
        	letters[s2[i] - 'a']--;
        }
        for (int i = 0; i < 26; i++)
        	if (letters[i] != 0)
        		return false;
        for (int i = 1; i < s1.size(); i++) {
        	if (isScramble(s1.substr(0, i), s2.substr(0, i)) 
        	 && isScramble(s1.substr(i, s1.size()-i), s2.substr(i, s2.size()-i)))
        		return true;
        	if (isScramble(s1.substr(0, i), s2.substr(s2.size()-i, i))
        	 && isScramble(s1.substr(i, s1.size()-i), s2.substr(0, s2.size()-i)))
        		return true;
        }
        return false;
    }
};
