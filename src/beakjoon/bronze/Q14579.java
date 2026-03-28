package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14579 {
    static final int MOD = 14579;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int sum = a * (a + 1) / 2;
        sum %= MOD;

        int result = sum;

        for (int i = a + 1; i <= b; i++) {
            sum += i;  
            sum %= MOD;

            result *= sum;
            result %= MOD;
        }

        System.out.println(result);
    }
}
