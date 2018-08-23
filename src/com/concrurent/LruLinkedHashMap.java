package com.concrurent;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ${TODO}
 *
 * @author dengzx
 * @date 2018/8/21 10:13
 */
public class LruLinkedHashMap<K, V> extends LinkedHashMap {

    private int maxSize = 0;

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
//        return super.removeEldestEntry(eldest);
        return size() > maxSize;
    }

    LruLinkedHashMap(int maxSize) {
        super(maxSize, 0.75f, true);
        this.maxSize = maxSize;
    }
}
