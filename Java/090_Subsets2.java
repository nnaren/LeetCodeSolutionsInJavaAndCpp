public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int size = 0, startIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
        	startIndex = i >= 1 && nums[i] == nums[i-1] ? size : 0;
        	size = res.size();
        	for (int j = startIndex; j < size; ++j) {
        		List<Integer> temp = new ArrayList<>();
        		for (int e : res.get(j))
        			temp.add(e);
        		temp.add(nums[i]);
        		res.add(temp);
        	}
        }
        return res;
    }
}
