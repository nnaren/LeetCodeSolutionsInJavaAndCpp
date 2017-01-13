public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        
		if(nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
			res[0] = -1;
			res[1] = -1;
			return res;
		}
		
        if(nums.length == 1 && nums[0] == target) {
        	res[0] = 0;
			res[1] = 0;
			return res;
        }
        return searchRangeWithIndex(nums, target, 0, nums.length-1);
	}
	
	public int[] searchRangeWithIndex(int[] nums, int target, int from, int to) {
		if(from > to || (from == to && nums[from] != target) || to < 0) {
			int[] res = {-1,-1};
			return res;
		}
		if(from == to && nums[from] == target) {
			int[] res = {from, to};
			return res;
		}
		
		int mid = bSearch(nums, from, to, target);
		if(mid == -1) {
			int[] res = {-1,-1};
			return res;
		} else {
			int[] left = searchRangeWithIndex(nums, target, from, mid-1);
			int[] right = searchRangeWithIndex(nums, target, mid+1, to);
			
			int leftIndex = -1, rightIndex = -1;
			if(left[0] == -1) leftIndex = mid;
			else leftIndex = left[0];
			if(right[1] == -1) rightIndex = mid;
			else rightIndex = right[1];
			int[] res = {leftIndex, rightIndex};
			return res;
		}	
	}
	
	public int bSearch(int[] nums, int lo, int hi, int key) {
		if(lo <= hi) {
			int mid = (lo + hi) / 2;
			if(nums[mid] == key) return mid;
			else if(nums[mid] < key) return bSearch(nums, mid+1, hi, key);
			else return bSearch(nums, lo, mid-1, key);
		} else return -1;
	}
}
