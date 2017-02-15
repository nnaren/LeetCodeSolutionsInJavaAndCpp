// insertSort
public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len <= 1) return ;
        insertSort(nums, len);
    }
    
    void insertSort(int[] nums, int len) {
        for (int i = 1; i < len; i++) {
            int key = nums[i];
            int j = i;
            for (; j > 0 && nums[j-1] > key; j--) {
                nums[j] = nums[j-1];
            }
            nums[j] = key;
        }
    }
}

// quickSort
public class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        if (len <= 1) return ;
        quickSort(nums, 0, len-1);
    }
    
    int partition (int lo, int hi, int[] nums) {
    	int key = nums[hi];
    	int i = lo - 1;
    	for (int j = lo; j < hi; j++) {
    		if (nums[j] <= key) {
    			i++;
    			swap(i, j, nums);
    		}
    	}
    	swap(i+1, hi, nums);
    	return i + 1;
    }
    
    void swap(int i, int j, int[] nums) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
    
    void quickSort(int[] nums, int lo, int hi) {
    	if (lo < hi) {
    		int mid = partition(lo, hi, nums);
    		quickSort(nums, lo, mid-1);
    		quickSort(nums, mid+1, hi);
    	}
    }
}
