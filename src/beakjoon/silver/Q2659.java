pakcage src.beakjoon.silver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2659 {
    static int getClockNum(int n) {
        int min = n;
        int x = n;

        for (int i = 0; i < 3; i++) {
            x = (x % 1000) * 10 + (x / 1000);  
            if (x < min) {
                min = x;
            }
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int inputNum = 0;
        for (int i = 0; i < 4; i++) {
            inputNum = inputNum * 10 + Integer.parseInt(st.nextToken());
        }

        int target = getClockNum(inputNum);

        int count = 0;
        for (int i = 1111; i <= target; i++) {
            if (String.valueOf(i).contains("0")) {
                continue;
            }
            if (getClockNum(i) == i) {
                count++;
            }
        }
        System.out.println(count);
    }
}
