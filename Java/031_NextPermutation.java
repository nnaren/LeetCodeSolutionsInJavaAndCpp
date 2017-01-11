//package leetCode;
//
//public class NextOrder {
//
//	public void nextPermutation(int[] nums) {
//        if(nums.length <= 1) return;
//        if(nums.length == 2) { 
//        	swap(nums, 0, 1);
//        	return;
//        }
//        if(goDown(nums, 0, nums.length-1)) {
//        	reverseOrder(nums, 0, nums.length-1);
//        	return;
//        }
//        nextPerWithIndex(nums, 0, nums.length-1);  
//    }
//	
//	public void swap(int[] nums, int i, int j) {
//		nums[i] = nums[i]^nums[j];
//		nums[j] = nums[i]^nums[j];
//		nums[i] = nums[i]^nums[j];
//	}
//	
//	public void nextPerWithIndex(int[] nums, int from, int to) {
//		if(from > nums.length-1 || to <= from)
//			return;
//		if(goDown(nums, from+1, to)) {
//        	int i = to;
//        	for(; i >= from+1; i--) {
//        		if(nums[i] > nums[from])
//        			break;
//        	}
//        	swap(nums, from, i);
//        	reverseOrder(nums, from+1, to);
//        	return;
//        }
//		nextPerWithIndex(nums, from+1, to);
//	}
//	
//	public boolean goDown(int[] nums, int from, int to) {
//		for(int i = from; i < to; i++) {
//			if(nums[i] < nums[i+1]) 
//				return false;
//		}
//		return true;
//	}
//	
//	public void reverseOrder(int[] nums, int from, int to) {
//		for(int i = from, j = to; i <= (to+from-1)/2; i++,j--) {
//			swap(nums, i, j);
//		}
//	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] nums = {1,3,3};
//		NextOrder n = new NextOrder();
//		for(int e : nums) {
//			System.out.print(e +" ");
//		}
//		System.out.println();
//		//for(int i = 0; i < 25; i++) {
//			n.nextPermutation(nums);
//			//System.out.print(i+2 + ": ");
//			for(int e : nums) {				
//				System.out.print(e +" ");
//			}
//			//System.out.println();
//		//}
//		//System.out.println(n.goDown(nums, 0, nums.length-1));
//	}
//}



public class Solution {
    public void nextPermutation(int[] A) {
    if(A == null || A.length <= 1) return;
    int i = A.length - 2;
    while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
    if(i >= 0) {                           // If not entirely descending
        int j = A.length - 1;              // Start from the end
        while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
        swap(A, i, j);                     // Switch i and j
    }
    reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
}

public void swap(int[] A, int i, int j) {
    int tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
}

public void reverse(int[] A, int i, int j) {
    while(i < j) swap(A, i++, j--);
}
}
