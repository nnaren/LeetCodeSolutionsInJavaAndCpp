// bacttrack
public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();
		subsetsWithDup(res, nums, temp, 0);
	    return res;
	}
	  
	private void subsetsWithDup(List<List<Integer>> res, int[] nums, List<Integer> temp, int begin) {
		List<Integer> sub = new ArrayList<>();
		for (int e : temp) sub.add(e);
		res.add(sub);
		for (int i = begin; i < nums.length; ++i) {
			if (i == begin || nums[i] != nums[i-1]) {
				temp.add(nums[i]);
				subsetsWithDup(res, nums, temp, i+1);
				temp.remove(temp.size()-1);
		    }	  
	    }
	}
}

// iterative
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
