package dsa.binayTree.traversal;


import dsa.util.Print;
import dsa.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    //             1
//            / \
//           2   3
//         /  \
//        4    5
//            / \
//           6   7
//    Left Right Node -> 4 6 7 5 2 3 1
    public static List<Integer> postorder2Stack(TreeNode node) {
        List<Integer> postorder = new ArrayList<>();
        if (node == null) return postorder;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node);

        while (!stack1.isEmpty()) {
//            remove node from stack1
            node = stack1.pop();
//            add node in stack2
            stack2.push(node);
//            if node has left and right push it in stack1
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

//        pop elements from stack to get postorder
        while (!stack2.isEmpty()) {
            postorder.add(stack2.pop().val);
        }
        return postorder;
    }

//    public static List<Integer> postorder1Stack(TreeNode node) {
//        List<Integer> postorder = new ArrayList<>();
//        if (node == null) return postorder;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(node);
//
//        while (node != null || !stack.isEmpty()) {
//
//        }
//
//        return postorder;
//    }

    private static void solve(Integer[] levelOrder) {
        TreeNode root = TreeNode.createBinaryTreeViaLevelOrder(levelOrder);
        System.out.println("INPUT: ");
        Print.printTree(root);
        System.out.println("POSTORDER: " + postorder2Stack(root) + "\n\n");
    }

    public static void main(String[] args) {
        Integer[] levelOrder = {1, 2, 3, 4, 5, null, null, null, null, 6, 7};
        solve(levelOrder);

        levelOrder = new Integer[]{};
        solve(levelOrder);

        levelOrder = new Integer[]{2, null, 3};
        solve(levelOrder);
    }

}
