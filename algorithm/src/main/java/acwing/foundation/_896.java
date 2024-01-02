package acwing.foundation;

import java.util.Scanner;

/**
 * 贪心
 * 1. 二分查找
 * 2. 维护一个递增序列
 * 3. 二分查找的时候，需要取左边界
 * 4. 二分查找的时候，需要向下取整
 */
public class _896 {
    static final int N = 100010;
    static int[] a = new int[N];
    static int[] q = new int[N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 输入a
        for (int i = 0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        // 初始化q
        for (int i = 0; i<n; i++) {
            q[i] = 0;
        }
        // 二分查找
        q[0] = Integer.MIN_VALUE;
        int len = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = len+1;
            while(l<r) {
                int mid = (l+r)>>1;
                if(q[mid]>=a[i]) r = mid;
                else l = mid+1;
            }
            q[r] = a[i];
            len = Math.max(len, r);
        }
        System.out.println(len);
    }
}
