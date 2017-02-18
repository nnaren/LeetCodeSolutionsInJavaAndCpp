// bitMark
public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		int numOfSubset = 1 << nums.length;
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < numOfSubset; i++)
			res.add(new ArrayList<>());
		
		for (int i = 0; i < nums.length; ++i) 
			for (int j = 0; j < numOfSubset; ++j)
				if(((j >> i) & 1) != 0)
					res.get(j).add(nums[i]);
		return res;	
	}
}

// Iterative
This problem can also be solved iteratively. Take [1, 2, 3] in the problem statement as an example.
The process of generating all the subsets is like:

Initially: \[\[\]\]
Adding the first number to all the existed subsets: [[], [1]];
Adding the second number to all the existed subsets: [[], [1], [2], [1, 2]];
Adding the third number to all the existed subsets: [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]].
Have you got the idea :-)

The code is as follows.
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subs = new ArrayList<>();
		subs.add(new ArrayList<>());
		
		for (int i = 0; i < nums.length; ++i) {
			int n = subs.size();
			for (int j = 0; j < n; j++) {
				List<Integer> temp = new ArrayList<>();
				for (int e : subs.get(j))
					temp.add(e);
				subs.add(temp);
				subs.get(subs.size()-1).add(nums[i]);
			}
		}
		return subs;
    }
}

// backTrack
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subs = new ArrayList<>();
		List<Integer> sub = new ArrayList<>();	
		genSubsets(nums, 0, subs, sub);
		return subs;
    }
	
	private void genSubsets(int[] nums, int start, List<List<Integer>> subs, List<Integer> sub) {
		List<Integer> temp = new ArrayList<>();
		for (int e : sub) temp.add(e);
		subs.add(temp);
		for (int i = start; i < nums.length; i++) {
			sub.add(nums[i]);
			genSubsets(nums, i+1, subs, sub);
			sub.remove(sub.size()-1);
		}
	}
}
