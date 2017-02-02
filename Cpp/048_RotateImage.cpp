class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int len = matrix.size();
		if(len <= 1) return;
		int circles = len / 2;
		int numOfMove = len-1;
		for(int index = 0; index < circles; index++) {
			rotateCircle(matrix, index, numOfMove, len);
			numOfMove -= 2;
		}
    }
    
    void rotateCircle(vector<vector<int>>& matrix, int index, int numOfMove, int len) {
        while(numOfMove-- >= 1) {
			
			int tempUpRight = matrix[index][len-index-1]; //5
			for(int i = index, j = len-index-1; j > index; j--) {
				matrix[i][j] = matrix[i][j-1];
			}
			
			//right
			int tempRightDown = matrix[len-index-1][len-index-1]; // 9
			for(int i = len-index-1, j = len-index-1; i > index; i--) {
				matrix[i][j] = matrix[i-1][j];
			}
			matrix[index+1][len-1-index] = tempUpRight;
			
			//down
			int tempDownLeft = matrix[len-index-1][index]; // 13
			for(int i = len-index-1, j = index; j < len-index-1; j++) {
				matrix[i][j] = matrix[i][j+1];
			}
			matrix[len-1-index][len-1-index-1] = tempRightDown;
			
			//left
			for(int i = index, j = index; i < len-index-1; i++) {
				matrix[i][j] = matrix[i+1][j];
			}
			matrix[len-index-1-1][index] = tempDownLeft;
		}
    }
		
};


//method 2
class Solution {
public:
    void rotate(vector<vector<int>>& m) {
        int n = m.size();
        
        for(int i=0; i<n; i++)
            for(int j=0; j<i; j++)
                swap(m[i][j], m[j][i]);
        
        for(int i=0; i<n; i++)
            reverse(m[i].begin(), m[i].end());
    }	
};

//general method
/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
void rotate(vector<vector<int> > &matrix) {
    reverse(matrix.begin(), matrix.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
    }
}

/*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*/
void anti_rotate(vector<vector<int> > &matrix) {
    for (auto vi : matrix) reverse(vi.begin(), vi.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
    }
}
