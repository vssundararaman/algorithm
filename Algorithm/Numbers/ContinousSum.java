package Numbers;

public class ContinousSum {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,1,3,9};
        int k = 3;

        System.out.println(continuousSum(nums, k));

        int[] nums2 = {1,100,1,1,1,7,5};
        int k2 = 2;

        System.out.println(continuousSum(nums2, k2));
    }

    static int continuousSum(int[] nums, int k) {

        int result = 0;

        for (int i = 0; i < k;i++){
            result += nums[i];
        }
        int sum = result;
        for(int j=k; j<nums.length; j++) {
            sum+= nums[j]-nums[j-k];
            result = Math.max(result, sum);
        }

        return result;
    }


}
