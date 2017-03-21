// method 1
// priorityQueue by MinHeap
// O(N lg K)
public class Solution {
	private int parent(int i) {
		return (i - 1) / 2;
	}
	
	private int leftChild(int i) {
		return i * 2 + 1;
	}
	
	private int rightChild(int i) {
		return i * 2 + 2;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	private void minHeap(int[] nums, int len, int i) {
		int lChild = leftChild(i);
		int rChild = rightChild(i);
		int minPos = i;
		if (lChild < len && nums[lChild] < nums[minPos]) minPos = lChild;
		if (rChild < len && nums[rChild] < nums[minPos]) minPos = rChild;
		
		if (minPos != i) {
			
			swap(nums, minPos, i);
			minHeap(nums, len, minPos);
		}	
	}
	
	private void buildMinHeap(int[] nums, int len) {
		for	(int i = parent(len - 1); i >= 0; i--)
			minHeap(nums, len, i);
	}
	
	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length < k || k <= 0)
			return -1;
		int[] minHeap = new int[k];
		for(int i = 0; i < k; i++) 
			minHeap[i] = nums[i];
		buildMinHeap(minHeap, k);
		
		for (int i = k; i < nums.length; i++) {
			if (minHeap[0] < nums[i]) {
				minHeap[0] = nums[i];
				minHeap(minHeap, k, 0);
			}
		}
		return minHeap[0];
	}
}

// method 2
//O(N lg K) running time + O(K) memory
public class Solution {
  
    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length < k || k <= 0)
            return -1;
        PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
        for (int val : nums) {
            minQueue.offer(val);
            
            if (minQueue.size() > k)
            	minQueue.poll();
        }
        return minQueue.peek();
    }

}

// method 3
//O(N) best case / O(N^2) worst case running time + O(1) memory
public class Solution {
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

	public int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length < k || k <= 0)
			return -1;
		
		int lo = 0, hi = nums.length - 1;
		
		while (true) {
			int index = partition(nums, lo, hi);
			if (index == nums.length - k)
				return nums[index];
			else if (index < nums.length - k)
				lo = index + 1;
			else hi = index - 1;
		}
	}
}
