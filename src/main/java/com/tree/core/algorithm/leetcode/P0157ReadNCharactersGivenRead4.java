package com.tree.core.algorithm.leetcode;

public class P0157ReadNCharactersGivenRead4 {

    public int read(byte[] buf ,int n){
        if (n <= 0){
            return 0;
        }
        int len = 0, cur = 0;
        byte[] tmp = new byte[4];
        do {
            len = read4(tmp);
            for (int i = 0; i < len; i++) {
                buf[cur + i] = tmp[i];
                cur++;
            }
        }while (len == 4 && cur < n);
        return Math.min(n, cur);
    }

    private int read4(byte[] tmp){

        return tmp.length;
    }

}
