package org.ex.hackerrank.onemonth;

import java.util.ArrayList;
import java.util.List;

/**
 * @desc:
 * @author: Leif
 * @date: 2024/4/2 15:59
 */
public class SparseArrays {
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        List<Integer> res = new ArrayList();
        for(int i = 0 ; i < queries.size(); i++) {
            String str = queries.get(i);
            // 注意这个计数器的应用方式
            int counter = 0 ;
            if (strings.contains(str)) {
                for (String s : strings) {
                    if (s.equals(str))  counter++;
                }
            }
            res.add(counter);
        }

        return res;

    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        List<String> queries = new ArrayList<>();
        strings.add("ab");
        strings.add("ab");
        strings.add("abc");

        queries.add("ab");
        queries.add("abc");
        queries.add("bc");

        System.out.println(matchingStrings(strings,queries));
    }
}
