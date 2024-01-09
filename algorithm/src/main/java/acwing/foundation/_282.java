package acwing.foundation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 所有的区间dp问题枚举时，第一维通常是枚举区间长度，并且一般 len = 1 时用来初始化，枚举从 len = 2 开始；第二维枚举起点 i （右端点 j 自动获得，j = i + len - 1）
 */
public class _282 {
    static int N = 310;
    static int[][] dp = new int[N][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[N];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            a[i] += a[i-1];
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], 0x3f3f3f3f);
        }
        // 枚举长度
        for (int len = 1; len <= n ; len++) {
            for (int i = 1; i+len-1<=n ; i++) {
                int j = i+len-1;
                if(len == 1){
                    dp[i][i] = 0;
                    continue;
                }
                for(int k = i;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+ dp[k+1][j] + a[j] - a[i-1]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
