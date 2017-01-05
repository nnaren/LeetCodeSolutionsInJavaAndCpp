public class Solution {
    public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		addOneByOne(res, "", n, n);
		return res;
	}
	
	public void addOneByOne(List<String> res, String str, int left, int right) {
		if(left == 0 && right == 0) {
			res.add(str);
			return;
		}
		if(left > 0) {
			addOneByOne(res, str+"(", left-1, right);
		}
		if(right > left) {
			addOneByOne(res, str+")", left, right-1);
		}
	}
}
