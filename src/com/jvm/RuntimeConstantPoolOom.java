package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * ${TODO}
 * -XX:PermSize=10M -XX:MaxPermSieze=10M
 *
 * @author lenovo
 * @date 2018/7/28 14:02
 * @since ${TODO}
 */
public class RuntimeConstantPoolOom {

    public static void main(String[] args) {
        String st1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(st1.intern() == st1);

        String str2 = new StringBuilder("lo").append("ng").toString();
        System.out.println(str2.intern() == str2);
    }

    private void puntimeConstantPoolOom() {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
