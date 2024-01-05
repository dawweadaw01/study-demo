package acwing.foundation;


public class _897_2 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t = text2.toCharArray();
        int m = t.length;
        int[] f = new int[m+1];
        for (char o : text1.toCharArray()) {
            for (int i = 0,pre = 0; i < m; i++) {
                int tmp = f[i+1];
                f[i+1] = o == t[i] ? pre+1 : Math.max(f[i], f[i+1]);
                pre = tmp;
            }
        }
        return f[m];
    }
}
