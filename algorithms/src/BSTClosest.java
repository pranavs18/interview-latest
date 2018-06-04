public class BSTClosest {
    /*

    A simple solution for this problem is to store Inorder traversal of given binary search tree
    in an auxiliary array and then by taking absolute difference of each element find the node having
     minimum absolute difference with given target value K in linear time

    Can we do better ?

    Hint: Use BST properties and optimize the search space
     */

    int min;
    int goal;

    public BSTClosest() {
        min = Integer.MAX_VALUE;
        goal = Integer.MAX_VALUE;
    }

    public int findBSTClosest(Tree root, int K) {

        if(root == null) {
            return Integer.MIN_VALUE;
        }

        findClosest(root, K);
        return goal;
    }

    private void findClosest(Tree root, int K) {
        if(root == null) {
            return;
        }

        if(Math.abs(root.val - K) < min) {
            goal = root.val;
            min = Math.abs(root.val - K);
            if(min == 0){
                return;
            }
        }


        if(K < root.val) {
            findClosest(root.left, K);
        }

        else findClosest(root.right, K);

    }

    private static void printTree(Tree root){
        if(root == null)
            return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String args[]) {
        Tree root = new Tree(9);
        root.left = new Tree(4);
        root.right = new Tree(17);
        root.left.left = new Tree(3);
        root.left.right = new Tree(6);
        root.right.right = new Tree(22);

        printTree(root);

        BSTClosest bst = new BSTClosest();
        System.out.println(bst.findBSTClosest(root, 4));

        bst = new BSTClosest();
        System.out.println(bst.findBSTClosest(root, 18));

        bst = new BSTClosest();
        System.out.println(bst.findBSTClosest(root, 12));

    }
}

class Tree {
    Tree left;
    Tree right;
    int val;

    public Tree(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}