package BOJ;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_퇴사 {

    static int[] cost, period, dp;
    static int N, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());

        cost = new int[N+1];    // 0 dummy
        period = new int[N+1];
        dp = new int[N+2];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            period[i] = Integer.parseInt(st.nextToken());
            cost[i] = Integer.parseInt(st.nextToken());
        }

        solution();
        System.out.println(dp[N+1]); //최종 Max 값
    }

    static void solution() {
        for (int day=1; day<=N; day++) {
            int nextDay = day+period[day];
            if (nextDay <= N+1) {
                dp[nextDay] = Math.max(dp[nextDay], dp[day]+cost[day]);
            }
            dp[day+1] = Math.max(dp[day+1], dp[day]);
        }
    }
}
