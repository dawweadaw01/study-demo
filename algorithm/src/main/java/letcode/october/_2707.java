package letcode.october;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 思路：
 * 链接：h<a href="ttps://leetcode.cn/problems/extra-characters-in-a-string/solutions/2590667/zi-fu-chuan-zhong-de-e-wai-zi-fu-by-leet-f0lu/
 ">...</a> */
public class _2707 {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        int[] dp = new int[n+1];
        HashMap<String, Integer> map = new HashMap<>();
        // 初始化存值
        for (String string : dictionary) {
            if(!map.containsKey(string)){
                map.put(string,1);
            }
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1]+1;
            for (int j = i-1;j>=0;j--){
                if(map.containsKey(s.substring(j,i))){
                    dp[i] = Math.min(dp[i],dp[j]);
                }
            }
        }
        return dp[n];
    }
}
