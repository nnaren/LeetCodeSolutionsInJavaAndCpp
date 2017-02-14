class Solution {
public:
    string simplifyPath(string path) {
	    string res("/");
	    vector<string> stack;
	    stringstream ss(path);
	    string temp;
	    while (getline(ss, temp, '/')) {
			if (temp == "..") {
				if (!stack.empty())
					stack.pop_back();
			} else if (temp != "" && temp != ".")
				stack.push_back(temp);
	    }
		for (string s : stack)
			res += (s + "/");
		if (!stack.empty())
			res.erase(res.length()-1);
		return res;
    }
};
