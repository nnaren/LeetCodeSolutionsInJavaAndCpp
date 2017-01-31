public class Solution {
    public int maxSubArray(int[] A) {
        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
    	    maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
    	    maxSoFar=Math.max(maxSoFar, maxEndingHere);	
        }
        return maxSoFar;
    }
}

//method 2

public class Solution {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        else return maxSubArray(nums, 0, len-1);
    }
    
    public int maxSubArray(int[] nums, int low, int high) {
    	if(high == low) return nums[low];
    	else {
    		int mid = (low + high) / 2;
    		int left = maxSubArray(nums, low, mid);
    		int right = maxSubArray(nums, mid+1, high);
    		int cross = maxSubArrayCrossMid(nums, low, mid, high);
    		int res = left > right ? left : right;
    		res = res > cross ? res : cross;
    		return res;
    	}
    }
    
    public int maxSubArrayCrossMid(int[] nums, int low, int mid, int high) {
    	int left_sum, right_sum;
    	int sum;
    	
    	sum = 0;
    	left_sum = Integer.MIN_VALUE;
    	for(int i = mid; i >= low; i--) {
    		sum += nums[i];
    		if (sum > left_sum) {
				left_sum = sum;
			}
    	}
    	
    	sum = 0;
    	right_sum = Integer.MIN_VALUE;
    	for(int i = mid + 1; i <= high; i++) {
    		sum += nums[i];
    		if (sum > right_sum) {
    			right_sum = sum;
    		}
    	}  	
    	return left_sum + right_sum;
    }
}
