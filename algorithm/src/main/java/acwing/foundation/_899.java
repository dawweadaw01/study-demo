package acwing.foundation;

import java.util.Scanner;

public class _899 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }

        for (int i = 0; i < m; i++) {
            int res = 0;
            String str = scanner.next();
            int flag = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                if(get(str.toCharArray(), s[j].toCharArray()) <= flag){
                    res++;
                }
            }
            System.out.println(res);
        }

    }
    public static int get(char[] a, char[] b){
        int[][] dp = new int[a.length+1][b.length+1];//
        for (int i = 0; i <= a.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= b.length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+1;
                dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+(a[i-1]==b[j-1]?0:1));
            }
        }
        return dp[a.length][b.length];
    }
}
