package BOJ;

import java.io.*;
import java.util.*;

public class BOJ_14503_로봇청소기 {

    static int[][] map, visited;
    static int N, M, ans, sy, sx, sd;

    static int[] dy = {-1,0,1,0};   //북동남서
    static int[] dx = {0,1,0,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        map = new int[N][M];
        visited = new int[N][M];

        st = new StringTokenizer(br.readLine());
        sy = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());
        sd = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 1;
        dfs(sy, sx, sd);
        System.out.println(ans);
    }

    static void dfs(int sy, int sx, int sd) {
        visited[sy][sx] = 1;

        for (int d=0; d<4; d++) {
            sd = (sd+3) % 4;    //현재 방향 기준 반시계방향 90도 회전 -> 매 턴마다 바뀜 -> 결국 한 바퀴
            int ny = sy+dy[sd];
            int nx = sx+dx[sd];
            if (ny<0 || ny>=N || nx<0 || nx>=M || map[ny][nx]==1 || visited[ny][nx]==1) continue;
            ans++;
            visited[ny][nx] = 1;
            dfs(ny, nx, sd);
            return; //리턴해주지 않으면 dfs 끝나고 다시 돌아오면서 다른 방향으로 새게 된다.
        }

        //네 방향 모두 청소했을 때 현재지점에서 후진
        int bd = (sd+2) % 4;
        int by = sy+dy[bd];
        int bx = sx+dx[bd];
        if (by>=0 && by<N && bx>=0 && bx<M && map[by][bx]!=1) {
            dfs(by, bx, sd);
        }
    }
}
