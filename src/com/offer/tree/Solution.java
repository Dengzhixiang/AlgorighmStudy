package com.offer.tree;

import java.util.*;

/**
 * ${TODO}
 *
 * @author dengzx
 * @date 2018/8/20 14:52
 */
public class Solution {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }


    /**
     * 使用两个栈
     * 打印奇数层时，先保存左节点再保存右节点到偶数层栈中；
     * 打印偶数层时，先保存右节点再保存左节点到奇数层栈中
     *
     * @param treeNode
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode treeNode) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (treeNode == null) {
            return list;
        }
        // 当前层数
        int layer = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<>();
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(treeNode);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            ArrayList<Integer> temp;
            // 奇数层
            if (layer % 2 != 0) {
                temp = new ArrayList<>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp.add(node.val);
                        // 当前为奇数层，按左右节点顺序加入偶数层栈中
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
            } else {
                // 偶数层
                temp = new ArrayList<>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        // 当前为偶数层，按右左节点顺序加入奇数层栈中
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
            }
            // 若为非空
            if (!temp.isEmpty()) {
                list.add(temp);
                // 层数++
                layer++;
            }
        }
        return list;
    }

    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
     *
     * @param treeNode
     * @return
     */
    public static ArrayList<ArrayList<Integer>> Print2(TreeNode treeNode) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (treeNode == null) {
            return list;
        }
        ArrayList<Integer> layerList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        // 当前层未打印的节点
        int current = 1;
        // 下一层节点的数量
        int next = 0;

        while (!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            layerList.add(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
                next++;
            }
            if (temp.right != null) {
                queue.add(temp.right);
                next++;
            }
            current--;
            if (current == 0) {
                list.add(layerList);
                layerList = new ArrayList<>();
                current = next;
                next = 0;
            }
        }
        return list;
    }


    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
     * <p>
     * 递归方法
     *
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print3(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if (root == null) return;
        if (depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth - 1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }


    /**
     * 每个节点值以 "," 结尾, 遇到 null 节点以 # 作为区分
     * 算法思想：根据前序遍历规则完成序列化与反序列化。所谓序列化指的是遍历二叉树为字符串；所谓反序列化指的是依据字符串重新构造成二叉树。
     * 依据前序遍历序列来序列化二叉树，因为前序遍历序列是从根结点开始的。当在遍历二叉树时碰到Null指针时，这些Null指针被序列化为一个特殊的字符“#”。
     * 另外，结点之间的数值用逗号隔开
     * 序列化
     *
     * @param root
     * @return
     */
    public static String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    //
    private static int index = -1;

    /**
     * 反序列化
     *
     * @param str
     * @return
     */
    public static TreeNode Deserialize(String str) {
        index++;
        TreeNode head = null;
        String[] temp = str.split(",");
        if (!temp[index].equals("#")) {
            head = new TreeNode(Integer.valueOf(temp[index]));
            head.left = Deserialize(str);
            head.right = Deserialize(str);
        }
        return head;
    }

    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4
     *
     * @param pRoot
     * @param k
     * @return
     */
    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        return KthNodeCore(pRoot, k);
    }

    /**
     * 二叉搜索树的中序遍历为递增序列
     * 遍历过程递减 k， 若 k == 1 则当前节点为目标节点
     *
     * @param pRoot
     * @param k
     * @return
     */
    private static TreeNode KthNodeCore(TreeNode pRoot, int k) {
        TreeNode target = null;
        if (pRoot.left != null) {
            target = KthNodeCore(pRoot.left, k);
        }
        if (target == null) {
            if (k == 1) {
                target = pRoot;
            }
            k--;
        }
        if (target == null && pRoot.right != null) {
            target = KthNodeCore(pRoot.right, k);
        }
        return target;
    }


    /**
     * 数据流的中位数
     * <p>
     * 用两个堆保存数据，保持两个堆的数据保持平衡（元素个数相差不超过1）大顶堆存放的数据要比小顶堆的数据小当两个推中元素为偶数个，将新加入元素加入到大顶堆，如果要加入的数据，比小顶堆的最小元素大，先将该元素插入小顶堆，然后将小顶堆的最小元素插入到大顶堆。当两个推中元素为奇数个，将新加入元素加入到小顶堆，如果要加入的数据，比大顶堆的最大元素小，先将该元素插入大顶堆，然后将大顶堆的最大元素插入到小顶堆。
     *
     * @param num
     */
    public void Insert(Integer num) {

    }

    public Double GetMedian() {
        return null;
    }


    /**
     * 题目：滑动窗口的最大值
     * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
     *     原则：
     *     对新来的元素k，将其与双端队列中的元素相比较
     *     1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
     *     2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
     *     队列的第一个元素是滑动窗口中的最大值
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length < size|| size == 0) {
            return result;
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int begin = 0;
        for (int i = 0; i < num.length; ++i) {
            begin = i - size + 1;
        }
        return null;
    }

}
