package com.lhj.designpatterns;

import java.util.*;

/**
 * @description：
 * @createTime：2023-09-0910:14
 * @author：banyanmei
 */
public class test {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<segs> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            segs seg = new segs();
            seg.setFirst(sc.nextDouble());
            seg.setSecond(sc.nextDouble());
            list.add(seg);
        }
        System.out.println(merge(list));
    }

    static int merge(List<segs> list) {
        List<segs> list1 = new ArrayList<>();
        list.sort(Comparator.comparingDouble(o -> o.first));
        System.out.println(Arrays.toString(list.toArray()));
        double st = -2e9, ed = -2e9;
        for (segs seg : list) {
            if (seg.first > ed) {
                st = seg.first;
                ed = seg.second;
                list1.add(new segs(st, ed));
            } else {
                ed = Math.max(ed, seg.second);
            }
        }
//        if (st != -2e9) {
//            list1.add(new segs(st, ed));
//        }
        System.out.println(Arrays.toString(list1.toArray()));
        return list1.size();
    }
}

class segs {
    double first;
    double second;

    public segs(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public segs() {

    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "segs{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
