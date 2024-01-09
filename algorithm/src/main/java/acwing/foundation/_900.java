package acwing.foundation;

import java.util.Scanner;

public class _900 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int M = (int) (1e9+7);
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                dp[j] = (dp[j]+dp[j-i]) % M;
            }
        }
        System.out.println(dp[n]);
    }
}
