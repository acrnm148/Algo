import java.io.*;
import java.util.*;
/*
시간복잡도: 
1. StringBuilder 2개를 사용
     -- 맨 처음 시작할 땐 str2에 s를 넣고 시작
     1) str2에서 0 제거한 문자열을 str1에 넣음
     2) str1의 길이를 이진수로 변환한 값을 str2에 넣음
     -- 반복
*/
class Solution {
    public int[] solution(String s) {
        int turn = 0; //반복 횟수
        int cnt = 0; //제거된 0 개수
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
            while (len != 0) { //나누어떨어진 값이 0이 나오면 break
                str2.append(len%2);
                len /= 2;
            }
            System.out.println(str2);
            if (str2.toString().equals("1")) break; //길이를 변환한 이진수가 1일 때 break
        }
        return new int[] {turn, cnt};
    }
}
