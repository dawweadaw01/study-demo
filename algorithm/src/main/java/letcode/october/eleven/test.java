package letcode.october.eleven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * letcode 2023 10 11 每日一题
 * 2023. Top K Students
 * https://www.lintcode.com/problem/2023/
 * 相关标签: 哈希表 排序
 */
public class test {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        // Write your code here
        // positive_feedback转换为set表示
        HashSet<String> positive_feedback_set = new HashSet<>(Arrays.asList(positive_feedback));
        // negative_feedback转换为set表示
        HashSet<String> negative_feedback_set = new HashSet<>(Arrays.asList(negative_feedback));
        // 以空格切割report

        // 构造得分数组
        int n = report.length;
        List<int[]> ints = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            String[] split = report[i].split(" ");
            // 以student_id为key，以分数为value
            int[] score = new int[2];
            score[1] = student_id[i];
            for (String s1 : split) {
                if (positive_feedback_set.contains(s1)) {
                    score[0]+=3;
                } else if (negative_feedback_set.contains(s1)) {
                    score[0]--;
                }
            }
            ints.add(score);
        }
        // 排序
        ints.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1]-o2[1];
            } else {
                return o2[0]-o1[0];
            }
        });
        // 取前k个
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i<k; i++) {
            res.add(ints.get(i)[1]);
        }
        return res;
    }
}
