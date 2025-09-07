package beakjoon.bronze;

import java.util.Scanner;

public class Q1296 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        
        String yName = sc.next();
        int n = sc.nextInt();
        
        int L = 0, O = 0, V = 0, E = 0;
        for (int i = 0; i < yName.length(); i++) {
            char c = yName.charAt(i);
            if (c == 'L') L++;
            else if (c == 'O') O++;
            else if (c == 'V') V++;
            else if (c == 'E') E++;
        }
        
        String bestTeam = "";
        int bestProbability = -1;
        
        for (int i = 0; i < n; i++) {
            String team = sc.next();
            int countL = L, countO = O, countV = V, countE = E;
            for (int j = 0; j < team.length(); j++) {
                char c = team.charAt(j);
                if (c == 'L') countL++;
                else if (c == 'O') countO++;
                else if (c == 'V') countV++;
                else if (c == 'E') countE++;
            }
            
            int probability = ((countL + countO) * (countL + countV) * (countL + countE) *
                               (countO + countV) * (countO + countE) * (countV + countE)) % 100;
            
            if(probability > bestProbability) {
                bestProbability = probability;
                bestTeam = team;
            } else if(probability == bestProbability) {
                if(team.compareTo(bestTeam) < 0) {
                    bestTeam = team;
                }
            }
        }
        
        System.out.println(bestTeam);
	}
}
