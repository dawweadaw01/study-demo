package letcode.october.twelve;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2562. 找出数组的串联值
 * 相关标签: 数组，双指针
 */
public class test {
    public long findTheArrayConcVal(int[] nums) {
        Deque<Integer> integers = new ArrayDeque<>(10000);
        // nums转换为双端队列
        for (int num : nums) {
            integers.add(num);
        }
        long res = 0L;
        while (integers.size() > 1) {
            Integer first = integers.getFirst();
            Integer last = integers.getLast();
            // 拼接
            String string = first + "" + last;
            res += Long.parseLong(string);
            integers.removeFirst();
            integers.removeLast();
        }
        if (integers.size() == 1) {
            res += integers.getFirst();
        }
        return res;
    }
}
