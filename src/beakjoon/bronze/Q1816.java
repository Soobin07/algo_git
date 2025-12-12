package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q1816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int MAXP = 1_000_000;

        boolean[] isPrime = new boolean[MAXP + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= MAXP; i++) {
            if (isPrime[i]) {
                primes.add(i);
                if ((long)i * i <= MAXP) {
                    for (int j = i * i; j <= MAXP; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            long S = Long.parseLong(br.readLine());
            boolean ok = true;

            for (int p : primes) {
                long pl = (long)p;
                if (pl * pl > S) break;
                if (S % pl == 0) {
                    ok = false;
                    break;
                }
            }

            sb.append(ok ? "YES" : "NO").append('\n');
        }

        System.out.print(sb.toString());
    }
}
