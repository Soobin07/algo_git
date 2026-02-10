package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q32929 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int r = x % 3;

        if (r == 1) {
            System.out.println("U");
        } else if (r == 2) {
            System.out.println("O");
        } else {
            System.out.println("S");
        }
    }
}
