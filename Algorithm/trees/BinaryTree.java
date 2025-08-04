package trees;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    // Method to insert a new node
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }

        if (data < current.key) {
            current.left = insertRecursive(current.left, data);
        } else if (data >= current.key) { // Handle duplicates by placing in the right subtree
            current.right = insertRecursive(current.right, data);
        }
        return current;
    }

    // Optional: Method for in-order traversal to verify the tree
    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.key + " ");
            inorderRecursive(node.right);
        }
    }

}