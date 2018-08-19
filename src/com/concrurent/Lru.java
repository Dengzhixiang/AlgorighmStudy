package com.concrurent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * ${TODO}
 * LRU算法，最近最久未使用
 * 基本思路:
 * 使用 双向链表 + HashMap实现
 * 访问某个节点时，将其从原来位置删除，并将其添加到链表头部，保证链表尾部是最近最久未使用的节点
 * 为了使用删除操作时间复杂度为O(1)，使用HashMap存储Key到节点的映射关系
 *
 * @author dengzx
 * @date 2018/8/18 15:49
 */
public class Lru<K, V> implements Iterable<K> {

    private Node head;
    private Node tail;
    private HashMap<K, Node> map;
    private int maxSize;

    private class Node {
        Node pre;
        Node next;
        K k;
        V v;

        Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public Lru(int maxSize) {
        this.maxSize = maxSize;
        // HashMap 负载容量为 0.75
        this.map = new HashMap<>(maxSize * 4 / 3);

        head = new Node(null, null);
        tail = new Node(null, null);

        head.next = tail;
        tail.pre = head;
    }

    /**
     * 将其删除，并添加至链表头部
     * @param key
     * @return
     */
    public V get(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node node = map.get(key);
        unlink(node);
        appendHead(node);
        return node.v;
    }

    public void put(K k, V v) {
        if (map.containsKey(k)) {
            Node node = map.get(k);
            unlink(node);
        }
        Node node = new Node(k, v);
        map.put(k, node);
        appendHead(node);
        if (map.size() > maxSize) {
            Node toRemove = remoteTail();
            map.remove(toRemove.k);
        }
    }

    private Node remoteTail() {
        Node node = tail.pre;
        node.pre = tail;
        return node;
    }

    /**
     * 添加到头部
     * @param node
     */
    private void appendHead(Node node) {
        node.next = head.next;
        head.next = node;
    }

    /**
     * 删除该节点
     * @param node
     */
    private void unlink(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

}
