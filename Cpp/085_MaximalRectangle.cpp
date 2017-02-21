class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if(matrix.size() == 0 || matrix[0].size() == 0) return 0;
        
        vector<int> height(matrix[0].size());
        for(int i = 0; i < matrix[0].size(); i++){
            if(matrix[0][i] == '1') height[i] = 1;
        }
        int result = largestInLine(height);
        for(int i = 1; i < matrix.size(); i ++){
            resetHeight(matrix, height, i);
            result = max(result, largestInLine(height));
        }
        
        return result;
    }
    
    void resetHeight(vector<vector<char>>& matrix, vector<int>& height, int idx){
        for(int i = 0; i < matrix[0].size(); i++){
            if(matrix[idx][i] == '1') height[i] += 1;
            else height[i] = 0;
        }
    }
    
    int largestInLine(vector<int>& height) {
		stack<int> s;
		int max_area = 0;
		for (int i = 0; i <= height.size(); ++i) {
			int height_bound = (i == height.size()) ? 0 : height[i];
			while (!s.empty()) {
				int h = height[s.top()];
				if (h < height_bound) break;
				s.pop();
				int index_bound = s.empty() ? -1 : s.top();
				max_area = max(max_area, h * ((i - 1) - index_bound));
			}
			s.push(i);
		}
		return max_area;
	}
};
