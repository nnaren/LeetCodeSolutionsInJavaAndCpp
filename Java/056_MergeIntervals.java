/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
   public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		if(intervals.isEmpty()) return res;
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return Integer.compare(i1.start, i2.start);
			}
		});
		res.add(intervals.get(0));
		for(int i = 1; i < intervals.size(); i++) {
			if(res.get(res.size()-1).end < intervals.get(i).start)
				res.add(intervals.get(i));
			else 
				res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end, intervals.get(i).end);
		}
		return res;
	}
}


// method 2
/**
 * Definition for an interval. public class Interval { int start; int end;
 * Interval() { start = 0; end = 0; } Interval(int s, int e) { start = s; end =
 * e; } }
 */
public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
		// sort start&end
		int n = intervals.size();
		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			starts[i] = intervals.get(i).start;
			ends[i] = intervals.get(i).end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		// loop through
		List<Interval> res = new ArrayList<Interval>();
		for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
			if (i == n - 1 || starts[i + 1] > ends[i]) {
				res.add(new Interval(starts[j], ends[i]));
				j = i + 1;
			}
		}
		return res;
	}
}
