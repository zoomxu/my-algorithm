package com.example.demo.tree;

/**
 * hard
 * 124. 二叉树中的最大路径和
 */
public class Code241 {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        /**
         * Q：左右孩子贡献为什么要大于等于0？
         * A: 因为计算从某一节点出发的路径和的时候，计算公式为： 当前节点值 + 左孩子贡献 + 右孩子贡献，
         * 而左右孩子贡献是「可选的」，也就是说当某一边贡献小于0的时候，我可以在计算路径和时不算这一边
         * 这种情况也就相当于其贡献为 0，但是注意路径和至少包含「当前节点的值」。
         */

        // 递归左子树
        int leftMax = Math.max(0, dfs(root.left));
        // 递归右子树
        int rightMax = Math.max(0, dfs(root.right));
        // 更新res, res结果
        res = Math.max(res, leftMax + rightMax + root.val);
        // 对上层的贡献，只能走左 或 右
        return root.val + Math.max(leftMax, rightMax);
    }
}
