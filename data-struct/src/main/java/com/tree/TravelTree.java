package com.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class TravelTree {
    /**
     * A
     * B      C
     * D   E   F   G
     * H  I    J   K
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode A = new TreeNode("A");
        TreeNode B = new TreeNode("B");
        TreeNode C = new TreeNode("C");
        TreeNode D = new TreeNode("D");
        TreeNode E = new TreeNode("E");
        TreeNode F = new TreeNode("F");
        TreeNode G = new TreeNode("G");
        TreeNode H = new TreeNode("H");
        TreeNode I = new TreeNode("I");
        TreeNode J = new TreeNode("J");
        TreeNode K = new TreeNode("K");

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;

        D.left = H;
        D.right = I;

        E.right = J;
        C.left = F;
        C.right = G;
        F.right = K;

        preOrder(A);
        System.out.println();
        inOrder(A);
        System.out.println();
        postOrder(A);
        System.out.println();
        levelOrder(A);


    }

    /**
     * 非递归形式-前序遍历，使用栈进行遍历
     * @param treeNode
     */
    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            throw new RuntimeException("error");
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(" " + node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }
    /**
     * 非递归形式-中序遍历，使用栈进行遍历
     * @param treeNode
     */
    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            throw new RuntimeException("error");
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() && treeNode != null) {
            if(treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }else {
                TreeNode node = stack.pop();
                System.out.print(" " + node.value);
                treeNode = treeNode.right;
            }
        }

    }


    /**
     * 非递归形式-后序遍历，使用栈进行遍历
     * @param head
     */
    public static void postOrder(TreeNode head) {
        if (head == null) {
            throw new RuntimeException("error");
        }
        //使用两个栈更方便些，一个栈也可以
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(head);
        while (!stack1.isEmpty()) {
            TreeNode node  = stack1.pop();
            stack2.push(node);
            if(node.left != null){
                stack1.push(node.left);
            }
            if(node.right != null){
                stack1.push(node.right);
            }
        }

        while(!stack2.isEmpty()){
            TreeNode node = stack2.pop();
            System.out.print(" " + node.value);
        }

    }

    /**
     * 层次遍历
     * @param head
     */
    public static void levelOrder(TreeNode head) {
        if (head == null) {
            throw new RuntimeException("error");
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(head);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            for(int i=0;i<levelNum;i++){
                TreeNode poll = queue.poll();
                System.out.print(" " + poll.value);
                if(poll.left !=null ){
                    queue.offer(poll.left);
                }
                if(poll.right !=null ){
                    queue.offer(poll.right);
                }
            }
        }


    }

}
