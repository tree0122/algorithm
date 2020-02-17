package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import lombok.AllArgsConstructor;

import java.util.HashMap;

/**
 * 上一题实现了LRU缓存算法,LFU也是一个著名的缓存算法
 * 自行了解之后实现LFU中的set 和 get
 *
 * 要求:两个方法的时间复杂度都为O(1)
 */
public class I0088Q020601LFUCache {

    private int capacity = 0;
    private int size;
    private HashMap<String, Node> map = new HashMap<>();
    private HashMap<String, NodeList> headMap = new HashMap<>();
    private NodeList headList = new NodeList();

    public String put(String key, String value){
        Node node = map.get(key);
        if (node != null){
            String oldValue = node.value;
            node.value = value;
            node.times++;
            moveToRightNodeList(node);
            return oldValue;
        }
        Node newNode = new Node(key, value, 1, null, null);
        if (size == capacity){
            Node delNode = headList.poll();
            modifyHeadList(headList);
            headMap.remove(delNode.key);
            map.remove(delNode.key);
            size--;
        }
        if (headList == null){
            headList = new NodeList();
            headList.offer(newNode);
        }else if (headList.head.times == newNode.times){
            headList.offer(newNode);
        }else {
            NodeList newList = new NodeList();
            newList.offer(newNode);
            newList.right = headList;
            headList.left = newList;
            headList = newList;
        }
        size++;
        map.put(key, newNode);
        headMap.put(key, headList);
        return null;
    }

    public String get(String key){
        Node node = map.get(key);
        if (node == null){
            return null;
        }
        node.times++;
        moveToRightNodeList(node);
        return node.value;
    }

    private void moveToRightNodeList(Node node){
        NodeList oldList = headMap.get(node.key);
        oldList.remove(node);
        NodeList preList = modifyHeadList(oldList) ? oldList.left : oldList;
        NodeList rightList = oldList.right;
        if (rightList == null){
            rightList = new NodeList();
            rightList.offer(node);
            rightList.left = preList;
            if (preList != null){
                preList.right = rightList;
            }
            if (headList == null){
                headList = rightList;
            }
        }else if (rightList.head.times == node.times){
            rightList.offer(node);
        }else {
            NodeList newList = new NodeList();
            newList.offer(node);
            newList.right = rightList;
            rightList.left = newList;
            newList.left = preList;
            if (preList != null){
                preList.right = newList;
            }
            if (headList == rightList){
                headList = newList;
            }
        }
        headMap.put(node.key, rightList);
    }

    private boolean modifyHeadList(NodeList nodeList) {
        if (nodeList.head != null){
            return false;
        }
        if (nodeList == headList){
            headList = headList.right;
            if (headList != null){
                headList.left = null;
            }
        }else {
            nodeList.left.right = nodeList.right;
            if (nodeList.right != null){
                nodeList.right.left = nodeList.left;
            }
        }
        return true;
    }

    private class NodeList{
        Node head;
        Node tail;
        NodeList left;
        NodeList right;
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

        public void remove(Node node) {
            if (head == tail){
                head = tail = null;
            }else if (node == head){
                head = head.next;
                head.prev = null;
            }else if (node == tail){
                tail = tail.prev;
                tail.next = null;
            }else {
                node.next.prev = node.prev;
                node.prev.next = node.next;
            }
            node.prev = node.next = null;
        }
    }

    @AllArgsConstructor
    private class Node{
        String key;
        String value;
        int times;
        Node prev;
        Node next;
    }

}
