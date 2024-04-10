package org.ex.hackerrank.onemonth;

import java.util.List;

/**
 * @desc: Subarray Division
 *
 * 思路， 滑动窗口
 * @author: Leif
 * @date: 2024/4/3 16:50
 */
public class SubarrayDivision {
    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int n = s.size();
        int counter = 0;
        int sum = 0;
        int left = 0, right = 0;
        while(right < n){
            sum += s.get(right);
            // continue to slide window, util the length of window equal with 'm'
            while(right - left + 1 >= m){
                if (sum == d) counter++;
                sum -= s.get(left);
                left++;
            }
            right++;
        }
        return counter;

    }

}
