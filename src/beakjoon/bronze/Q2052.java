package src.beakjoon.bronze;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Q2052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        BigDecimal two = new BigDecimal("2");
        BigDecimal result = BigDecimal.ONE.divide(
                two.pow(N),
                300,              // 충분히 큰 자리수
                RoundingMode.HALF_UP
        );

        // 뒤에 불필요한 0 제거
        result = result.stripTrailingZeros();

        System.out.println(result.toPlainString());
    }
}
