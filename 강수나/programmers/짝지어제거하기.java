import java.util.*;
import java.io.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<> ();
        int len = s.length();
        stack.push(s.charAt(0));
        for (int i=1; i<len; i++) {
            if (!stack.isEmpty() && stack.peek() == s.charAt(i)) stack.pop();
            else stack.push(s.charAt(i));
        }
        if (stack.isEmpty()) return 1;
        else return 0;
    }
}