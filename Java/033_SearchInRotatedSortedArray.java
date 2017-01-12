public class Solution {
    public int search(int[] nums, int target) {
		int n = nums.length;
        if(n == 0 || (n == 1 && nums[0] != target))
        	return -1;
        int index = -1;
        int i = 0;
        for(; i < n-1; i++) {
        	if(nums[i+1] < nums[i])  {
        		break;
        	}
        }
        int[] nums1 = Arrays.copyOfRange(nums, 0, i+1);//
        int res1 = Arrays.binarySearch(nums1, target);
        if(res1 >= 0) 
        	return res1; 
        else {
        	int[] nums2 = Arrays.copyOfRange(nums, i+1, n);
        	int res2 = Arrays.binarySearch(nums2, target);
        	if(res2 >= 0)
        		return res2+nums1.length;
        	else        		
        		return index;  
        }
    }
}


///////////
public class Solution {
    public int search(int[] nums, int target) {
		int begin = 0, end = nums.length-1;
		while(begin <= end) {
			int mid = (begin+end)/2;
			if(nums[mid] == target) 
				return mid;
			if(nums[begin] <= nums[mid]) {
				if(nums[begin] <= target && target < nums[mid])
					end = mid - 1;
				else 
					begin = mid + 1;
			} else {
				if(nums[mid] < target && target <= nums[end]) 
					begin = mid + 1;
				else 
					end = mid - 1;
			}
		}
		return -1;
    }
}
