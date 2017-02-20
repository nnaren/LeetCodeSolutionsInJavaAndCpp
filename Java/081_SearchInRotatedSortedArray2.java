public class Solution {
    public boolean search(int[] nums, int target) {
    	int lo = 0, hi = nums.length-1;
    	while (lo <= hi) {
    		int mid = (lo + hi) / 2;
    		if (nums[mid] == target) return true;
    		else if (nums[lo] < nums[mid]) {
    			if (nums[lo] <= target && target < nums[mid]) hi = mid - 1;
    			else lo = mid + 1;
    		} else if (nums[lo] > nums[mid]) {
    			if (nums[mid] < target && target <= nums[hi]) lo = mid + 1;
    			else hi = mid - 1;
    		} else lo++;
    	}
    	return false;
    }
}
