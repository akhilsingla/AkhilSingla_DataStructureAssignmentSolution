package com.greatLearning.dsaAssignment.problem_two;

/*
    Main driver class
 */
public class MainDriver {
    public static void main(String args[]) {
        /*create a tree
                 50
                /  \
               30   60
              /     /
             10    55
         */
        Node rootNode = new Node(50);
        //construct left tree of root node
        rootNode.setLeftChild(new Node(30));
        rootNode.getLeftChild().setLeftChild(new Node(10));

        //construct right tree of root node
        rootNode.setRightChild(new Node(60));
        rootNode.getRightChild().setLeftChild(new Node(55));

        //convert BST to right skewed BST and print the same
        new BSTToRightSkewedBST().convertBSTToRightSkewedBSTAndPrint(rootNode);

    }
}
