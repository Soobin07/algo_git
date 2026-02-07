package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q30017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken()); 
        int B = Integer.parseInt(st.nextToken()); 

        if (A - 1 <= B) {
            System.out.println(A + (A - 1));
        } else {
            System.out.println(B + (B + 1));
        }

        br.close();
    }
}
