/**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    vector<Interval> merge(vector<Interval>& ins) {
        int n = ins.size();
        vector<int> starts(n, 0);
        vector<int> ends(n, 0);
        for(int i = 0; i < n; i++) {
            starts[i] = ins[i].start;
            ends[i] = ins[i].end;
        }
        
        sort(starts.begin(), starts.end());
        sort(ends.begin(), ends.end());
        vector<Interval> res; 
        for(int i = 0, j = 0; i < n; ++i) {
            if(i == n-1 || starts[i+1] > ends[i]) {
                Interval temp(starts[j], ends[i]);
                res.push_back(temp);
                j = i + 1;
            }
        }
        return res;
    }
};
