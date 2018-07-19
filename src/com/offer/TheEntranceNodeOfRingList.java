package com.offer;

/**
 * 题目描述
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */

/**
 * 解题思路：
 * 定义快慢指针
 * <p>
 * 理论基础：
 * <p>
 * 1）判断一个链表有无环，一个快指针（走 2 步），一个慢指针（走 1 步），都从头开 始，若有环，则它们相撞（设碰撞点为 x）；若无环，则快指针遇到空就跳出循环。
 * <p>
 * 2）有 环，则求环的长度：从碰撞点 x 开始，又走（一个走一步，一个两步），当再次碰撞时，他 们走的次数为环的长度。
 * // 但是可以直接计算长度，不需要快慢指针
 * <p>
 * 3）求连接点，记住结论：碰撞点到连接点的距离等于头接点到连 接点的距离。两个指针（都一次一步），一个从头节点走，一个从碰撞点走，第一次碰撞的 节点就是连接点。
 */
public class TheEntranceNodeOfRingList {

    /**
     * 从碰撞点出发求环长度
     *
     * @param collisionNode
     * @return
     */
    public int calcRingLength(ListNode collisionNode) {
        int count = 1;
        ListNode temp = collisionNode;
        while (temp.getNext() != collisionNode) {
            temp = temp.getNext();
            count++;
        }
        return count;
    }

    /**
     * 快慢指针求碰撞点
     *
     * @param pHead
     * @return 碰撞点 或 null
     */
    public ListNode collisionNode(ListNode pHead) {
        ListNode fastNode = pHead.getNext();
        ListNode slowNode = pHead.getNext().getNext();
        while (fastNode != null && slowNode != null) {
            if (fastNode == slowNode) {
                return fastNode;
            }
            fastNode = fastNode.getNext();
            slowNode = slowNode.getNext().getNext();
        }
        return null;
    }

    /**
     * 1、如果链表中环 有n个结点，指针P1在链表上向前移动n步，然后两个指针以相同的速度向前移动。
     * 2、当第二个指针指向环的入口结点时，第一个指针已经围绕着环走了一圈又回到了入口结点
     * @param pHead
     * @param collisionNode
     * @return
     */
    public ListNode getJoinListNode(ListNode pHead, ListNode collisionNode) {
        int length = calcRingLength(collisionNode);
        ListNode p1 = pHead, p2 = pHead;
        while (length > 0) {
            p1 = p1.getNext();
            length--;
        }
        while (p1 != p2) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        return p1;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.getNext() == null) {
            return null;
        }
        ListNode collisionNode = collisionNode(pHead);
        return collisionNode == null ? null : getJoinListNode(pHead, collisionNode);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }
}