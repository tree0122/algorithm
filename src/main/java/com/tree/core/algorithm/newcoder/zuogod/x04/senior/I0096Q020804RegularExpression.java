package com.tree.core.algorithm.newcoder.zuogod.x04.senior;

/**
 * 字符串匹配问题
 *
 * 【题目】
 * 给定字符串str,其中绝对不含有字符'.'和'*'。再给定字符串exp,
 * 其中可以含有'.'或'*','*'字符不能是exp的首字符,并且任意两个
 * '*'字符不相邻。exp中的'.'代表任何一个字符,exp中的'*'表示'*'
 * 的前一个字符可以有0个或者多个。请写一个函数,判断str是否能被
 * exp匹配。
 *
 * 【举例】
 * str="abc",exp="abc",返回true。
 * str="abc",exp="a.c",exp中单个'.'可以代表任意字符,所以返回
 * true。
 * str="abcd",exp=".*"。exp中'*'的前一个字符是'.',所以可表示任
 * 意数量的'.'字符,当exp是"...."时与"abcd"匹配,返回true。
 * str="",exp="..*"。exp中'*'的前一个字符是'.',可表示任意数量
 * 的'.'字符,但是".*"之前还有一个'.'字符,该字符不受'*'的影响,
 * 所以str起码有一个字符才能被exp匹配。所以返回false。
 */
public class I0096Q020804RegularExpression {

    public boolean match(String s, String e){
        if (s == null || s.length() == 0 || e == null || e.length() == 0){
            return true;
        }
        return process(s, e, 0, 0);
    }

    /**
     * 字符串e j~e.length, 是否匹配 字符串 s i-length
     *
     * 思路:
     * (j + 1)位置是否为 *, 分两种情况
     *
     * @param s 字符串
     * @param e 模式串
     * @param i s的起始位置
     * @param j e的其实位置
     * @return true可匹配上, false不能匹配上
     */
    private boolean process(String s, String e, int i, int j) {
        if (j == e.length()){
            return i == s.length();
        }
        //e[j+1]不是*的情况, 对应位置一个一个向右比较
        if (j + 1 == e.length() || e.charAt(j + 1) != '*'){
            return i < s.length()
                    && (s.charAt(i) == e.charAt(j) || e.charAt(j) == '.')
                    && process(s, e, i + 1, j + 1);
        }
        //潜台词, e[j+1]是*的情况, 且e[j]匹配
        while (i < s.length() && (s.charAt(i) == e.charAt(j) || e.charAt(j) == '.')){
            if (process(s, e, i, j + 2)){//尝试e[j+2]开始匹配
                return true;
            }
            //e[j+2]匹配失败, s的下个位置尝试匹配
            i++;
        }
        //潜台词, e[j+1]是*, 且e[j]不匹配, 尝试e[j+2]开始比较
        return process(s, e, i, j + 2);
    }

    private boolean dp(String s, String e){
        if (s == null || s.length() == 0 || e == null || e.length() == 0){
            return false;
        }
        //初始化
        boolean[][] help = new boolean[s.length() + 1][e.length() + 1];
        help[s.length()][e.length()] = true;
        for (int j = e.length() - 2; j >= 0; j -= 2) {
            if (e.charAt(j) != '*' && e.charAt(j + 1) == '*'){
                help[s.length()][j] = true;
            }else {
                break;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = e.length() - 2; j >= 0; j--) {
                if (e.charAt(j + 1) != '*'){
                    help[i][j] = (s.charAt(i) == e.charAt(j) || e.charAt(j) == '.') && help[i + 1][j + 1];
                }else if (s.charAt(i) != e.charAt(j) && e.charAt(j) != '.'){
                    help[i][j] = help[i][j + 2];
                }else {
                    int si = i;
                    while (si != s.length() && (s.charAt(si) == e.charAt(j) || e.charAt(j) == '.')){
                        if (help[i][j + 2]){
                            help[i][j] = true;
                            break;
                        }
                        si++;
                    }
                }
            }
        }
        return help[0][0];
    }

}
