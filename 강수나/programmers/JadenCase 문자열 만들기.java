import java.io.;
import java.util.;

class Solution {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char last = '0';
        for (int i=0; i<len; i++) {
            char c = s.charAt(i);
            if (i==0 && (c='a' && c='z')) { //첫 문자(시작) && 소문자 => 대문자
                sb.append((char)(c-32));
            } 
            else if (i!=0 && last==' ' && (c='a' && c='z')) { //첫 문자 && 소문자 => 대문자
                sb.append((char)(c-32));
            }
            else if (i!=0 && last!=' ' && (c='A' && c='Z')) { //첫 문자X && 대문자 => 소문자
                sb.append((char)(c+32));
            }
            else {
                sb.append(c);
            }
            last = c; //이전 문자가 공백인지 확인하기 위함
        }

        System.out.println(sb);
        return sb.toString();
    }
}
