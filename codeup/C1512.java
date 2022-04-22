package codeup;

import java.util.Scanner;

public class C1512 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        
        int[][] map = new int[n][n];
        map[x-1][y-1] = 1;
        
        boolean isContinue = true;
        while(isContinue){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(map[i][j] == 0) continue;
                    
                    if(i-1 >= 0 && map[i-1][j] == 0){
                        map[i-1][j] = map[i][j] + 1;
                    }
                    if(i+1 < n && map[i+1][j] == 0){
                        map[i+1][j] = map[i][j] + 1;
                    }
                    if(j-1 >= 0 && map[i][j-1] == 0){
                        map[i][j-1] = map[i][j] + 1;
                    }
                    if(j+1 < n && map[i][j+1] == 0){
                        map[i][j+1] = map[i][j] + 1;
                    }
                    
                }
            }
            
            isContinue = false;
            outer : for(int i = 0 ; i < n ; i++) {
            	for(int j = 0 ; j < n ; j++) {
            		if(map[i][j] == 0) {
            			isContinue = true;
            			break outer;
            		}
            	}
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}
