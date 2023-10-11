package com.lhj.designpatterns;

import java.util.Scanner;

/**
 * @description：
 * @createTime：2023-09-0910:30
 * @author：banyanmei
 */
public class test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // 去掉s的头和尾
        s = s.substring(1, s.length() - 1);
        // 切割s，使每个字串都是回文，求最少切割次数
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = -1;
        for (int i = 1; i <= n; i++) {
            dp[i] = i - 1;
            for (int j = 0; j < i; j++) {
                if (isHuiwen(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        System.out.println(dp[n]);
    }
    public static boolean isHuiwen(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            int j = n - i - 1;
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
