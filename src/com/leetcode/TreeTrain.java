package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 〈Leetcode 初级算法训练 -> 树训练〉
 *
 * @author Administrator
 * @create 2018/7/5
 * @since 1.0.0
 */
public class TreeTrain {

    /**
     * 二叉树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return left > right ? left + 1 : right + 1;
    }

    /**
     * 验证二叉搜索树
     * 注意：左子树的所有节点都要比根节点小，而非只是其左孩子比其小，右子树同样。所以判断左右孩子是BST，并不能证明整棵树就是BST。
     * 思路：从根节点开始递归，遍历所有的节点。并且在每个节点处，分别遍历其左右子树，判断其左子树的最大值比其小，右子树的最小值比其大。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isVaildBSTCore(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isVaildBSTCore(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        if (root.val >= high || root.val <= low) {
            return false;
        }
        return isVaildBSTCore(root.left, low, root.val) && isVaildBSTCore(root.right, root.val, high);
    }


    /**
     * 对称二叉树
     * 比较二叉树的前序遍历以及其对称的前序遍历序列是否相等
     * <p>
     * 注：前序遍历是： 根 左 右
     * 对称的前序遍历是：根 右 左
     * 只需遍历时调换左右子树的顺序即可
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root, root);
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

    /**
     * 二叉树的层级遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add() 该方法会抛出异常
        queue.offer(root);
        int nextLevel = 0; // 下一层节点的数目
        int toBePrinted = 1; // 当前层还未打印的节点数目
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll(); // 返回第一个元素并在队列中删除
            temp.add(current.val);
            if (current.left != null) {
                queue.offer(current.left);
                nextLevel++;
            }
            if (current.right != null) {
                queue.offer(current.right);
                nextLevel++;
            }
            --toBePrinted;
            if (toBePrinted == 0) {
                result.add(temp);
                temp = new ArrayList<>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
        return result;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void main(String[] args) {
        String s = "s";
        String t = "t";
        System.out.println(s.hashCode() == t.hashCode());
//         Arrays.copyOf()
    }

    @Override
    public boolean equals(Object orderObjec) {
        if (this == orderObjec) {
            return true;
        }
        if (orderObjec == null) {
            return false;
        }
        if (!(orderObjec instanceof TreeNode)) {
            return false;
        }
        TreeNode order = (TreeNode) orderObjec;
        return this.val == order.val;
    }
}