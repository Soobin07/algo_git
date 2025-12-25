package src.beakjoon.bronze;
import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class  {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            BigInteger A = new BigInteger(a, 2);
            BigInteger B = new BigInteger(b, 2);

            sb.append(A.add(B).toString(2)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
