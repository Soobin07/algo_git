package beakjoon.bronze;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Q10699 {
	public static void main(String[] args) {
		ZonedDateTime nowSeoul = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println(nowSeoul.format(DateTimeFormatter.ofPattern("YYYY-MM-dd")));
	}
}
