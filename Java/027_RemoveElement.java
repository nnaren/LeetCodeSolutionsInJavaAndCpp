package leetCode;

public class RemoveElement {

	
	public int removeElement(int[] nums, int val) {
		int len = nums.length;
		if (len == 0) return 0;
		if (len == 1 && val != nums[0]) return 1;
		if (len == 1 && val == nums[0]) {
			nums[0] = 0;
			return 0;
		}
		int id = 0;
		for(int i = 0; i < len; i++) {
			if(nums[i] != val) {
				nums[id++] = nums[i];
			}
		}
		return id;
    }
	
	public static void main(String[] args) {
		int[] nums = {1};
		for (int e : nums) {
			System.out.print(e + " ");
		}
		System.out.println();
		RemoveElement r = new RemoveElement();
		System.out.println(r.removeElement(nums, 1));
		for (int e : nums) {
			System.out.print(e + " ");
		}

	}

}
