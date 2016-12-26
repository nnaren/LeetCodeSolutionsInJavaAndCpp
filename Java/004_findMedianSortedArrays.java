package leetCode;

import java.util.*;

public class median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int l = (m+n+1) >> 1;
        int r = (m+n+2) >> 1;
        return (getKth(nums1, m, nums2, n, l) + getKth(nums1, m, nums2, n, r)) / 2.0;
    }
    
    public int getKth(int[] a, int m, int[] b, int n, int k) {

        if (m > n) {
            return getKth(b, n, a, m, k);
        }
        if (m == 0) {
            return b[k-1];
        }
        if (k == 1) {
            return Math.min(a[0], b[0]);
        }
        
        int i = Math.min(m, k/2);
        int j = Math.min(n, k/2);
        if(a[i-1] < b[j-1]) {
        	int[] a1 = new int[m-i];
        	System.arraycopy(a, i, a1, 0, m-i);
            return getKth(a1, m-i, b, n, k-i);
        } else {
        	int[] b1 = new int[n-j];
        	System.arraycopy(b, j, b1, 0, n-j);
            return getKth(a, m, b1, n-j, k-j);
        }     
    }
    
    
    public static void main(String[] args) {
    	
    	int[] a = {1, 2};
    	int[] b = {3, 4};
    	
    	median m = new median();
    	
    	System.out.println(m.findMedianSortedArrays(a, b));
    }
    
}
