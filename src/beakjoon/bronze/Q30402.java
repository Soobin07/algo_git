package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q30402 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean hasW = false;
        boolean hasB = false;
        boolean hasG = false;

        for (int i = 0; i < 15; i++) {
            String line = br.readLine().replace(" ", "");
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (c == 'w') hasW = true;
                if (c == 'b') hasB = true;
                if (c == 'g') hasG = true;
            }
        }

        if (hasW) System.out.println("chunbae");
        else if (hasB) System.out.println("nabi");
        else if (hasG) System.out.println("yeongcheol");
    }
}
