public class Solution {
    public String getPermutation(int n, int k) {
    	List<Integer> nums = new ArrayList<>();
    	int factorial = 1;
    	StringBuilder sb = new StringBuilder();
 
    	for(int i = 1; i <= n; i++) {
    		factorial *= i;
    		nums.add(i);
    	}
    	for(int i = 0, last = k-1; i < n; i++) {
    		factorial /= (n - i);
    		int index = (last / factorial);
    		sb.append(nums.remove(index));
    		last -= index * factorial;
    	}
    	return sb.toString();
    }
}
