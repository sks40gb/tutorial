package programs.recursive;

import programs.binarytree.Node;
import programs.binarytree.BinarySearchTree;
import programs.binarytree.BinaryTreePrinter;

public class HeightOfTree {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(8);
        tree.insert(4);
        tree.insert(6);
        tree.insert(9);
        tree.insert(1);
        tree.insert(10);
        BinaryTreePrinter.printNode(tree.root);
        System.out.println("Height of tree is " + heightOfTree(tree.root));

    }

    private static int heightOfTree(Node<Integer> node){
        if(node == null){
            return 0;
        }
        int leftMax = heightOfTree(node.left);
        int rightMax = heightOfTree(node.right);
        return 1 + Math.max(leftMax, rightMax);
    }
}
