import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<String> stack = new Stack();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && c==')') {
                stack.pop();
            }
            else stack.push(Character.toString(c)); //스택이 비었거나, 현재 문자가 ( 일 경우 스택에 push
        }
        if (stack.size() > 0) answer = false; //스택에 값이 들어있을 경우 false

        return answer;
    }
}
