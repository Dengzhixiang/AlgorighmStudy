package com.leetcode;

/**
 * 〈Leetcode 初级算法训练 -> 链表〉
 *
 * @author Administrator
 * @create 2018/6/25
 * @since 1.0.0
 */
public class ListTrain {
    /**
     * 删除链表倒数第N个节点
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * 给定的 n 保证是有效的。
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
     * <p>
     * 解法1：
     * 先遍历，得出长度 L。
     * 再遍历一次删除第 L - k + 1 个节点
     * 解法2:
     * 定义两个指针，指针只差为 N-1，当第一个指针到达末尾，第二个指针为要删除的节点
     * 1、定义一个指向头结点的指针
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return null;
        }
        ListNode del = new ListNode(0);
        del.next = head;
        ListNode temp = del;
        for (int i = 0; i < n; ++i) {
            head = head.next;
        }
        while (head != null) {
            temp = temp.next;
            head = head.next;
        }
        temp.next = temp.next.next;
        return del.next;
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return head.next;
    }


    /**
     * 删除链表中的结点
     * <p>
     * 解法：
     * 将给定节点的下一节点删除，并将其值赋值给给定节点。
     * 1 -> 2 -> 3 -> 4 -> 5
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode reversedhead = null; // 反转链表的头结点，为原始链表的尾节点
        ListNode node = head; // 当前节点
        ListNode prev = null; // 当前节点的前一个节点
        while (node != null) {
            if (node.next == null) {
                reversedhead = node;
            }
            ListNode next = node.next; // 当前节点的后一个节点
            node.next = prev;
            prev = node;
            node = next;
        }
        return reversedhead;
    }

    /**
     * 递归 合并排序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsTwo(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode merge = null;
        if (l1.val < l2.val) {
            merge = l1;
            merge.next = mergeTwoListsTwo(l1.next, l2);
        } else {
            merge = l2;
            merge.next = mergeTwoListsTwo(l1, l2.next);
        }
        return merge;
    }

    /**
     * 判断是否为回文链表
     * <p>
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        int length = 0;
        ListNode node = head, prev = null, next = null;
        while (head != null) {
            head = head.next;
            length++;
        }
        for (int i = 0; i < length / 2; ++i) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        if (length % 2 == 1) {
            next = node.next;
        }
        while (prev != null && next != null) {
            if (prev.val != next.val) {
                return false;
            }
            prev = prev.next;
            next = next.next;
        }
        return true;
    }

    /**
     * 给定一个链表，判断链表中是否有环。
     * <p>
     * 进阶：
     * 你能否不使用额外空间解决此题？
     * 解法：
     * 快慢指针，若有环必相遇
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode quick = head, slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode temp1 = new ListNode(1);
//        ListNode temp2 = new ListNode(2);
//        ListNode temp3 = new ListNode(1);
//        ListNode temp4 = new ListNode(2);
//        temp1.next = temp2;
//        temp2.next = temp3;
//        temp3.next = temp4;
        System.out.println(hasCycle(temp1));
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}