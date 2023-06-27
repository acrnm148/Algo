import java.io.*;
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        PriorityQueue<Integer> a = new PriorityQueue<> (); //오름차순 정렬 우선순위큐
        PriorityQueue<Integer> b = new PriorityQueue<> ((o1,o2) -> o2-o1); //내림차순 정렬 우선순위큐
        int ans = 0;
        
        for (int i=0; i<A.length; i++) {
            a.add(A[i]); //A는 오름차순 정렬
            b.add(B[i]); //B는 내림차순 정렬
        }
        
        while (!a.isEmpty()) {
            ans += a.poll() * b.poll(); //정렬된 두 값끼리 곱한 후 더함. 오름차순, 내림차순을 바꿔주어도 결과는 동일
        }
        System.out.println(ans);
        return ans;
    }
}
