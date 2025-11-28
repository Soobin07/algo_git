package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String plain = br.readLine();
        String key = br.readLine();

        StringBuilder sb = new StringBuilder();
        int keyPos = 0;

        for (int i = 0; i < plain.length(); i++) {
            char p = plain.charAt(i);
            char k = key.charAt(keyPos % key.length());
            keyPos++; 

            if (p == ' ') { 
                sb.append(' '); 
                continue;
            }

            int pIdx = p - 'a';
            int kIdx = (k - 'a') + 1; // shift = keyIndex+1

            int cIdx = (pIdx - kIdx + 26) % 26;

            sb.append((char)(cIdx + 'a'));
        }

        System.out.println(sb.toString());
    }
}
