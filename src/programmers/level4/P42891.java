package programmers.level4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//무지의 먹방 라이브
//정확도 100, 효율성 100
public class P42891 {
	class Food {
        int idx;
        long times;

        public Food(int idx, long times){
            this.idx = idx;
            this.times = times;
        }
        public long minus_time(long minus){
            this.times -= minus;
            return times;
        }
    }
    public int solution(int[] food_times, long k) {
        int answer = 0;
        // food_times 전체를 계속 도는 것은 비효율적
        // 남은 것만 보자
        ArrayList<Food> list = new ArrayList<>();

        // 만약 전체 먹는 시간 다 더해도 k보다 작으면 식사 종료
        // 최대 먹는 시간 200_000 * 100_000_000; long 벗어남
        long total = 0L;
        for(int i = 0 ; i < food_times.length ; i++){
            Food f = new Food(i+1, food_times[i]);
            list.add(f);
            total += food_times[i];
        }

        //음식 다 먹어도 k보다 작거나 같다 = 다음에 먹을 것이 없다
        //total이 0보다 작으면 overflow이다. k보다 무조건 크다
        if(total >= 0 && k >= total)
            return -1;


        //시간 짧은 것은 뒤로 (없애기 쉽게)
        Collections.sort(list, new Comparator<Food>() {
            @Override
            public int compare(Food f1, Food f2) {
                if (f1.times < f2.times) {
                    return 1;
                } else if (f1.times > f2.times) {
                    return -1;
                }
                return 0;
            }
        });

        long away = 0;	//전체 공통으로 날리는거
        boolean flag = false;

        while(k >= list.size()){
            if(!flag){
                //남은 시간이 가장 작은 음식을 가져와서 지난 시간을 날린다
                long left_t = list.get(list.size() - 1).minus_time(away);
                //다 먹은거면 없애고 넘기자
                if(left_t <= 0){
                    list.remove(list.size()-1);
                    continue;
                }
            }
            //가장 작은 시간이 남은 것을 가져온다
            long min_t = list.get(list.size() - 1).times;
            //k - 전체 * 남은 시간
            k -= min_t * (long) list.size();
            //너무 많이 없어졌을 경우를 대비하여 마지막 음식 넣어둠
            Food lastFood = list.remove(list.size()-1);
            //남은 시간 더 없애자
            away += min_t;

            //너무 많이 날렸을 경우
            if(k < 0){
                //이전으로 복구
                k += min_t * (long)(list.size() + 1);
                list.add(lastFood);
                break;
            }

            //이제 마지막 남은 Food를 잡아라. 서든데스
            if(k < list.size()){
                while(true){
                    //남은 Food에서 먹은 시간 정리
                    list.get(list.size() - 1).minus_time(away);
                    //0보다 크면 가장 시간 작은거 가져와서 하나씩 없앤다
                    if(list.get(list.size() - 1).times > 0){
                        flag = true;
                        break;   
                    }
                    //0보다 작으면 다 먹은거니 없애라
                    list.remove(list.size() -1);
                }
            }
        }

        //idx별로 다시 정리
        Collections.sort(list, new Comparator<Food>(){
            @Override
            public int compare(Food f1, Food f2){
                if(f1.idx < f2.idx)
                    return -1;
                else if(f1.idx > f2.idx)
                    return 1;
                return 0;
            }
        });

        //하나씩 먹어서 남은 idx
        k = k%(long)list.size();
        return list.get((int)k).idx;
    }
}
