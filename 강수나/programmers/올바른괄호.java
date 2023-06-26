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
            else stack.push("(");
        }
        if (stack.size() > 0) answer = false;

        return answer;
    }
}