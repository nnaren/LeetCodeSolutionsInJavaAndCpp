public class Solution {
    public List<String> letterCombinations(String digits) {
        
		 List<String> res = new LinkedList<String>();
		 if(digits.length() == 0) {
            return res;
        }
		 String[] charMap = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		 res.add("");
		 
		 for(int i = 0; i < digits.length(); i++) {
			 List<String> temp = new LinkedList<String>();
			 String chars = charMap[digits.charAt(i)-'0'];
			 for(int j = 0; j < chars.length(); j++) {
				 for(int k = 0; k < res.size(); k++) {
					 temp.add(res.get(k) + chars.charAt(j));
				 }
			 }
			 res = temp;
		 }
		 return res;
	 }
}
