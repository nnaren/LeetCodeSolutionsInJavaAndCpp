class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
       int len = nums.size();
       if (len == 0) return 0;
       if (len == 1 && val != nums[0]) return 1;
       if (len == 1 && val == nums[0]) {
           nums[0] = 0;
           return 0;
       }
       int id = 0;
       for (int i = 0; i < len; i++) {
           if (nums[i] != val) {
               nums[id++] = nums[i];
           }
       }
       return id;
    }
};
