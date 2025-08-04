package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Solved
 * Medium
 * Topics
 * conpanies icon
 * Companies
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class L_103_BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);
        for(List<Integer> list : result) {
            for(Integer val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return null;

        List<List<Integer>> result = new ArrayList<>();


        Stack<TreeNode> ltor = new Stack<>();
        Stack<TreeNode> rtor = new Stack<>();

        ltor.add(root);
        List<Integer> resultValList = new ArrayList<>();

        while (!ltor.isEmpty() || !rtor.isEmpty()) {

            while (!ltor.isEmpty()) {
                TreeNode node = ltor.pop();
                resultValList.add(node.val);

                if(node.left != null) {
                    rtor.add(node.left);
                }
                if(node.right != null) {
                    rtor.add(node.right);
                }
            }

            if(!resultValList.isEmpty()) {
                result.add(new ArrayList<>(resultValList));
            }
            resultValList.clear();

            while(!rtor.isEmpty()) {
                TreeNode node = rtor.pop();
                resultValList.add(node.val);

                if(node.right != null) {
                    ltor.add(node.right);
                }
                if(node.left != null) {
                    ltor.add(node.left);
                }
            }

            if(!resultValList.isEmpty()) {
                result.add(new ArrayList<>(resultValList));
            }

            resultValList.clear();

        }

        return result;

    }
}
