package acwing.foundation;

import java.util.Scanner;

public class _895 {
    static final int N = 1010;
    static int[] w = new int[N];
    static int[] f = new int[N];
    public static void main(String[] args) {
        // 输入n
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 输入w
        for (int i = 1; i<=n; i++) {
            w[i] = sc.nextInt();
        }
        // 找到最大值
        int max = 1;
        // 初始化f
        for (int i = 1; i<=n; i++) {
            f[i] = 0;
        }
        // 遍历w,一边遍历一边更新f
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j<i; j++) {
                if (w[i] > w[j]) {
                    f[i] = Math.max(f[i], f[j]+1);
                }
            }
            // 更新max
            max = Math.max(max, f[i]);
        }
        System.out.println(max);
    }
}
