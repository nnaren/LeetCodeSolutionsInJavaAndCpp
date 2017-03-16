public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return nums;
        int[] res = new int[len - k + 1];
        
        Deque<Integer> dq = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
        	while (!dq.isEmpty() && dq.peekLast() < nums[i])
        		dq.pollLast();
        	
        	dq.offer(nums[i]);
        	
        	if (i >= k - 1) {
        		res[i - k + 1] = dq.peek();
        		if (nums[i - k + 1] == dq.peek())
        			dq.pollFirst();
        	}
        }
    	return res;
    }
}


public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return nums;
        int[] res = new int[len - k + 1];
        
        Deque<Integer> dq = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
        	if (!dq.isEmpty() && dq.peek() < i - k + 1)
        		dq.poll();
        	
        	while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
        		dq.pollLast();
        	
        	dq.offer(i);
        	if (i - k + 1 >= 0) 
        		res[i - k + 1] = nums[dq.peek()];
        }
        return res;
    }
}
