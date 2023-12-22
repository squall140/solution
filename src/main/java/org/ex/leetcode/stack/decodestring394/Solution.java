package org.ex.leetcode.stack.decodestring394;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @desc: Decode String
 *
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces,
 * square brackets are well-formed, etc.
 * Furthermore, you may assume that the originaldata does not contain any digits and that digits are only for those repeat numbers,k.
 * For example, there will not be input like 3a or 2[4].
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 * 思路，迭代法， 栈解法
 * 主要看官方动画 和 Krahets 解法
 * https://leetcode.cn/problems/decode-string/solutions/264391/zi-fu-chuan-jie-ma-by-leetcode-solution/
 *
 * 作者：Krahets
 * 链接：https://leetcode.cn/problems/decode-string/solutions/19447/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author: Leif
 * @date: 2023/12/22 10:14
 */
public class Solution {
    public String decodeString(String s){
        // 临时字符串
        StringBuilder res = new StringBuilder();
        // 倍数
        int multi = 0;
        // 定义存储倍数的辅助栈
        // 推荐使用Deque而不是Stack，具体参见 https://blog.csdn.net/qq_37654497/article/details/112100906
        Deque<Integer> stack_multi = new LinkedList<>();
        // 定义存储字符串的辅助栈
        Deque<String> stack_res = new LinkedList<>();
        char[] chars = s.toCharArray();
        for(Character c : chars){
            if (c == '['){
                // 遍历时候如果遇到左中括号，则把当前需要参与倍数和字符串一起压栈
                // 并重制倍数和临时字符串
                stack_res.push(res.toString());
                stack_multi.push(multi);
                multi = 0;
                res = new StringBuilder();
            }else if(c == ']'){
                // 如果遇到了右中括号，那么需要进行弹栈操作
                StringBuilder tmp = new StringBuilder();
                // 取出当前的倍数
                int cur_multi = stack_multi.pop();
                // 根据倍数得出此时的res字符串，并追加到res尾部
                for (int i = 0; i < cur_multi; i++)
                    tmp.append(res);

                // 累计追加前一个res到当前的res中
                res = new StringBuilder(stack_res.pop() + tmp);

            }else if(c >= '0' && c <= '9'){
                // 当字符 c 为纯数字时，将数字字符转化为数字 multi，用于后续倍数计算；
                // 如果 c 为多位数，比如 22[a]，那么要乘 10
                // 其中 c + "" == c.toString()
                multi = multi * 10 + Integer.parseInt(c + "");
            }else{
                //  (ch >= 'a' && ch <= 'z') ，尾部追加res
                res.append(c);
            }
            return res.toString();

        }




        return null;
    }




}
