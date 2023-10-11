package com.lhj.streamlambda;

import java.util.*;
import java.util.stream.Collectors;

//@SpringBootTest

public class Test {
    @org.junit.Test
    public void testSortLambda() {
        List<String> list = Arrays.asList("peter", "anna", "mike", "xenia");
        // 常规的写法，使用函数进行比对
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });
        System.out.println(list);
        // 使用lambda表达式
        list.sort((o1, o2) -> o2.compareTo(o1));
        System.out.println(list);
    }

    @org.junit.Test
    public void testFilterLambada() {
        List<String> list = Arrays.asList("peter", "anna", "mike", "aenia");
        // 常规的写法，使用函数进行比对
        for (String s : list) {
            if (s.startsWith("a")) {
                System.out.println(s);
            }
        }
        // 使用lambda表达式
        List<String> a = list.stream().filter(s -> s.contains("e")).collect(Collectors.toList());
        System.out.println(a);
    }

    @org.junit.Test
    public void testMapLambada() {
        List<String> list = Arrays.asList("peter", "anna", "mike", "aenia");
        ArrayList<Integer> list1 = new ArrayList<>();
        // 常规的写法，使用函数进行比对
        for (String s : list) {
            list1.add(s.length());
        }

        // 使用lambda表达式的map方法
        List<Integer> list2 = list.stream().map(s -> s.length()).collect(Collectors.toList());
        List<Integer> list3 = list.stream().map(String::length).toList();
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }

    // reduce方法可以将所有值合并成一个,规约操作
    @org.junit.Test
    public void testReduceLambada() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // 常规的写法，使用函数进行比对
        int sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        System.out.println(sum);
        // 使用lambda表达式的reduce方法
        int sum1 = list.stream().reduce(0, Integer::sum);
        System.out.println(sum1);
    }

    // groupBy方法可以将所有值合并成一个
    @org.junit.Test
    public void testGroupByLambada() {
        List<String> list = Arrays.asList("peter", "anna", "mike", "aenia");
        // 常规的写法，使用函数进行比对
        Map<Integer, List<String>> groups = new HashMap<>();
        for (String s : list) {
            if (!groups.containsKey(s.length())) {
                groups.put(s.length(), new ArrayList<>());
                groups.get(s.length()).add(s);
            } else {
                groups.get(s.length()).add(s);
            }
        }
        System.out.println(groups);
        // 使用lambda表达式的reduce方法
        Map<Integer, List<String>> groups2 = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groups2);
    }

    @org.junit.Test
    public void testAssemblyLine() {
        List<String> list = Arrays.asList("peter", "anna", "mike", "aenia");
        // 常规的写法，使用函数进行比对
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            if (s.startsWith("a")) {
                list1.add(s.toUpperCase());
            }
        }
        list1.sort(Comparator.reverseOrder());
        System.out.println(list1);

        // 使用lambda表达式流水线操作
        List<String> a = list.stream().filter(s -> s.startsWith("a")).map(String::toUpperCase).
                sorted(Comparator.naturalOrder()).toList();
        System.out.println(a);
    }

    @org.junit.Test
    public void test231() {
        int n, k;
        Scanner sc = new Scanner(System.in);
        int[] a = new int[100010];
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            while (!q.isEmpty() && q.peekLast() > a[i]) {
                q.pollLast();
            }
            q.addLast(a[i]);
            while (i - k >= 1 && q.peekFirst() == a[i - k]) {
                q.pollFirst();
            }
            if (i >= k) System.out.println(q.peekFirst() + " ");
        }
    }

    public static void main(String[] args) {
        int n, k;
        Scanner sc = new Scanner(System.in);
        int[] a = new int[100010];
        n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            while (!q.isEmpty() && a[q.peekLast()] > a[i]) {
                q.pollLast();
            }
            q.addLast(i);
            while (i - k >= 1 && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }
            if (i >= k) System.out.print(a[q.peekFirst()] + " ");
        }
        System.out.println();
    }
}
