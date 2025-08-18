package SlidingWindow.FixedSizeWindow;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        System.out.println(maxSum(arr, k)); // Output: 9
    }

    static int maxSum(int[] arr, int k) {
        int windowSum = 0, maxSum = 0;
		
		for (int i=0; i<k; i++){
			windowSum += arr[i];
		}
		
		maxSum = windowSum;
		
		for(int i=k; i<arr.length; i++) {
			windowSum += arr[i] - arr[i-k];
			maxSum = Math.max(windowSum, maxSum);
		}

        return maxSum;
    }
}
