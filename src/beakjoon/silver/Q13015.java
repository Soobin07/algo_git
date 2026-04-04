package src.beakjoon.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Q13015 {

    static void printChar(char c, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int innerSpace = 2 * n - 3;

        printChar('*', n);
        printChar(' ', innerSpace);
        printChar('*', n);
        System.out.println();

        for (int i = 1; i < n - 1; i++) {
            printChar(' ', i);
            printChar('*', 1);
            printChar(' ', n - 2);
            printChar('*', 1);

            printChar(' ', innerSpace - 2 * i);

            printChar('*', 1);
            printChar(' ', n - 2);
            printChar('*', 1);
            System.out.println();
        }

        printChar(' ', n - 1);
        printChar('*', 1);
        printChar(' ', n - 2);
        printChar('*', 1);
        printChar(' ', n - 2);
        printChar('*', 1);
        System.out.println();

        for (int i = n - 2; i >= 1; i--) {
            printChar(' ', i);
            printChar('*', 1);
            printChar(' ', n - 2);
            printChar('*', 1);

            printChar(' ', innerSpace - 2 * i);

            printChar('*', 1);
            printChar(' ', n - 2);
            printChar('*', 1);
            System.out.println();
        }

        printChar('*', n);
        printChar(' ', innerSpace);
        printChar('*', n);
        System.out.println();
    }
}
