We start with trimming.

If we see [0-9] we reset the number flags.
We can only see . if we didn't see e or ..
We can only see e if we didn't see e but we did see a number. We reset numberAfterE flag.
We can only see + and - in the beginning and after an e
any other character break the validation.
At the and it is only valid if there was at least 1 number and if we did see an e then a number after it as well.

So basically the number should match this regular expression:

[-+]?(([0-9]+(.[0-9]*)?)|.[0-9]+)(e[-+]?[0-9]+)?

// CODE
class Solution {
public:
    bool isNumber(string s) {
        bool numberSeen = false;
		bool pointSeen = false;
		bool eSeen = false;
		bool numberAfterE = true;

		int beginIndex = 0, endIndex = s.length()-1;
		while (s[beginIndex] == ' ') beginIndex++;
		while (s[endIndex] == ' ') endIndex--;

		for (int i = beginIndex; i <= endIndex; i++) {

			if ('0' <= s[i] && s[i] <= '9') {
				numberSeen = true;
				numberAfterE = true;
			} else if (s[i] == '.') {
				if (pointSeen || eSeen)
					return false;
				pointSeen = true;
			} else if (s[i] == 'e') {
				if (eSeen || !numberSeen)
					return false;
				eSeen = true;
				numberAfterE = false;
			} else if (s[i] == '+' || s[i] == '-') {
				if (i != beginIndex && s[i-1] != 'e') 
					return false;
			} else {
				return false;
			}
		}
		return numberAfterE && numberSeen;
    }
};
