package com.offer;

/*
题目描述
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteRepeatNodeOfSortList {


    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(4);
        ListNode p6 = new ListNode(4);
        ListNode p7 = new ListNode(5);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        new DeleteRepeatNodeOfSortList().deleteDuplication(p1);
    }


    /**
     * 删除重复结点
     * 链表-1->1->2->3->3->4->4->5 处理后为 0->1->2->5
     * 1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
     * 2.设置 pre ，last 指针， pre指针指向当前确定不重复的那个节点，而last指针相当于工作指针，一直往后面搜索。
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode pre = head;
        ListNode last = head.next;
        while (last != null) {
            if (last.next != null && last.val == last.next.val) {
                // 找到最后一个相同的节点
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                pre.next = last.next;
                last = last.next;
            } else {
                pre = pre.next;
                last = last.next;
            }
        }
        return head.next;
    }
}
