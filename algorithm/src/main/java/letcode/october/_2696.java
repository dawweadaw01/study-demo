package letcode.october;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _2696 {
    public int minLength(String s) {
        ArrayList<Character> stack = new ArrayList<>();
        // 定义一个栈
        List<Object> objects = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char charAt = s.charAt(i);
            stack.add(charAt);
            int m = stack.size();
            if(m >= 2 &&
                    ((stack.get(m - 2) == 'A' && stack.get(m - 1) == 'B') ||
                            (stack.get(m - 2) == 'C' && stack.get(m - 1) == 'D'))) {
                stack.remove(m-1);
                stack.remove(m-2);
            }
        }
        return stack.size();
    }
}
