package com.tree;

public class LowerAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){
        if(root == null || root ==p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        return left != null ? left : right;
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

        TreeNode node = lowestCommonAncestor(A,B,F);
        System.out.println("node = " + node.value);

    }
}
