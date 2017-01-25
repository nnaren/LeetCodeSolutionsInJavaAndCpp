public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTrack2(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
	
	private void backTrack2(int[] candidates, int target, List<List<Integer>> res, List<Integer> combination, int begin) {
		if(target == 0) {
			res.add(new ArrayList<>(combination));
			return;
		} else {
			for(int i = begin; i < candidates.length && target >= candidates[i]; ++i) {
				if(i == begin || candidates[i] != candidates[i-1]) {
					combination.add(candidates[i]);
					backTrack2(candidates, target-candidates[i], res, combination, i+1);
					combination.remove(combination.size()-1);			
				}
			}
		}
	}
}
