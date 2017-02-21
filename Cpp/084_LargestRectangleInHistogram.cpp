// slow easy
class Solution {
public:
    int largestRectangleArea(vector<int>& height) {
        int len = height.size();
        stack<int> s;
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.empty() || h >= height[s.top()]){
                s.push(i);
            }else{
                int tp = s.top();
                s.pop();
                maxArea = max(maxArea, height[tp] * (s.empty() ? i : i - 1 - s.top()));
                i--;
            }
        }
        return maxArea;
    }
};

// fast hard
class Solution {
public:
    int largestRectangleArea(vector<int>& height) {
        int n = height.size(), area = 0;
        stack<int> indexes;
        
        for (int i = 0; i <= n; i++) {
            int height_bound = (i == height.size()) ? 0 : height[i];
            while (!indexes.empty()) {
                int h = height[indexes.top()]; 
                if (h < height_bound) break;
                indexes.pop();
                int index_bound = indexes.empty() ? -1 : indexes.top();
                area = max(area, h * (i - index_bound - 1));
            }
            indexes.push(i);
        }
        return area; 
    }
};
