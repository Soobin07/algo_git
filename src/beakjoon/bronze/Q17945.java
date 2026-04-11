package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q17945 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int D = A * A - B; 
        int sqrtD = (int)Math.sqrt(D);

        int x1 = -A - sqrtD;
        int x2 = -A + sqrtD;

        if (x1 == x2) {
            System.out.println(x1);
        } else {
            System.out.println(x1 + " " + x2);
        }
    }
}
