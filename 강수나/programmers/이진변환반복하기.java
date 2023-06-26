import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int turn = 0;
        int cnt = 0;
        int total_len = 0;
        StringBuilder str2 = new StringBuilder(s);
        
        while(true) {
            turn++;
            StringBuilder str1 = new StringBuilder();
            total_len = str2.length();
            for (int i=0; i<total_len; i++) {
                if (str2.charAt(i) == '0') cnt++;
                else str1.append(1);
            }
            int len = str1.length();
            str2 = new StringBuilder();
            while (len != 0) {
                str2.append(len%2);
                len /= 2;
            }
            System.out.println(str2);
            if (str2.toString().equals("1")) break;
        }
        return new int[] {turn, cnt};
    }
}