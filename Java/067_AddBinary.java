public class Solution {
    public String addBinary(String a, String b) {
		StringBuilder res = new StringBuilder();
		int flag = 0;
		int lenA = a.length()-1, lenB = b.length()-1;
		
		while(lenA >= 0 || lenB >= 0) {
			if(lenA < 0) {
				int key = flag + (b.charAt(lenB--)-'0');
				flag = key > 1 ? 1 : 0;
				res.insert(0, key%2);
			} else if(lenB < 0) {
				int key = flag + (a.charAt(lenA--)-'0');
				flag = key > 1 ? 1 : 0;
				res.insert(0, key%2);
			} else {
				int key = flag + (b.charAt(lenB--)-'0') + (a.charAt(lenA--)-'0');
				flag = key > 1 ? 1 : 0;
				res.insert(0, key%2);
			}
		}
		if(flag == 1) res.insert(0, 1);
		return res.toString();
    }
}
