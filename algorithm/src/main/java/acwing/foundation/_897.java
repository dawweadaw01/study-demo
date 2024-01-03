package acwing.foundation;


import java.util.Scanner;

public class _897 {
    static final int N = 1010;
    static char[] a = new char[N];
    static char[] b = new char[N];
    static int[][] f = new int[N][N];

    public static void main(String[] args) {
        int n,m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        String tmp = sc.next();
        System.out.println(tmp.charAt(1));
        // 输入a
        for (int i = 1; i<=n; i++) {
            // 读字符
            a[i] = tmp.charAt(i-1);
        }
        tmp = sc.next();
        // 输入b
        for (int i = 1; i<=m; i++) {
            b[i] = tmp.charAt(i-1);
        }
        // 初始化f
        for (int i = 0; i<=n; i++) {
            for (int j = 0; j<=m; j++) {
                f[i][j] = 0;
            }
        }
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m ; j++) {
                if(a[i] == b[i]) f[i][j] = f[i-1][j-1]+1;
                else f[i][j] = Math.max(f[i-1][j], f[i][j-1]);
            }
        }
        System.out.println(f[n][m]);
    }
}
