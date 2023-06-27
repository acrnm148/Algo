import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int ans = 0;
        for (int i=1; i<=n; i++) {
            int sum = i;
            int num = i;
            while (sum <= n) {
                if (sum == n) ans++;
                num++;
                sum += num;
            }
        }
        
        return ans;
    }
}