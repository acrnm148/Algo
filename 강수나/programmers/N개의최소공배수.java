import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int[] arr)
    {
        int answer = 0;
        if (arr.length == 1) return arr[0];
        
        answer = arr[0]*arr[1] / gcd(arr[0], arr[1]);
        
        if (arr.length > 2) {
            for (int i=0; i<arr.length; i++) {
                answer = answer * arr[i] / gcd(answer, arr[i]);
            }   
        }
        
        return answer;
    }
    
    // 최대공약수
    private static int gcd(int a, int b) {
        int mod = a%b;
        if (mod == 0) return b;
        return gcd(b, mod);
    }
}
