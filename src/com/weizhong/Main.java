package com.weizhong;

import java.util.Scanner;

/**
 * 〈微众银行 --> 笔试〉
 *
 * @author Administrator
 * @create 2018/9/18
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        problem1();
    }

    /**
     * 阳阳突发奇想画起了三角！
     * 1/1(1)  1/2(2)  1/3(6)  1/4(7) ...
     * 2/1(3)  2/2(5)  2/3(8) ...
     * 3/1(4)  3/2(9) ...
     * 4/1(10) ...
     * ...
     * 并且在三角每个位置填上了一个数字（即分数后括号中的数字），然后按照z字型给数字了一个编号，如上图所示。
     * 现在阳阳想知道编号为N的数字是多少，希望你能够告诉他。
     * 1≤N≤10000000
     */
    public static void problem1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(GetResult(n));
    }

    private static String GetResult(int N) {
        return null;
    }

    /**
     * 小X通过了小C的面试，顺利的拿到了运输部的offer，但是第一次做业务就难倒了小X（毕竟他的面试是靠别人帮忙的…），于是小X又来请你帮忙了。
     *
     * 有一批边长1-6的正方形货物，货物的高都是1024，需要小X运输，小X的配车后备箱高度也是1024，底面是边长为6的正方形。小C要求他用最少的次数完成运输，到底需要多少次呢？
     */
    public static void problem2() {
        Scanner cin = new Scanner(System.in);
        cin.nextInt();
    }

}