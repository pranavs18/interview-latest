import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

public class bfs {

    public static TreeNode populateNextPointers(TreeNode root) {
        if(root == null) {
            return root;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        q.add(null);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp != null) {
                temp.next = q.peek();
                if (temp.left != null) {
                    q.add(temp.left);
                }

                if (temp.right != null) {
                    q.add(temp.right);
                }

            } else {
                if(!q.isEmpty()) {
                    q.add(null);
                }
            }
        }

        return root;
    }

    public static void main(String args[]){

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        // root.right.left.left = new TreeNode(5);

        populateNextPointers(root);
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode next;
    int data;

    public TreeNode(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}