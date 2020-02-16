package com.tree.core.algorithm.newcoder.zuogod.x04.junior;

import java.util.HashMap;

/**
 * 设计RandomPool结构
 * 【题目】 设计一种结构,在该结构中有如下三个功能:
 * insert(key): 将某个key加入到该结构,做到不重复加入.
 * delete(key): 将原本在结构中的某个key移除.
 * getRandom(): 等概率随机返回结构中的任何一个key.
 *
 * 【要求】 Insert、delete和getRandom方法的时间复杂度都是O(1)
 */
public class I0039Q010602RandomPool {
    /** key是需要的数据, value是放入key是的index(map.size) */
    HashMap<String, Integer> data = new HashMap<>();
    /** key是当时的index, value是需要的数据 */
    HashMap<Integer, String> index = new HashMap<>();

    public boolean insert(String key){
        if (data.containsKey(key)){
            return false;
        }
        int idx = data.size();
        data.put(key, idx);
        index.put(idx, key);
        return true;
    }

    public void delete(String key){
        Integer idx = data.get(key);
        if (idx == null){
            return;
        }
        data.remove(key);
        String value = index.get(data.size());
        index.put(idx, value);
        data.put(value, idx);
        index.remove(data.size());
    }

    public String random(){
        int i = (int) (Math.random() * data.size());
        return index.get(i);
    }
}
