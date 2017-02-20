// best
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, tar = m + n - 1;
        while (j >= 0)
        	if (i >= 0)
        		nums1[tar--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        	else
        		nums1[tar--] = nums2[j--];
    }
}

// bad
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] aux = new int[m+n];
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
}
