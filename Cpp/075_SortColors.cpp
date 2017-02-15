The lables of colors are used to mark the end of different colors.

For example:

nums: [0 1 2 1 2 0 2 2 1]
 two   "0" --> r is 2 --> [0, 2)
 three "1" --> w is 5 --> [2, 5)
 four  "2" --> b is 9 --> [5, 9)
We may just scan the nums to get r, w and b. And then iterate the array again to assign nums[0..1] = 0, nums[2..4] = 1, nums[5..8] = 2.

Here comes the amazing part of this idea! @flying_birdman didn't iterate twice but assign the array in the first pass!

It's like painting the array: the later color will cover the previous color.

For example:

------- Before meeting nums[3] -------
index:  0 1 2 3 4 5 6 7 8
nums:   0 1 2 1 2 0 2 2 1
lables:   r w b

paint:  2 2 2 
        1 1   
        0
       
appear: 0 1 2 

------- After dealing with nums[3] -------
index:  0 1 2 3 4 5 6 7 8
nums:   0 1 2 1 2 0 2 2 1
lables:   r   w b

paint:  2 2 2 2
        1 1 1  
        0
       
appear: 0 1 1 2

------- After finish iteration -------
index:  0 1 2 3 4 5 6 7 8
nums:   0 1 2 1 2 0 2 2 1
lables:     r     w       b

paint:  2 2 2 2 2 2 2 2 2
        1 1 1 1 1  
        0 0 
       
appear: 0 0 1 1 1 2 2 2 2
// best answer
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int r=0, w=0, b=0; // label the end of different colors;
        for(int num: nums){
            if(num==0) {nums[b++]=2; nums[w++]=1; nums[r++]=0; } 
            else if(num==1) {nums[b++]=2; nums[w++]=1;}
            else if(num==2) b++;
        }
    }
};

// insertSort
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int len = nums.size();
        if (len <= 1) return ;
        insertSort(nums, len);
    }
    
    void insertSort(vector<int>& nums, int len) {
    	for (int i = 1; i < len; i++) {
    	    int key = nums[i];
    	    int j = i;
    	    for (; j > 0 && nums[j-1] > key; --j)
    	        nums[j] = nums[j-1];
    	    nums[j] = key;
    	}
    }
};

// quickSort
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int len = nums.size();
        if (len <= 1) return ;
        quickSort(nums, 0, len-1);
    }
    
    int partition (int lo, int hi, vector<int>& nums) {
    	int key = nums[hi];
    	int i = lo - 1;
    	for (int j = lo; j < hi; j++) {
    		if (nums[j] <= key) {
    			i++;
    			swap(i, j, nums);
    		}
    	}
    	swap(i+1, hi, nums);
    	return i + 1;
    }
    
    void swap(int i, int j, vector<int>& nums) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
    
    void quickSort(vector<int>& nums, int lo, int hi) {
    	if (lo < hi) {
    		int mid = partition(lo, hi, nums);
    		quickSort(nums, lo, mid-1);
    		quickSort(nums, mid+1, hi);
    	}
    }
};
