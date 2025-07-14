public class TreeTraversal {

    class TreeNode {
       int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(TreeNode left, TreeNode right, int value) {
            this.value = value;
            left = left;
            right = right;
        }
    }
    public static void main(String[] args) {
        
        System.out.println("Executing...");
    }

    // Contruct Binary Tree
    void contructBinaryTree(int[] array) {

    }

    static void printTreeNode(TreeNode node) {
       if(node==null) {
        return;
       }

       System.out.print(node.value);
       printTreeNode(node.left);
       printTreeNode(node.right);
    }
}
