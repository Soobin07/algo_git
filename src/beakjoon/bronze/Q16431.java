package src.beakjoon.bronze;

import java.util.*;

public class Q16431 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Br = sc.nextInt();
        int Bc = sc.nextInt();
        int Dr = sc.nextInt();
        int Dc = sc.nextInt();
        int Jr = sc.nextInt();
        int Jc = sc.nextInt();

        // Bessie: 8방향 → Chebyshev 거리
        int bessie = Math.max(Math.abs(Br - Jr), Math.abs(Bc - Jc));

        // Daisy: 4방향 → Manhattan 거리
        int daisy = Math.abs(Dr - Jr) + Math.abs(Dc - Jc);

        if (bessie < daisy) {
            System.out.println("bessie");
        } else if (bessie > daisy) {
            System.out.println("daisy");
        } else {
            System.out.println("tie");
        }
    }
}
