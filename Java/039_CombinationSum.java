public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTrack(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
	
	private void backTrack(int[] candidates, int target, List<List<Integer>> res, List<Integer> combination, int begin) {
		if(target == 0) {
			res.add(new ArrayList<>(combination));
			return;
		} else {
			for(int i = begin; i < candidates.length && target >= candidates[i]; ++i) {
				combination.add(candidates[i]);
				backTrack(candidates, target-candidates[i], res, combination, i);
				combination.remove(combination.size()-1);
			}
		}
	}
}
