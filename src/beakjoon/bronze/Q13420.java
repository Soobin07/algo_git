package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q13420 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] arr = br.readLine().split(" ");

            BigInteger A = new BigInteger(arr[0]);
            String op = arr[1];
            BigInteger B = new BigInteger(arr[2]);
            BigInteger C = new BigInteger(arr[4]);

            BigInteger result;

            switch (op) {
                case "+":
                    result = A.add(B);
                    break;
                case "-":
                    result = A.subtract(B);
                    break;
                case "*":
                    result = A.multiply(B);
                    break;
                case "/":
                    result = A.divide(B); // 문제 조건상 항상 나누어떨어짐
                    break;
                default:
                    result = BigInteger.ZERO;
            }

            if (result.equals(C)) {
                System.out.println("correct");
            } else {
                System.out.println("wrong answer");
            }
        }
    }
}
