import tree.avl.AVLTree;
import tree.avl.AVLTreeNode;
import tree.binary.BinaryTree;
import tree.binary.BinaryTreeNode;
import tree.binarysearch.BinarySearchTree;
import tree.binarysearch.BinarySearchTreeNode;
import tree.fcns.FCNSTree;
import tree.fcns.FCNSTreeNode;
import tree.normal.NormalTree;
import tree.normal.NormalTreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
//        main.createAndShowAllTreeTypes();
//        main.calculatePostfix("1, 2, *, 3, *");
//        main.calculatePostfix("4, 6, *, 5, +");
//        main.calculatePostfix("6, 5, +, 4, *");
//        main.binarySearchTreeTest();
        main.avlTreeTest();
    }

    private void createAndShowAllTreeTypes() {
        Character a = "A".charAt(0);
        Character b = "B".charAt(0);
        Character c = "C".charAt(0);
        Character d = "D".charAt(0);
        Character e = "E".charAt(0);

        // NormalTree
        NormalTreeNode<Character> normalTreeNodeE = new NormalTreeNode<>(e);
        NormalTreeNode<Character> normalTreeNodeD = new NormalTreeNode<>(d);
        NormalTreeNode<Character> normalTreeNodeC = new NormalTreeNode<>(c);
        NormalTreeNode<Character> normalTreeNodeB = new NormalTreeNode<>(b);
        NormalTreeNode<Character> normalTreeNodeA = new NormalTreeNode<>(a);

        normalTreeNodeC.addChild(normalTreeNodeD);
        normalTreeNodeC.addChild(normalTreeNodeE);
        normalTreeNodeA.addChild(normalTreeNodeB);
        normalTreeNodeA.addChild(normalTreeNodeC);

        NormalTree<Character> normalTree = new NormalTree<>(normalTreeNodeA);
        normalTree.print();
        System.out.println("Tree Size = " + normalTree.getSize());
        System.out.println("Tree Amount of Leaves = " + normalTree.getAmountOfLeaves());
        System.out.println();

        // FCNS NormalTree
        FCNSTreeNode<Character> fcnsTreeNodeE = new FCNSTreeNode<>(e);
        FCNSTreeNode<Character> fcnsTreeNodeD = new FCNSTreeNode<>(d);
        FCNSTreeNode<Character> fcnsTreeNodeC = new FCNSTreeNode<>(c);
        FCNSTreeNode<Character> fcnsTreeNodeB = new FCNSTreeNode<>(b);
        FCNSTreeNode<Character> fcnsTreeNodeA = new FCNSTreeNode<>(a);

        fcnsTreeNodeC.addChild(fcnsTreeNodeD);
        fcnsTreeNodeC.addChild(fcnsTreeNodeE);
        fcnsTreeNodeA.addChild(fcnsTreeNodeB);
        fcnsTreeNodeA.addChild(fcnsTreeNodeC);

        FCNSTree<Character> fcnsTree = new FCNSTree<>(fcnsTreeNodeA);
        fcnsTree.print();
        System.out.println("Tree Size = " + fcnsTree.getSize());
        System.out.println("Tree Amount of Leaves = " + fcnsTree.getAmountOfLeaves());
        System.out.println();

        // Binary NormalTree
        BinaryTreeNode<Character> binaryTreeNodeE = new BinaryTreeNode<>(e);
        BinaryTreeNode<Character> binaryTreeNodeD = new BinaryTreeNode<>(d);
        BinaryTreeNode<Character> binaryTreeNodeC = new BinaryTreeNode<>(c);
        BinaryTreeNode<Character> binaryTreeNodeB = new BinaryTreeNode<>(b);
        BinaryTreeNode<Character> binaryTreeNodeA = new BinaryTreeNode<>(a);

        binaryTreeNodeC.setLeft(binaryTreeNodeD);
        binaryTreeNodeC.setRight(binaryTreeNodeE);
        binaryTreeNodeA.setLeft(binaryTreeNodeB);
        binaryTreeNodeA.setRight(binaryTreeNodeC);

        BinaryTree<Character> binaryTree = new BinaryTree<>(binaryTreeNodeA);
        binaryTree.print();
        System.out.println("Tree Size = " + binaryTree.getSize());
        System.out.println("Tree Amount of Leaves = " + binaryTree.getAmountOfLeaves());
        System.out.println();
    }

    private void binarySearchTreeTest() {
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(root);
        bst.insert(2);
        bst.insert(1);
        bst.insert(6);
        bst.insert(3);
        bst.insert(4);
        bst.print();
        System.out.println("Min = " + bst.findMin());
        System.out.println("Max = " + bst.findMax());
        System.out.println("Find 3 -> " + bst.find(3));

        System.out.println();

        bst.remove(2);
        bst.print();
    }

    private void avlTreeTest() {
        AVLTreeNode<Integer> root = new AVLTreeNode<>(5);
        AVLTree<Integer> avl = new AVLTree<>(root);
        avl.insert(2);
        avl.insert(1);
        avl.insert(6);
        avl.insert(3);
        avl.insert(4);
        avl.print();
        System.out.println("Min = " + avl.findMin());
        System.out.println("Max = " + avl.findMax());
        System.out.println("Find 3 -> " + avl.find(3));

        System.out.println();

        avl.remove(2);
        avl.print();
    }

    private void calculatePostfix(String postfix) {
        System.out.println(postfix);
        BinaryTree<Character> binaryTree = createBinaryTreeFromPostfix(postfix);
        binaryTree.print();
        int output = calculateBinaryTreeFromPostfix(binaryTree);
        System.out.println("Output: " + output);
        System.out.println();
    }

    private BinaryTree<Character> createBinaryTreeFromPostfix(String postfix) {
        StringBuilder sb = new StringBuilder(postfix);
        int delete = sb.indexOf(" ");
        while (delete != -1) {
            sb.deleteCharAt(delete);
            delete = sb.indexOf(" ");
        }

        String[] postfixArray = sb.toString().split(",");
        List<BinaryTreeNode<Character>> nodes = new ArrayList<>();
        for (String chr : postfixArray) {
            nodes.add(new BinaryTreeNode<>(chr.charAt(0)));
        }

        BinaryTreeNode<Character> root = nodes.get(nodes.size() - 1);
        BinaryTreeNode<Character> parent = root;
        for (int i = nodes.size() - 2; i >= 0; i = i - 2) {
            parent.setRight(nodes.get(i));
            parent.setLeft(nodes.get(i - 1));
            parent = nodes.get(i - 1);
        }

        return new BinaryTree<>(root);
    }

    private int calculateBinaryTreeFromPostfix(BinaryTree<Character> binaryTree) {
        return calculatePart(binaryTree.getRoot());
    }

    private int calculatePart(BinaryTreeNode<Character> current) {
        BinaryTreeNode<Character> left = current.getLeft();
        BinaryTreeNode<Character> right = current.getRight();

        if ((left == null) && (right == null)) {
            return Integer.parseInt(current.getValue().toString());
        } else if ((left != null) && (right != null)) {
            int leftValue = calculatePart(left);
            int rightValue = calculatePart(right);

            switch (current.getValue().toString()) {
                case "+":
                    return leftValue + rightValue;
                case "-":
                    return leftValue - rightValue;
                case "*":
                    return leftValue * rightValue;
                case "/":
                    return leftValue / rightValue;
            }
        }
        return 0;
    }
}