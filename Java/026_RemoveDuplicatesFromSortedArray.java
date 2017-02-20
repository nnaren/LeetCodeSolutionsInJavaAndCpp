//package leetCode;
/////////////////////////此方法栈溢出
//public class RemoveDuplicatesfromSortedArray {
//	
//	public int removeDuplicates(int[] nums) {
//        return lengthOfArray(nums, 0, nums.length-1);
//    }
//	
//	public int lengthOfArray(int[] nums, int first, int last) {
//		int length = last-first+1;
//		if(length <= 0) return 0;
//		if(length == 1) return 1;
//		if(nums[first] != nums[first+1]) return 1+lengthOfArray(nums, first+1, last);
//		else return lengthOfArray(nums, first+1, last);
//	}
//	
//	public static void main(String[] args) {
//		
//		int[] nums = {};
//		RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
//		System.out.println(r.removeDuplicates(nums));
//	}
//}

// best
public int removeDuplicates(int[] nums) {
    int i = 0;
    for(int n : nums)
        if(i < 1 || n > nums[i - 1]) 
            nums[i++] = n;
    return i;
}

// another method
package leetCode;

public class RemoveDuplicatesfromSortedArray {
	
	public int removeDuplicates(int[] nums) {
		int length = nums.length;
        if(length == 0) return 0;
        if(length == 1) return 1;
        
        int newArrayIndex = 0;
        int i = 0;
        while(i<length) {
        	int key = nums[i];
        	while(i+1 < length && nums[i+1] == key) i++;
        	nums[newArrayIndex++] = key;
        	i++;
        }
        
        
        int count = 0;
        for(i = 0; i < length-1; i++) {
        	if(nums[i+1] - nums[i] > 0) count++;
        	else break;
        }
        return count+1;
    }
	
	
	
	public static void main(String[] args) {
		
		int[] nums = {1,1,1,2,2,3,3,4,5};
		RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
		System.out.println(r.removeDuplicates(nums));
	}
}



///////////////////////////another method
public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
		if(len < 2) return len;
		int id = 1;
		for (int i = 1; i < len; i++) {
		    if(nums[i] != nums[i-1])
		        nums[id++] = nums[i];
		}
		return id;
    }
}
