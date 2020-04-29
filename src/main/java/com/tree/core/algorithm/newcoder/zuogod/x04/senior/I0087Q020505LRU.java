package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import lombok.AllArgsConstructor;

import java.util.HashMap;

/**
 * 设计可以变更的缓存结构(LRU)
 *
 * 【题目】
 * 设计一种缓存结构,该结构在构造时确定大小,假设大小为K,并有两个功能:
 * set(key,value):将记录(key,value)插入该结构。
 * get(key):返回key对应的value值。
 * 【要求】
 * 1.set和get方法的时间复杂度为O(1)。
 * 2.某个key的set或get操作一旦发生,认为这个key的记录成了最经常使用的。
 * 3.当缓存的大小超过K时,移除最不经常使用的记录,即set或get最久远的。
 *
 * 【举例】
 * 假设缓存结构的实例是cache,大小为3,并依次发生如下行为:
 * 1.cache.set("A",1)。最经常使用的记录为("A",1)。
 * 2.cache.set("B",2)。最经常使用的记录为("B",2),("A",1)变为最不经常的。
 * 3.cache.set("C",3)。最经常使用的记录为("C",2),("A",1)还是最不经常的。
 * 4.cache.get("A")。最经常使用的记录为("A",1),("B",2)变为最不经常的。
 * 5.cache.set("D",4)。大小超过了3,所以移除此时最不经常使用的记录("B",2),
 * 加入记录 ("D",4),并且为最经常使用的记录,然后("C",2)变为最不经常使用的记录
 */
public class I0087Q020505LRU {

    private int capacity = 0;
    private int size;
    private HashMap<String, Node> map = new HashMap<>();
    private NodeList deque = new NodeList();

    public String put(String key, String value){
        String oldValue = null;
        Node oldNode = map.get(key);
        if (oldNode != null){
            oldValue = oldNode.value;
            oldNode.value = value;
            deque.moveToTail(oldNode);
            return oldValue;
        }
        Node newNode = new Node(key, value, null, null);
        if (size == capacity){
            Node poll = deque.poll();
            map.remove(poll.key);
        }
        map.put(key, newNode);
        deque.offer(newNode);
        size++;
        return null;
    }

    public String get(String key){
        Node node = map.get(key);
        if (node == null){
            return null;
        }
        deque.moveToTail(node);
        return node.value;
    }

    private class NodeList{
        Node head;
        Node tail;
        public void offer(Node node){
            if (head == null){
                head = tail = node;
            }else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        public Node poll(){
            if (head == null){
                return null;
            }
            Node res = head;
            head = head.next;
            if (head != null){
                head.prev = null;
            }
            res.next = null;
            return res;
        }

        public void moveToTail(Node node){
            if (node == tail){
                return;
            }else if (node == head){
                head = head.next;
                head.prev = null;
            }else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.prev = tail;
            tail.next = node;
            node.next = null;
            tail = node;
        }

    }

    @AllArgsConstructor
    private class Node{
        String key;
        String value;
        Node prev;
        Node next;
    }
    
}
