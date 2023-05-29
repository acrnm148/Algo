package Softeer;

import java.util.*;
import java.io.*;


public class Lv2회의실예약
{

    static int N,M;
    static Map<String, int[][]> reservation = new TreeMap<> ();
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i=0; i<N; i++) {
            int[][] tmp = new int[9][2];
            for (int j= 0; j<9; j++) {
                tmp[j][0] = j+9;      //시작시간
                tmp[j][1] = j+9+1;    //끝시간
            }
            reservation.put(br.readLine(), tmp);
        } 
        for (int j=0; j<M; j++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int[][] checked = reservation.get(name); //복사가 아님. 수정하면 원본이 수정된다?
            for (int t = start; t<end; t++) {
                checked[t-9][0] = -1; //예약완료
                checked[t-9][1] = -1; //예약완료
            }
        } //입력 끝
        
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, int[][]> entry : reservation.entrySet()) {
            sb.append("Room ").append(entry.getKey()).append(":").append("\n");
            StringBuilder tmpSb = new StringBuilder();

            int[][] checked = entry.getValue();
            int cnt = 0;
            int start = -1;
            int end = -1;
            for (int i = 0; i<9; i++) {
                if (checked[i][0] != -1) {
                    if (start == -1) {
                        start = checked[i][0];
                    }
                } else {
                    if (start != -1) {
                        end = checked[i-1][1];
                    }
                }
                if (start != -1 && end != -1) {
                    tmpSb.append(start==9?"09":start).append("-").append(end).append("\n");
                    start = -1;
                    end = -1;
                    cnt++;
                }
            }

            if (start != -1) {
                cnt++;
                tmpSb.append(start==9? "09":start).append("-").append(18).append("\n");
            }

            if (cnt == 0) {
                sb.append("Not available").append("\n");
            } else {
                sb.append(cnt).append(" available:").append("\n");
                sb.append(tmpSb);
            }
            sb.append("-----").append("\n");
        }
        sb.setLength(sb.length()-6); //길이조절로 마지막줄 -----\n을 자른다.
        System.out.println(sb);
    }
}
