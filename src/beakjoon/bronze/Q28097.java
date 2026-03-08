package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q28097 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int total = 0;
        
        for(int i = 0; i < N; i++){
            total += Integer.parseInt(st.nextToken());
        }
        
        total += 8 * (N - 1); // 공부 사이 휴식
        
        int day = total / 24;
        int hour = total % 24;
        
        System.out.println(day + " " + hour);
    }
}
