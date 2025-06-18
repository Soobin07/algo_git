package beakjoon.bronze;

import java.util.Scanner;

public class Q30676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans = "";
		int mm = sc.nextInt();

		if (mm >= 620 && mm <= 780) {
			ans = "Red";
		} else if (mm >= 590 && mm < 620) {
			ans = "Orange";
		} else if (mm >= 570 && mm < 590) {
			ans = "Yellow";
		} else if (mm >= 495 && mm < 570) {
			ans = "Green";
		} else if (mm >= 450 && mm < 495) {
			ans = "Blue";
		} else if (mm >= 425 && mm < 450) {
			ans = "Indigo";
		} else if (mm >= 380 && mm < 425) {
			ans = "Violet";
		}

		System.out.println(ans);
	}
}
