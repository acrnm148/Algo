import java.io.*;
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        PriorityQueue<Integer> a = new PriorityQueue<> ();
        PriorityQueue<Integer> b = new PriorityQueue<> ((o1,o2) -> o2-o1);
        int ans = 0;
        
        for (int i=0; i<A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }
        
        while (!a.isEmpty()) {
            ans += a.poll() * b.poll();
        }
        System.out.println(ans);
        return ans;
    }
}