package trees;

import java.util.HashMap;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 */
public class L_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    static int postIndex = 0;
    private static HashMap<Integer, Integer> inorderMap;

    public static void main(String[] args) {

    }

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;

        // Store inorder values and their indices
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    static TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if(start < end) return null;

        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        int index = inorderMap.get(rootValue);

        // Build right first, then left (because postorder goes Left-Right-Root)
        root.right = build(inorder, postorder, index + 1, end);
        root.left = build(inorder, postorder, start, index - 1);

        return root;
    }
}
