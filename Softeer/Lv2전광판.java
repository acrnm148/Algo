import java.util.*;
import java.io.*;


public class Main
{
    static int T;
    static char[] A, B;
    static int[][] num = {
       //0 1 2 3 4 5 6
        {1,1,1,1,1,1,0}, //0
        {0,1,1,0,0,0,0}, //1
        {1,1,0,1,1,0,1}, //2
        {1,1,1,1,0,0,1}, //3
        {0,1,1,0,0,1,1}, //4
        {1,0,1,1,0,1,1}, //5
        {1,0,1,1,1,1,1}, //6
        {1,1,1,0,0,1,0}, //7
        {1,1,1,1,1,1,1}, //8
        {1,1,1,1,0,1,1}  //9
    };

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            StringBuilder sb = new StringBuilder();
            sb.append(st.nextToken());
            String strA = sb.reverse().toString();

            sb = new StringBuilder();
            sb.append(st.nextToken());
            String strB = sb.reverse().toString();

            A = strA.toCharArray();
            B = strB.toCharArray();
            int lenA = strA.length();
            int lenB = strB.length();
            int ans = 0;

            if (lenA < lenB) {
                for (int i=0; i<lenA; i++) {
                    int nowA = A[i]-'0';
                    int nowB = B[i]-'0';
                    ans += change(nowA, nowB);
                }
                for (int i=lenA; i<lenB; i++) {
                    int nowB = B[i]-'0';
                    for (int j=0; j<7; j++) {
                        if (num[nowB][j] == 1) ans++;
                    }
                }
            }
            else if (lenA == lenB) {
                for (int i=0; i<lenA; i++) {
                    int nowA = A[i]-'0';
                    int nowB = B[i]-'0';
                    ans += change(nowA, nowB);
                }
            }
            else if (lenA > lenB) {
                for (int i=0; i<lenB; i++) {
                    int nowA = A[i]-'0';
                    int nowB = B[i]-'0';
                    ans += change(nowA, nowB);
                }
                for (int i=lenB; i<lenA; i++) {
                    int nowA = A[i]-'0';
                    for (int j=0; j<7; j++) {
                        if (num[nowA][j] == 1) ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    static int change(int nowA, int nowB) {
            int cnt = 0;
            for (int i=0; i<7; i++) {
                if (num[nowB][i] == 0) {
                    if (num[nowA][i] == 1) {
                        cnt++;
                    }
                }
                else if (num[nowB][i] == 1) {
                    if (num[nowA][i] == 0) {
                        cnt++;
                    }
                }
            }
            return cnt;
        }
}
