class Solution {
public:
    int trap(vector<int>& height) {
        if(height.size() <= 2) return 0;
        int left = 0, right = height.size()-1, totalArea = 0;
        int leftMaxHeight = height[left], rightMaxHeight = height[right];
        while(left < right) {
            if(height[left] < height[right]) {
                leftMaxHeight = max(leftMaxHeight, height[++left]);
                totalArea += leftMaxHeight - height[left];
            } else {
                rightMaxHeight = max(rightMaxHeight, height[--right]);
                totalArea += rightMaxHeight - height[right];
            }
        }
        return totalArea;
    }
};
