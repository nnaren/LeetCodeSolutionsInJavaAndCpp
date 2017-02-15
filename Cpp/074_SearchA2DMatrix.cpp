class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        int row = matrix.size();
        if (row != 0) {
            int col = matrix[0].size();
            int begin = 0, end = row * col - 1;
            while (begin <= end) {
                int mid = (begin + end) / 2;
                int mid_value = matrix[mid / col][mid % col];
                if (mid_value == target)
                    return true;
                else if (mid_value < target)
                    begin = mid + 1;
                else 
                    end = mid - 1;
            }
        }
        return false;
    }
};

