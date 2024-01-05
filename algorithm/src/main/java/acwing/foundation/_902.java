package acwing.foundation;

import java.util.Scanner;

public class _902 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s1 = sc.next();
        int m = sc.nextInt();
        String s2 = sc.next();
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[][] f = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            f[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {
                f[i][j] = Math.min(f[i-1][j], f[i][j-1])+1;
                f[i][j] = Math.min(f[i][j], f[i-1][j-1]+(chars1[i-1]==chars2[j-1]?0:1));
            }
        }
        System.out.println(f[n][m]);
    }
}
