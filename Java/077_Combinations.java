public class Solution {
    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new LinkedList<>();
		int i = 0;
		int[] tmp = new int[k];
		while (i >= 0) {
			tmp[i]++;
			if (tmp[i] > n) --i;
			else if (i == k - 1) {
				List<Integer> temp = new ArrayList<>();
				for (int e : tmp) temp.add(e);
				res.add(temp);
			} else {
				i++;
				tmp[i] = tmp[i-1];
			}
		}
		return res;
	}
}
