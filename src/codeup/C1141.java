package codeup;

import java.util.Scanner;

public class C1141 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cards = new int[sc.nextInt()];
        for(int i = 0 ; i < cards.length-1 ; i++){
            cards[sc.nextInt()-1] = 1;
        }
        for(int i = 0 ; i < cards.length-1 ; i++){
            if(cards[i] == 0) {
                System.out.println(i+1); break;
            }
        }
	}
}
