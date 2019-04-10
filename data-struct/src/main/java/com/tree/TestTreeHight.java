package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestTreeHight {

    public static void main(String[] args) {


    }

    public int calcTreeHight(Tree tree){

        int leftHight = 0;
        int rightHight = 0 ;
        int d ;
        if(tree == null){
            d = -1;
        }else {
            leftHight = calcTreeHight(tree.getLeft());
            rightHight = calcTreeHight(tree.getRight());
        }
        d = 1 + (leftHight > rightHight ? leftHight: rightHight);
        return d;
    }

    public int treeDepth(Tree root) {
        if(root==null){
            return 0;
        }
        int height=0;
        Stack<Tree> nodes=new Stack<Tree>();
        Stack<Integer> tag=new Stack<Integer>();
        while(root!=null||!nodes.isEmpty()){
            while(root!=null){
                nodes.push(root);
                tag.push(0);
                root=root.getLeft();
            }
            if(tag.peek()==1){
                height=Math.max(height, nodes.size());
                nodes.pop();
                tag.pop();
                root=null;
            }else{
                root=nodes.peek();
                root=root.getRight();
                tag.pop();
                tag.push(1);
            }
        }
        return height;
    }
    public static int getHeight(Tree root) {
        if (root == null) {
            return 0;
        }
        Queue<Tree> queue = new LinkedList<Tree>();
        queue.add(root);
        int height = 1;
        while (!queue.isEmpty()) {
            Tree node = queue.peek();
            if (node.left == null && node.right == null) {
                break;
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                queue.poll();
                height++;
            }

            //System.out.println(height);

        }
        return height;
    }
}

class Tree {
    public Tree left;
    public Tree right;
    private int nodeValue;
    private int hight;

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public int getNodeValue() {
        return nodeValue;
    }

    public void setNodeValue(int nodeValue) {
        this.nodeValue = nodeValue;
    }
}
