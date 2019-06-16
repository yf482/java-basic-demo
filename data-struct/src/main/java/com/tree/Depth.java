package com.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Depth {

    /**
     *  树的高度-使用递归实现
     * @param treeNode
     * @return
     */
    public static int maxDepth(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int left = maxDepth(treeNode.left);
        int right = maxDepth(treeNode.right);
        int result = Math.max(left,right) + 1;
        return result;
    }

    /**
     * 非递归形式求树的高度
     * @param treeNode
     * @return
     */
    public static int maxDie(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
       int level =0 ;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(treeNode);

        while(!queue.isEmpty()){
            level++;
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }

        return level;
    }

    /**
     * 求最小深度
     *
     * @param treeNode
     * @return
     */
    public static int minDepth(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        if(treeNode.left == null && treeNode.right == null){
            return 1;
        }
        if(treeNode.left == null && treeNode.right != null){
            return minDepth(treeNode.right) + 1;
        }
        if(treeNode.right == null && treeNode.left != null){
            return minDepth(treeNode.left) + 1;
        }
        int left = minDepth(treeNode.left);
        int right = maxDepth(treeNode.right);
        return Math.min(left,right) + 1;
    }


    public static int minDepth2(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int level =0 ;
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(treeNode);

        while(!queue.isEmpty()){
            level++;
            int levelSize = queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null ){
                    return level;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return 0;
    }

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

        Depth depth = new Depth();
        System.out.println("depth = " + maxDepth(A));
        System.out.println("depth = " + maxDie(A));
        System.out.println("depth = " + minDepth(A));//有问题
        System.out.println("depth = " + minDepth2(A));
        //4 4 3 3

    }


}
