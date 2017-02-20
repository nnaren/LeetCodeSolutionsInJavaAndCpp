class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        vector<int> aux(m+n);
        int i = 0, j = m;
        for (int k = 0; k < m; k++) {
        	aux[k] = nums1[k];
        }
        for (int k = 0; k < n; k++) {
        	aux[m + k] = nums2[k];
        }
        
        for (int k = 0; k < m+n; k++) {
        	if (i >= m) nums1[k] = aux[j++];
        	else if (j >= n+m) nums1[k] = aux[i++];
        	else if (aux[i] < aux[j]) nums1[k] = aux[i++];
        	else nums1[k] = aux[j++];
        }
    }
};
