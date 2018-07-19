package com.test;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * 〈Test〉
 *
 * @author Administrator
 * @create 2018/7/7
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) {
        Time t1 = new Time(10, 0);
        Time t11 = new Time(12, 7);
        Time t2 = new Time(10, 10);
        Time t22 = new Time(10, 42);
        Time t3 = new Time(10, 48);
        Time t33 = new Time(11, 49);
        Time t4 = new Time(10, 59);
        Time t44 = new Time(13, 7);
        Time t5 = new Time(12, 28);
        Time t55 = new Time(14, 57);
//        Time[] times = new Time[]{t1, t2, t3, t4, t5};
//        Arrays.sort(times);
//        System.out.println(Arrays.toString(times));


        Work[] works = new Work[]{new Work(t1, t11), new Work(t2, t22), new Work(t3, t33)
                , new Work(t4, t44), new Work(t5, t55)};
        Work[] works1 = works.clone();
        Arrays.sort(works);
        System.out.println(Arrays.toString(works));

        System.out.println(minCount(works));
    }

    public static int minCount(Work[] works) {
        int count = 0;
        boolean[] flag = new boolean[works.length];
        for (int i = 0; i < works.length; ++i) {

        }
        return count;
    }

    static class Time implements Comparable {
        int hour;
        int minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "hour=" + hour +
                    ", minute=" + minute +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            Time orderTime = (Time) o;
            if (this.hour != orderTime.hour) {
                return this.hour - orderTime.hour;
            }
            return this.minute - orderTime.minute;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Time time = (Time) o;
            return hour == time.hour &&
                    minute == time.minute;
        }

        @Override
        public int hashCode() {
            return Objects.hash(hour, minute);
        }
    }

    static class Work implements Comparable<Work>, Cloneable {
        Time startTime;
        Time endTime;

        public Work(Time startTime, Time endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Work work = (Work) o;
            return startTime == work.startTime &&
                    endTime == work.endTime;
        }

        @Override
        public int hashCode() {

            return Objects.hash(startTime, endTime);
        }

        @Override
        public int compareTo(Work order) {
            Work orderWork = order;
            if (!this.startTime.equals(orderWork.startTime)) {
                return this.startTime.compareTo(orderWork.startTime);
            }
            return this.endTime.compareTo(orderWork.endTime);
        }

        @Override
        public String toString() {
            return "Work{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }

        /**
         * 即使默认的Clone()浅拷贝能满足要求，也要重写clone()方法为public,且调用super.clone()
         * @return
         * @throws CloneNotSupportedException
         */
        @Override
        public Work clone() throws CloneNotSupportedException {
            try(Scanner in = new Scanner(System.in)) {

            }
            return (Work) super.clone();
        }
    }
}