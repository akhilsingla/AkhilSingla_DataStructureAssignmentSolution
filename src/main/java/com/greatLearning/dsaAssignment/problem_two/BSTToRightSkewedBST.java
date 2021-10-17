package com.greatLearning.dsaAssignment.problem_two;

/*
    class to convert BST to Right Skewed BST and print the same
 */
public class BSTToRightSkewedBST {
    /*
        declare variables
        ancestorNode of SkewedBST
        rootNodeOfSkewedBST is root Node of Skewed Node
     */
    private Node ancestorNode = null;
    private Node rootNodeOfSkewedBST = null;

    //convert BST to right skewed BST and print the same
    public void convertBSTToRightSkewedBSTAndPrint(Node rootNode) {
        performConversion(rootNode);
        printSkewedBST();
    }

    /*function to preform BST to right skewed BST
        using recursion for conversion
        for ascending order we first traverse left node and then attach root node and then traverse right node to generate right Skewed BST
     */
    private void performConversion(Node rootNode) {
        //base condition is root node is null return
        if (rootNode == null)
            return;
        //traverse all left nodes
        performConversion(rootNode.getLeftChild());

        /*  if rootnode of skewed BST is null
            initialize both rootNodeOfSkewedBST and ancestorNode
            also assign left node of rootNodeOfSkewedBST to null, since in case of right Skewed BST there is no left child
         */
        if (rootNodeOfSkewedBST == null) {
            rootNodeOfSkewedBST = rootNode;
            rootNodeOfSkewedBST.setLeftChild(null);
            ancestorNode = rootNode;
        }
        /*
            if rootnode of skewed BST is not null
            set ancestorNode right node to root node
            root node left child to null, since in case of right Skewed BST there is no left child
            reassign ancestor node to root node
         */
        else {
            ancestorNode.setRightChild(rootNode);
            rootNode.setLeftChild(null);
            ancestorNode = rootNode;
        }

        //perform conversion for right child of root node
        performConversion(rootNode.getRightChild());
    }

    //print right skewed BST
    private void printSkewedBST() {
        //if root node of skewed tree is null, print appropriate message
        if (rootNodeOfSkewedBST == null)
            System.out.println("Tree is empty, nothing to print, Bye!!!");

        //assign nextNode to root node
        Node nextNode = rootNodeOfSkewedBST;
        //loop through all the right node till null is found and print the same
        while (nextNode != null) {
            System.out.print(nextNode.getData());
            nextNode = nextNode.getRightChild();
            //if next node is not null print "->", skip for last node
            if (nextNode != null)
                System.out.print(" -> ");
        }
    }
}
