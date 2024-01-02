package acwing.foundation;

import java.util.Scanner;

public class _895_2 {
    static final int N = 1010;
    static int[] w = new int[N];
    static int[] f = new int[N];
    public static void main(String[] args) {
        // 输入n
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        // 输入w
        for (int i = 1; i<=n; i++) {
            w[i] = sc.nextInt();
        }
        // 第一个数
        f[cnt++] = w[0];
        // 核心在于维护一个递增的序列，如果当前数比序列中最后一个数大，就加入序列，否则就替换掉序列中第一个比当前数大的数
        // 又由于序列是递增的，所以可以用二分查找
        for (int i = 0; i < n; i++) {
            if(w[i]>f[cnt-1]) {
                f[cnt++] = w[i];
            }else {
                int l = 0, r = cnt-1;
                // 二分查找需要取第一个比当前数大的数，所以需要取左边界
                while(l<r) {
                    // 向下取整，保证mid在l的左边
                    int mid = (l+r)>>1;
                    if(f[mid]>=w[i]) r = mid;
                    else l = mid+1;
                }
                // 替换掉第一个比当前数大的数,也就是此时的r
                f[r] = w[i];
            }
        }
        System.out.println(cnt);
    }
}
