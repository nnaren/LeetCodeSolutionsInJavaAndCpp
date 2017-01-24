class Solution {
public:
    string countAndSay(int n) {
		string curr = "1";
		string prev;
		int count;
		char say;

		for(int i = 1; i < n; i++) {
			
			prev = curr;
			curr = "";
			count = 1;
			say = prev[0];

			for (int j = 1, len = prev.size(); j < len; j++) {
				if(prev[j] != say) {
					curr = curr + to_string(count) + say;
					count = 1;
					say = prev[j];
				} else {
					count++;
				}
			}
			curr = curr + to_string(count) + say;
		}
		return curr;
	}
};


//method 2
class Solution {
public:
    string countAndSay(int n) {
    if (n == 0) return "";
    string res = "1";
    while (--n) {
        string cur = "";
        for (int i = 0; i < res.size(); i++) {
            int count = 1;
             while ((i + 1 < res.size()) && (res[i] == res[i + 1])){
                count++;    
                i++;
            }
            cur += to_string(count) + res[i];
        }
        res = cur;
    }
    return res;
}
};
