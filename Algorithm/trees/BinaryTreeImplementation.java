package trees;



/**
 *  108. Convert Sorted Array to Binary Search Tree
 * Solved
 * Easy
 * Topics
 * conpanies icon
 * Companies
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */
public class BinaryTreeImplementation {


    public static void main(String[] args) {

        BinaryTreeImplementation bt = new BinaryTreeImplementation();
        //int[] nums = {-10,-3,0,5,9};
        int[] nums = {10,-3,0,5,-9};
        TreeNode root = bt.constructTreeNode(nums, 0, nums.length-1);
        bt.printInOrder(root);
    }

    TreeNode constructTreeNode(int[] nums, int left, int right) {
        if(left > right) return null;

        int mid = left + (right-left) /2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructTreeNode(nums, left, mid-1);
        root.right = constructTreeNode(nums, mid+1, right);

        return root;
    }

    void printInOrder(TreeNode root) {
        if(root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }



}
