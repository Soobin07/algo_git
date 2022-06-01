package programmers.level1;

import java.util.ArrayList;
import java.util.List;

//효율성 0점 ㅠㅠ
public class P42576 {
	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"}; 
		String[] completion = {"eden", "kiki"};
		
		List list = new ArrayList();
        for(int i = 0 ; i < participant.length ; i++){
            list.add(participant[i]);
        }
        for(int i = 0 ; i < completion.length ; i++){
        	list.remove(completion[i]);
        }
        
        String str = list.get(0).toString();
        
        System.out.println(str);
		
	}
}
