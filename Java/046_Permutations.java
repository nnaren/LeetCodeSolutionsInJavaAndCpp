public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<>();
        
        for(int e : nums) tmp.add(e);
        res.add(tmp);   
        int[] next = Arrays.copyOf(nums, nums.length);
        nextPermutation(next);
        while(!Arrays.equals(next, nums)) {
        	List<Integer> temp = new ArrayList<>();
        	for(int e : next) temp.add(e);
        	res.add(temp);
        	nextPermutation(next);
        }
        
        return res;
        
    }
	
	public void nextPermutation(int[] nums) {
		if(nums.length <= 1 || nums == null) return;
		int i = nums.length-2;
		while(i >= 0 && nums[i] >= nums[i+1]) i--;
		if(i >= 0) {
			int j = nums.length-1;
			while(nums[j] <= nums[i]) j--;
			swap(nums, i, j);
		}
		reverse(nums, i+1, nums.length-1);
	}
	
	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	private void reverse(int[] nums, int from, int to) {
		while(from < to)
			swap(nums, from++, to--);
	}
}
