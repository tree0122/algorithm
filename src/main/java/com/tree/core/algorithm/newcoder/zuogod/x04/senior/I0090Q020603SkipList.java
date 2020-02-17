package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

import java.util.ArrayList;
import java.util.List;

/**
 * 跳表
 */
public class I0090Q020603SkipList {

    private SkipNode head;

    private int maxLevel;

    private int size;

    private final double PROBABILITY = 0.5D;

    public I0090Q020603SkipList() {
        head = new SkipNode(null);
        maxLevel = 0;
        size = 0;
    }

    /**
     * 查找value是否存在
     * @param value 值
     * @return true存在
     */
    public boolean contains(int value){
        SkipNode node = find(value);
        return node != null && node.value != null && node.value == value;
    }

    /**
     * 添加一个值
     * @param value 值
     */
    public void insert(int value){
        if (contains(value)){
            return;
        }
        size++;
        int level = 0;
        while (Math.random() < PROBABILITY){ //生成当前值的层数
            level++;
        }
        while (level > maxLevel){ //修正跳表最大层数
            head.next.add(null);
            maxLevel++;
        }
        SkipNode newNode = new SkipNode(value);
        SkipNode cur = head;
        for (int i = maxLevel - 1; i >= 0; i--) { //从最大层开始,一层一层处理新值的连接
            cur = findNext(value, cur, i); //在i层, 小于且最接近value的节点
            newNode.next.add(0, cur.next.get(i)); //将cur放到newNode的首位
            cur.next.set(i, newNode); //将cur的i层, 设置为newNode
        }
    }

    /**
     * 删除一个值
     * @param value
     */
    public void delete(int value){
        if (!contains(value)){ //不存在,直接结束
            return;
        }
        size--;
        SkipNode cur = head;
        SkipNode delNode = find(value); //找到对应的节点
        for (int i = maxLevel - 1; i >= 0; i--) { //从最高层节点开始, 一层一层处理要删除节点的连接
            cur = findNext(value, cur, i); //在i层, 小于且最接近value的节点
            if (delNode.next.size() - 1 >= i){ //delNode的高度 大于等于i, 修改cur在i层的连接
                cur.next.set(i, delNode.next.get(i));
            }
        }
    }

    public int getSize(){
        return size;
    }

    /**
     * 整个跳表中最接近value的节点,节点的值可能大于value(>=value)
     * @param value 值
     * @return >=value的节点中, 最接近value的节点
     */
    private SkipNode find(int value) {
        SkipNode cur = head;
        int level = maxLevel - 1;
        do {
            cur = findNext(value, cur, level--);
        }while (level >= 0);
        return cur.next.get(0);
    }

    /**
     * 在某一层, 最接近value的节点(<value)
     * @param value 值
     * @param cur 开始节点
     * @param level 某层
     * @return 某层 小于value的节点, 最接近value的节点
     */
    private SkipNode findNext(int value, SkipNode cur, int level) {
        SkipNode next = cur.next.get(level);
        while (next != null && next.value < value){
            cur = next;
            next = next.next.get(level);
        }
        return cur;
    }


    private final class SkipNode{
        Integer value;
        List<SkipNode> next;
        public SkipNode(Integer value) {
            this.value = value;
            next = new ArrayList<>();
        }
    }

}
