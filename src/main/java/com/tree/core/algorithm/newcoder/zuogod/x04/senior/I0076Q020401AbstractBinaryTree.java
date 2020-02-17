package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树
 * todo
 */
public class I0076Q020401AbstractBinaryTree {

    public abstract class SearchTree<T extends Node, K extends Comparable<K>>{
        protected int size;

        public abstract T select(K key);

        public abstract void insert(K key);

        public abstract void delete(K key);

        public abstract T first();

        public abstract T last();

        public abstract T ceiling(K key);

        public abstract T floor(K key);

        public abstract T successor(T head);

        public abstract T predecessor(T head);

        public abstract T createNode(K key);

        public int size(){
            return size;
        }
    }

    public abstract class BinarySearchTree<T extends BSTNode<T, K>, K extends Comparable<K>> extends SearchTree<T, K>{
        protected T root;

        @Override
        public T select(K key) {
            if (key == null){
                return null;
            }
            T cur = this.root;
            while (cur != null && !cur.isKeyEqual(key)){
                if (cur.isKeyMore(key)){
                    cur = cur.left;
                }else {
                    cur = cur.right;
                }
            }
            return cur;
        }

        @Override
        public void insert(K key) {
            if (key == null){
                return;
            }
            T newNode = createNode(key);
            if (root == null){
                size++;
                root = newNode;
                return;
            }
            T cur = this.root;
            T insertParent = this.root;
            while (cur != null && !cur.isKeyEqual(key)){
                insertParent = cur;
                if (cur.isKeyMore(key)){
                    cur = cur.left;
                }else {
                    cur = cur.right;
                }
            }
            if (cur != null){
                return;
            }
            if (insertParent.isKeyMore(key)){
                insertParent.left = newNode;
            }else {
                insertParent.right = newNode;
            }
            size++;
            //更新新节点的其他属性
            otherPropertyAfterInsert(newNode, insertParent);
            //插入后的调整
            fixAfterInsert(newNode);
        }

        @Override
        public void delete(K key) {
            T delNode = select(key);
            if (delNode == null){
                return;
            }
            size--;
            T successor = null;
            if (delNode.left != null && delNode.right != null){
                successor = successor(delNode);
            }
            T replace = delNode.left != null ? delNode.left : delNode.right;
            otherPropertyAfterDelete(delNode, successor, replace);
            fixAfterDelete(delNode, successor, replace);
        }

        @Override
        public T first() {
            if (root == null){
                return null;
            }
            T cur = this.root;
            while (cur.left != null){
                cur = cur.left;
            }
            return cur;
        }

        @Override
        public T last() {
            if (root == null){
                return null;
            }
            T cur = this.root;
            while (cur.right != null){
                cur = cur.right;
            }
            return cur;
        }

        @Override
        public T ceiling(K key) {
            if (key == null || root == null){
                return null;
            }
            T cur = this.root;
            T ans = null;
            while (cur != null){
                if (cur.isKeyEqual(key)){
                    return cur;
                }
                if (cur.isKeyMore(key)){
                    ans = cur;
                    cur = cur.left;
                }else {
                    cur = cur.right;
                }
            }
            return ans;
        }

        @Override
        public T floor(K key) {
            if (key == null || root == null){
                return null;
            }
            T cur = this.root;
            T ans = null;
            while (cur != null){
                if (cur.isKeyMore(key)){
                    return cur;
                }
                if (cur.isKeyMore(key)){
                    cur = cur.left;
                }else {
                    ans = cur;
                    cur = cur.right;
                }
            }
            return ans;
        }

        @Override
        public T successor(T head) {
            if (head == null){
                return null;
            }
            if (head.right != null){
                return min(head.right);
            }
            T ans = null;
            T pre = null;
            T cur = root;
            T mostRightInLeft = null;
            while (cur != null){
                mostRightInLeft = cur.left;
                if (mostRightInLeft != null){
                    while (mostRightInLeft.right != null && mostRightInLeft.right != cur){
                        mostRightInLeft = mostRightInLeft.right;
                    }
                    if (mostRightInLeft.right == null){
                        mostRightInLeft.right = cur;
                        cur = cur.left;
                        continue;
                    }else {
                        mostRightInLeft.right = null;
                    }
                }
                if (pre == head){
                    ans = cur;
                }
                pre = cur;
                cur = cur.right;
            }
            return ans;
        }

        @Override
        public T predecessor(T head) {
            if (head == null){
                return null;
            }
            if (head.left != null){
                return max(head.left);
            }
            T ans = null;
            T pre = null;
            T cur = this.root;
            T mostRightInLeft = null;
            while (cur != null){
                mostRightInLeft = cur.left;
                if (mostRightInLeft != null){
                    while (mostRightInLeft.right != null && mostRightInLeft.right != cur){
                        mostRightInLeft = mostRightInLeft.right;
                    }
                    if (mostRightInLeft.right == null){
                        mostRightInLeft.right = cur;
                        cur = cur.left;
                        continue;
                    }else {
                        mostRightInLeft.right = null;
                    }
                }
                if (cur == head){
                    ans = pre;
                }
                pre = cur;
                cur = cur.right;
            }
            return ans;
        }

        public T max(T head) {
            if (head == null){
                return null;
            }
            T cur = head;
            while (cur.right != null){
                cur = cur.right;
            }
            return cur;
        }

        public T min(T head) {
            if (head == null){
                return null;
            }
            T cur = head;
            while (cur.left != null){
                cur = cur.left;
            }
            return cur;
        }

        protected abstract void otherPropertyAfterInsert(T newNode, T parent);

        protected abstract void fixAfterInsert(T newNode);

        protected abstract void otherPropertyAfterDelete(T delNode, T successor, T replace);

        protected abstract void fixAfterDelete(T delNode, T successor, T replace);

    }

    public abstract class SelfBalanceBinarySearchTree<T extends BSTNode<T, K>, K extends Comparable<K>> extends BinarySearchTree<T, K>{

        public T rotateRight(T head) {
            T newHead = head.left;
            head.left = newHead.right;
            newHead.right = head;
            otherPropertyAfterRotate(head, newHead, head.left);
            return newHead;
        }

        public T rotateLeft(T head) {
            T newHead = head.right;
            head.right = newHead.left;
            newHead.left = head;
            otherPropertyAfterRotate(head, newHead, head.right);
            return newHead;
        }

        protected abstract void otherPropertyAfterRotate(T oldHead, T newHead, T child);
    }

    public class AVLTree<K extends Comparable<K>> extends SelfBalanceBinarySearchTree<AVLNode<K>, K> {
        @Override
        public AVLNode<K> predecessor(AVLNode<K> head) {
            if (head == null){
                return null;
            }
            if (head.left != null){
                return max(head.left);
            }
            AVLNode<K> parent = head.parent;
            while (parent != null && parent.right != head){
                head = parent;
                parent = parent.parent;
            }
            return parent;
        }

        @Override
        public AVLNode<K> successor(AVLNode<K> head) {
            if (head == null){
                return null;
            }
            if (head.right != null){
                return min(head.right);
            }
            AVLNode<K> parent = head.parent;
            while (parent != null && parent.left != head){
                head = parent;
                parent = parent.parent;
            }
            return parent;
        }

        @Override
        public AVLNode<K> createNode(K key) {
            return new AVLNode<>(key);
        }

        @Override
        protected void otherPropertyAfterRotate(AVLNode<K> oldHead, AVLNode<K> newHead, AVLNode<K> child) {
            newHead.parent = oldHead.parent;
            if (oldHead.parent == null){
                root = newHead;
            }else if (oldHead.parent.left == oldHead){
                newHead.parent.left = newHead;
            }else if (oldHead.parent.right == oldHead){
                newHead.parent.right = newHead;
            }
            oldHead.parent = newHead;
            if (child != null){
                child.parent = oldHead;
            }
            updateHeight(oldHead);
            updateHeight(newHead);
        }

        @Override
        protected void otherPropertyAfterInsert(AVLNode<K> newNode, AVLNode<K> parent) {
            newNode.parent = parent;
        }

        @Override
        protected void fixAfterInsert(AVLNode<K> node) {
            while (node != null){
                int leftH = height(node.left);
                int rightH = height(node.right);
                if (rightH - leftH == 2){
                    if (height(node.right.right) < height(node.right.left)){
                        rotateRight(node.right);
                    }
                    rotateLeft(node);
                    break;
                }else if (leftH - rightH == 2){
                    if (height(node.left.left) < height(node.left.right)){
                        rotateLeft(node.left);
                    }
                    rotateRight(node);
                    break;
                }else {
                    updateHeight(node);
                }
                node = node.parent;
            }
        }

        @Override
        protected void otherPropertyAfterDelete(AVLNode<K> delNode, AVLNode<K> successor, AVLNode<K> replace) {
            if (delNode == root){
                root = null;
                return;
            }
            if (successor != null && delNode.right != successor){ //delNode有双孩子
                successor.parent.left = successor.right;
                if (successor.right != null){
                    successor.right.parent = successor.parent;
                }
                replace = successor;
            }
            if (replace != null){
                replace.parent = delNode.parent;
                if (delNode.parent.left == delNode){
                    replace.parent.left = successor;
                }else {
                    replace.parent.right = successor;
                }
                replace.left = delNode.left;
                if (replace.left != null){
                    replace.left.parent = replace;
                }
                replace.right = delNode.right;
                if (replace.right != null){
                    replace.right.parent = replace;
                }
            }
        }

        @Override
        protected void fixAfterDelete(AVLNode<K> delNode, AVLNode<K> successor, AVLNode<K> replace) {
            //todo
        }

        private int height(AVLNode<K> node) {
            return node == null ? -1 : node.height;
        }

        private void updateHeight(AVLNode<K> node) {
            if (node != null){
                node.height = Math.max(height(node.left), height(node.right)) + 1;
            }
        }

    }

    public class RedBlackTree<K extends Comparable<K>> extends SelfBalanceBinarySearchTree<RedBlackNode<K>, K> {

        @Override
        public RedBlackNode<K> createNode(K key) {
            return null;
        }

        @Override
        protected void otherPropertyAfterInsert(RedBlackNode<K> newNode, RedBlackNode<K> parent) {

        }

        @Override
        protected void fixAfterInsert(RedBlackNode<K> newNode) {

        }

        @Override
        protected void otherPropertyAfterDelete(RedBlackNode<K> delNode, RedBlackNode<K> successor, RedBlackNode<K> replace) {

        }

        @Override
        protected void fixAfterDelete(RedBlackNode<K> delNode, RedBlackNode<K> successor, RedBlackNode<K> replace) {

        }

        @Override
        protected void otherPropertyAfterRotate(RedBlackNode<K> oldHead, RedBlackNode<K> newHead, RedBlackNode<K> child) {

        }
    }

    public class SizeBalanceTree<K extends Comparable<K>> extends SelfBalanceBinarySearchTree<BalanceSizeNode<K>, K> {

        @Override
        public void insert(K key) {
            if (select(key) != null){
                return;
            }
            root = add(root, key);
        }

        private BalanceSizeNode<K> add(BalanceSizeNode<K> head, K key) {
            if (head == null){
                return createNode(key);
            }
            head.size++;
            if (head.isKeyMore(key)){
                head.left = add(head.left, key);
            }else {
                head.right = add(head.right, key);
            }
            return maintain(head);
        }

        private BalanceSizeNode<K> maintain(BalanceSizeNode<K> head) {
            return null;
        }

        public BalanceSizeNode kth(int kth){
            if (kth < 1 || kth > size()){
                return null;
            }
            return kth(root, kth);
        }

        private BalanceSizeNode kth(BalanceSizeNode<K> head, int kth){
            if (kth == sizeOf(head.left) + 1){
                return head;
            }else if (kth < sizeOf(head.left) + 1){
                return kth(head.left, kth);
            }else {
                return kth(head.right, kth - sizeOf(head.left) - 1);
            }
        }

        @Override
        public BalanceSizeNode<K> createNode(K key) {
            return new BalanceSizeNode<>(key);
        }

        private int sizeOf(BalanceSizeNode<K> head){
            return head == null ? 0 : head.size;
        }

        @Override
        protected void otherPropertyAfterInsert(BalanceSizeNode<K> newNode, BalanceSizeNode<K> parent) {

        }

        @Override
        protected void fixAfterInsert(BalanceSizeNode<K> newNode) {

        }

        @Override
        protected void otherPropertyAfterDelete(BalanceSizeNode<K> delNode, BalanceSizeNode<K> successor, BalanceSizeNode<K> replace) {

        }

        @Override
        protected void fixAfterDelete(BalanceSizeNode<K> delNode, BalanceSizeNode<K> successor, BalanceSizeNode<K> replace) {

        }

        @Override
        protected void otherPropertyAfterRotate(BalanceSizeNode<K> oldHead, BalanceSizeNode<K> newHead, BalanceSizeNode<K> child) {

        }
    }


    public class SkipList<K extends Comparable<K>> extends SearchTree<SkipListNode<K>, K>{

        @Override
        public SkipListNode<K> select(K key) {
            return null;
        }

        @Override
        public void insert(K key) {

        }

        @Override
        public void delete(K key) {

        }

        @Override
        public SkipListNode<K> first() {
            return null;
        }

        @Override
        public SkipListNode<K> last() {
            return null;
        }

        @Override
        public SkipListNode<K> ceiling(K key) {
            return null;
        }

        @Override
        public SkipListNode<K> floor(K key) {
            return null;
        }

        @Override
        public SkipListNode<K> successor(SkipListNode<K> head) {
            return null;
        }

        @Override
        public SkipListNode<K> predecessor(SkipListNode<K> head) {
            return null;
        }

        @Override
        public SkipListNode<K> createNode(K key) {
            return null;
        }
    }



    private class Node<T extends Node, K extends Comparable<K>>{
        K key;

        public boolean isKeyLess(K otherKey){
            return otherKey != null && (key == null || key.compareTo(otherKey) < 0);
        }

        public boolean isKeyEqual(K otherKey){
            return (key == null && otherKey == null) || (key != null && otherKey != null && key.compareTo(otherKey) == 0);
        }

        public boolean isKeyMore(K otherKey){
            return key != null && (otherKey == null || key.compareTo(otherKey) > 0);
        }
    }

    private class BSTNode<T extends BSTNode<T, K>, K extends Comparable<K>> extends Node<T, K>{
        T left;
        T right;
    }

    private class BinarySearchNode<T extends BinarySearchNode<T, K>, K extends Comparable<K>> extends BSTNode<T, K>{
        T parent;
    }

    private class AVLNode<K extends Comparable<K>> extends BinarySearchNode<AVLNode<K>, K>{
        int height;

        public AVLNode(K key) {
            this.key = key;
        }
    }

    private class RedBlackNode<K extends Comparable<K>> extends BinarySearchNode<RedBlackNode<K>, K>{
        boolean color;
    }

    private class BalanceSizeNode<K extends Comparable<K>> extends BSTNode<BalanceSizeNode<K>, K>{
        int size;

        public BalanceSizeNode(K key) {
            this.key = key;
            size = 1;
        }
    }

    private class SkipListNode<K extends Comparable<K>> extends Node<SkipListNode<K>, K>{
        List<SkipListNode<K>> next;

        public SkipListNode() {
            next = new ArrayList<>(1);
        }

        public SkipListNode(K key, int level) {
            this.key = key;
            next = new ArrayList<>(level + 1);
        }
    }

}


