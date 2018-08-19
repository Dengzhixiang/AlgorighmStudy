package com.offer;

public class IsSymmetrical {
    /**
     * 对称二叉树
     * 比较二叉树的前序遍历以及其对称的前序遍历序列是否相等
     *
     * 注：前序遍历是： 根 左 右
     *     对称的前序遍历是：根 右 左
     *     只需遍历时调换左右子树的顺序即可
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetric(pRoot, pRoot);
    }
    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}