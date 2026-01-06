package src.beakjoon.bronze;
import java.io.*;

public class Q1864 {
    static int value(char c) {
        switch (c) {
            case '-': return 0;
            case '\\': return 1;
            case '(': return 2;
            case '@': return 3;
            case '?': return 4;
            case '>': return 5;
            case '&': return 6;
            case '%': return 7;
            case '/': return -1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (!(line = br.readLine()).equals("#")) {
            int result = 0;
            for (char c : line.toCharArray()) {
                result = result * 8 + value(c);
            }
            System.out.println(result);
        }
    }
}
