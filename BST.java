import java.util.*;
public class BST {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }
        if(root.data < val) {
            root.right = insert(root.right,val);
        
        } else {
            root.left = insert(root.left,val);
            
        }
        return root;
    }
    public static void inOrder(Node root) {
        if(root == null) {
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static boolean search(Node root, int key)  {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(root.data > key) {
            return search(root.left, key);
        }
        else {
            return search(root.right,key);
        }
    }
    public static Node delete(Node root, int key) {
        if(root.data < key) {
            root.right = delete(root.right, key);
        } else if(root.data > key) {
            root.left = delete(root.left, key);
        } else {//voila
            //case -1 leaf node delete
            if(root.left == null && root.right == null) {
                return null;
            } //case -2 single child
            else if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            } else {
                //case 3 two children
                Node Is = findInorderSuccessor(root.right);
                root.data = Is.data;
                root.right = delete(root.right,Is.data);
            }
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root) {
        while(root.left!= null) {
            root = root.left;
        }
        return root;
    }
    public static void printInRange(Node root, int k1, int k2) {
        if(root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        } else if (root.data > k2) {
            printInRange(root.right, k1, k2);
        } else {
            printInRange(root.left, k1, k2);
        }
    }
    public static void root2LeafPaths(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        } 
        path.add(root.data);
        if(root.right == null && root.left == null) {
            printPath(path);
        }
        root2LeafPaths(root.left, path);
        root2LeafPaths(root.right, path);
        path.remove(path.size()-1);
    }
    public static void printPath(ArrayList<Integer> path) {
        for(int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.println("Null");
    }
    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }
        if(min != null && root.data <= min.data) {
            return false;
        } else if(max != null && root.data >= max.data) {
            return false;
        }
        return isValidBST(root.right, root, max) && isValidBST(root.left, min, root);
    }

    public static void main(String args[]) {
        int values[] = {8,5,3,6,10,11,14};
        Node root = null;
        for(int i = 0; i<values.length ;i++) {
            root = insert(root,values[i]);
        }
        inOrder(root);
        System.out.println();
        /* search
        if(search(root, 6)) {
            System.out.println("found");
        } else {
            System.out.println("Not found");
        }*/
        /*delete 
        delete(root,10);
        System.out.println();
        inOrder(root);
        */
        //printInRange(root, 5, 12);
        //root2LeafPaths(root,new ArrayList<>());
        if(isValidBST(root, null, null)) {
            System.out.println("valid");
        } else {
            System.out.println("in valid");
        }
    }
}