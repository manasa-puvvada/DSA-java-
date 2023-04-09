public class MirrorBST {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this .data = data;
            this.right = this.left = null; 
        }
    }
    public static Node createMirror(Node root) {
        if(root == null) {
            return null;
        }
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);
        root.right = leftMirror;
        root.left = rightMirror;
        return root;
    }
    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right = new Node(10);
        root.right.right =  new Node(11);
        /*
         *              8
         *             / \
         *            10  5
         *            /   /\
         *           11   6 3
         *        mirror bst
         */
        root =  createMirror(root);
        preorder(root);
    }
}