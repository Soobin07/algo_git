package src.beakjoon.bronze;
import java.io.*;
import java.util.*;

public class Q9946{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1, s2;
        int caseNum = 1;

        while (true) {
            s1 = br.readLine();
            s2 = br.readLine();

            if (s1.equals("END") && s2.equals("END")) {
                break;
            }

            char[] a = s1.toCharArray();
            char[] b = s2.toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            if (Arrays.equals(a, b)) {
                System.out.println("Case " + caseNum + ": same");
            } else {
                System.out.println("Case " + caseNum + ": different");
            }

            caseNum++;
        }
    }
}
