package com.leetcode.primary.other;

import java.util.ArrayList;
import java.util.List;

/**
 * ${TODO}
 *
 * @author dengzx
 * @date 2018/8/29 15:12
 */
public class Solution {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>();
        row1.add(1);
        row2.add(1);
        row2.add(1);
        list.add(row1);
        if (numRows == 1) {
            return list;
        }
        list.add(row2);
        if (numRows == 2) {
            return list;
        }
        for (int i = 3; i <= numRows; ++i) {
            List<Integer> temp = new ArrayList<>(i);
            temp.add(1);
            temp.add(i - 1, 1);
            for (int j = 1; j < numRows - 1; ++j) {
                temp.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        generate(3);
    }

}
