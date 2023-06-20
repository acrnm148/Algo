import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        int[] intArr = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(intArr);
        sb.append(intArr[0]).append(' ').append(intArr[arr.length-1]);
        return sb.toString();
    }
}
