package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Solved
 * Medium
 * Topics
 * conpanies icon
 * Companies
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
public class L_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {


    static int preOrderIndex = 0;
    static Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

    public static void main(String[] args){

        int[] preOrder = {3,9,20,15,7};
        int[] inOrder = {9,3,15,20,7};
        TreeNode root = buildTree(preOrder, inOrder);
        System.out.println("in Order");
        printInOrder(root);
        System.out.println("PreOrder");
        printPreOrder(root);

    }

    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {

        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }

        return build(preOrder, inOrder, 0, inOrder.length-1);
    }

    static TreeNode build(int[] preOrder, int[] inOrder, int left, int right) {

        if(left > right) {
            return null;
        }

        int rootValue = preOrder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int inOrderIndex = inOrderIndexMap.get(rootValue);

        root.left = build(preOrder, inOrder, left, inOrderIndex-1);
        root.right = build(preOrder, inOrder, inOrderIndex+1, right);

        return root;
    }

    static void printInOrder(TreeNode root) {
        if(root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    static void printPreOrder(TreeNode root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    void printPostOrder(TreeNode root) {
        if(root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.val + " ");
    }

}
