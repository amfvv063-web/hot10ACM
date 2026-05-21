package hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P_394stringEncoding {
public static void main(String[] args) {
    String s = "3[a]2[b]";
    
    String ans = decoding(s);
    System.out.println(ans);
    
}

//双栈  一个数字统计栈 一个字符串统计栈
// ]情况出现 就把该字符串拼接到上一个字符串后面
private static String decoding(String s) {
    Deque<Integer> cntSt = new ArrayDeque<>();
    Deque<StringBuilder> strSt = new ArrayDeque<>();
    strSt.push(new StringBuilder());
    int k = 0;
    for (char c : s.toCharArray()) {
        //如果是数字 先统计数字k是多少
        if (Character.isDigit(c)) {
            k = k*10 + (c - '0'); //存在十位数的情况
        }else if (c == '[') { // 开始有括号 开始统计 括号内字符串，同时数字入栈
            cntSt.push(k);
            k = 0;
            strSt.push(new StringBuilder());
        }else if (c==']') { //括号结束， 开始拼字符串
            StringBuilder cur = strSt.pop(); //处理嵌套情况
            int cnt = cntSt.pop();
            StringBuilder pre = strSt.peek();
            for (int i = 0; i < cnt; i++) {
                pre.append(cur);
            }
        }else{
            strSt.peek().append(c);
        }
    }
    return strSt.peek().toString();
}
}
