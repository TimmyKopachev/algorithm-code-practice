package org.dzmitry.kapachou.graph.bfs;

import lombok.ToString;

public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        var tl3 = new TreeNode(11);
        tl3.setLeft(new TreeNode(7));
        tl3.setRight(new TreeNode(2));


        var tl2 = new TreeNode(4);
        tl2.setLeft(tl3);
        root.setLeft(tl2);

        var tr3 = new TreeNode(8);
        tr3.setLeft(new TreeNode(13));
        tr3.setRight(new TreeNode(4).setRight(new TreeNode(1)));
        root.setRight(tr3);

        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private static boolean dfs(TreeNode node, int current, int targetSum) {
        if (node == null) return false;
        current += node.val;
        if (node.left == null && node.right == null) return current == targetSum;
        return dfs(node.left, current, targetSum) || dfs(node.right, current, targetSum);
    }

    @ToString
    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode setLeft(TreeNode node) {
            this.left = node;
            return node;
        }

        public TreeNode setRight(TreeNode node) {
            this.right = node;
            return node;
        }

    }
}
