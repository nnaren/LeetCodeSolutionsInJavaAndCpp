// method 2
//O(N lg K) running time + O(K) memory
public class Solution {
    public int findKthLargest(int[] nums, int k) {
    
        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);
    
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

// method 3
//O(N) best case / O(N^2) worst case running time + O(1) memory
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || k > nums.length || nums.length <= 0 || k <= 0)
            return 0;

	    int start = 0, end = nums.length - 1;
	    int index = partition(nums, start, end);

    	while (index != nums.length - k) {
    		if (index > nums.length - k)
    			end = index - 1;
    		else
    			start = index + 1;
    		index = partition(nums, start, end);
    	}
    	
        return nums[index];
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int key = nums[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; ++j) {
            if (nums[j] <= key) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, hi);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
