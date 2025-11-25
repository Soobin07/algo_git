package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q9536 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); 

        while (T-- > 0) {

            String[] recorded = br.readLine().split(" ");

            Set<String> notFoxSounds = new HashSet<>();

            while (true) {
                String line = br.readLine();

                if (line.equals("what does the fox say?"))
                    break;

                String[] parts = line.split(" ");
                notFoxSounds.add(parts[2]);
            }

            StringBuilder sb = new StringBuilder();
            for (String sound : recorded) {
                if (!notFoxSounds.contains(sound)) {
                    sb.append(sound).append(" ");
                }
            }

            System.out.println(sb.toString().trim());
        }
    }
}
