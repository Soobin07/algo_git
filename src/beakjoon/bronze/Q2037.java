package src.beakjoon.bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2037 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] pw = br.readLine().split(" ");
        int p = Integer.parseInt(pw[0]);
        int w = Integer.parseInt(pw[1]);
        
        String str = br.readLine();
        
        int[] button = new int[26];
        int[] press = new int[26];
        
        String[] groups = {
            "ABC", "DEF", "GHI", "JKL", "MNO",
            "PQRS", "TUV", "WXYZ"
        };
        
        for (int i = 0; i < groups.length; i++) {
            String g = groups[i];
            for (int j = 0; j < g.length(); j++) {
                char c = g.charAt(j);
                button[c - 'A'] = i;
                press[c - 'A'] = j + 1;
            }
        }
        
        int prevButton = -1;
        int total = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            int currButton;
            int currPress;
            
            if (c == ' ') {
                currButton = -1;
                currPress = 1;
            } else {
                currButton = button[c - 'A'];
                currPress = press[c - 'A'];
            }
            
            if (i > 0 && currButton == prevButton) {
                total += w;
            }
            
            total += currPress * p;
            prevButton = currButton;
        }
        
        System.out.println(total);
    }
}
