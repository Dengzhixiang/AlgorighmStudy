package com.leetcode.middlealgorithmtrain.arraytrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字谜分词
 *
 * @author dengzx
 * @date 2018/9/3 15:07
 */
public class GroupAnagrams {

    /**
     * HashMap + ArrayList，对字母异位词进行分组
     * 一个keyString对应一个ArrayList，归纳一组字母异位词
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            char[] temp = string.toCharArray();
            Arrays.sort(temp);
            String keyString = String.valueOf(temp);
            if (!map.containsKey(keyString)) {
                map.put(keyString, new ArrayList<>());
            }
            map.get(keyString).add(string);
        }
        return new ArrayList<>(map.values());
    }
}
