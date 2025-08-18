package SlidingWindow.VariableSizeWindow;

public class L209Minimum_Size_Subarray_Sum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums)); // Output: 2
    }
	
	static int minSubArrayLen(int target, int[] nums) {
		
		int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
		
		for (int right=0; right < nums.length; right++) {
			sum += nums[right];
			
			//Check the sum is equal or greater than target Value
			while (sum >= target) {
				minLen = Math.min(minLen, right - left +1);
				sum -= nums[left++];
			}				
	
		}
		
		return minLen == Integer.MAX_VALUE ? 0: minLen;
	
	}
}
