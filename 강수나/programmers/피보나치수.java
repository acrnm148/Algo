

class Solution {
        static int[] dp = new int[100001];
    public int solution(int n) {
        int ans = fibo(n);
        return ans;
    }
    
    /*
    모듈러 연산
    (a+b)%c = a%c + b%c
    */
    public int fibo(int n) {
        dp[1]=1;
        dp[2]=1;
        for (int i=3; i<=n; i++) {
            dp[i] = dp[i-1]%1234567+dp[i-2]%1234567;
        }
        return dp[n]%1234567;
    }
}