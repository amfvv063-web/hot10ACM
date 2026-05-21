package hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P_20isVaild {
    public static void main(String[] args) {
        String s = "()}";
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        boolean ans = isValid(s);
        System.out.println(ans);
    }

    private static boolean isValid(String s) {
        if (s.length()%2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(' );
        map.put(']','[' );
        map.put('}','{');
        Deque<Character> dq = new ArrayDeque<>();
       for (char c : s.toCharArray()) {
        if (!map.containsKey(c)) { //左括号
            dq.push(c); //左括号全入
        }else if (dq.isEmpty()||dq.pop()!= map.get(c)) {  //左右括号消消乐
            return false;
        }
       }
       return true;
    }
}
