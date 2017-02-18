public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
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
