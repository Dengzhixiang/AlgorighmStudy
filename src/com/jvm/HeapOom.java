package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * ${TODO}
 *
 * @author lenovo
 * @date 2018/7/28 12:19
 * @since ${TODO}
 */
public class HeapOom {

    static class OomObject {

    }

    public static void main(String[] args) {
        List<OomObject> list = new ArrayList<>();
        while (true) {
            list.add(new OomObject());
        }
    }

}
