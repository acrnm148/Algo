import java.io.;
import java.util.;

class Solution {
    
      1. split으로 문자열 배열로 저장
          1. 각각 for문 돌면서
              1. 첫 문자가 a~z일 때 A~Z로 변경
              2. 뒷 문자들이 A~Z일 때 a~z로 변경
     
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        char last = '0';
        for (int i=0; ilen; i++) {
            char c = s.charAt(i);
            if (i==0 && (c='a' && c='z')) {
                sb.append((char)(c-32));
            } 
            else if (i!=0 && last==' ' && (c='a' && c='z')) {
                sb.append((char)(c-32));
            }
            else if (i!=0 && last!=' ' && (c='A' && c='Z')) {
                sb.append((char)(c+32));
            }
            else {
                sb.append(c);
            }
            last = c;
        }

        System.out.println(sb);
        return sb.toString();
    }
}
