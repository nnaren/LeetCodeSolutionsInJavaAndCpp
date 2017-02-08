class Solution {
public:
    vector<Interval> insert(vector<Interval>& intervals, Interval newInterval) {
		vector<Interval> res;
		for (Interval i : intervals) {
			if (newInterval.start == INT_MAX || i.end < newInterval.start)
				res.push_back(i);
			else if (i.start > newInterval.end) {
				res.push_back(newInterval);
				res.push_back(i);
				newInterval.start = INT_MAX;
			} else {
				newInterval.start = min(newInterval.start, i.start);
				newInterval.end = max(newInterval.end, i.end);
			}
		}

		if (newInterval.start != INT_MAX)
			res.push_back(newInterval);
		return res;
	}
};
