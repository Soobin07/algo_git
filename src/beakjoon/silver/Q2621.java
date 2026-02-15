package src.beakjoon.silver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q2621 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] color = new char[5];
        int[] number = new int[5];
        int[] count = new int[10];
        
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            color[i] = st.nextToken().charAt(0);
            number[i] = Integer.parseInt(st.nextToken());
            count[number[i]]++;
        }

        Arrays.sort(number);

        boolean isFlush = true;
        for (int i = 1; i < 5; i++) {
            if (color[i] != color[0]) {
                isFlush = false;
                break;
            }
        }

        boolean isStraight = true;
        for (int i = 1; i < 5; i++) {
            if (number[i] != number[i - 1] + 1) {
                isStraight = false;
                break;
            }
        }

        int four = 0;
        int three = 0;
        int pairCount = 0;
        int firstPair = 0;
        int secondPair = 0;

        for (int i = 1; i <= 9; i++) {
            if (count[i] == 4) {
                four = i;
            } else if (count[i] == 3) {
                three = i;
            } else if (count[i] == 2) {
                pairCount++;
                if (firstPair == 0) firstPair = i;
                else secondPair = i;
            }
        }

        int result = 0;

        if (isFlush && isStraight) {
            result = 900 + number[4];
        }else if (four != 0) {
            result = 800 + four;
        }else if (three != 0 && pairCount == 1) {
            result = 700 + three * 10 + firstPair;
        }else if (isFlush) {
            result = 600 + number[4];
        }else if (isStraight) {
            result = 500 + number[4];
        }else if (three != 0) {
            result = 400 + three;
        }else if (pairCount == 2) {
            int high = Math.max(firstPair, secondPair);
            int low = Math.min(firstPair, secondPair);
            result = 300 + high * 10 + low;
        }else if (pairCount == 1) {
            result = 200 + firstPair;
        }else {
            result = 100 + number[4];
        }

        System.out.println(result);
    }
}
