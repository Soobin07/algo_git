package sw.d2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//종현이 답
public class SWEA1926_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    List<String> list = new ArrayList<>();

	    //숫자를 string으로 받음
	    for (int i = 0; i < n; i++) {
	        list.add(Integer.toString(i + 1));
	    }

	    StringBuilder ans = new StringBuilder();
	    
	    //list를 하나씩 보면서 3,6,9가 들어간 str의 3,6,9를 정규식으로 "-"로 바꿔줌(나머지 숫자는 없애줌)
	    for (int j = 0; j < list.size(); j++) {
	        String str = list.get(j);
	        if (str.contains("3") || str.contains("6") || str.contains("9")) {
		        str = str.replaceAll("[369]", "-");
		        str = str.replaceAll("[1245780]", "");
	        }
	        ans.append(str + " ");
	    }
	    System.out.println(ans);
    }
}
