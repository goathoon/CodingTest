package 구현;
import java.util.*;
public class pg_다단계칫솔판매

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String,Integer> peopleIdx = new HashMap<>();
        int i = 0;
        for(String s : enroll){
            peopleIdx.put(s,i++);
        }
        int[] answer = new int[enroll.length];

        for(int idx = 0; idx < seller.length; idx++){
            String moneyPeople = seller[idx];
            int getMoneyPeopleIdx = peopleIdx.get(moneyPeople);
            int money = amount[idx] * 100;

            while(true){
                if(money / 10 < 1){
                    answer[getMoneyPeopleIdx] += money;
                    break;
                }
                int getMoney = money - money / 10 ;
                answer[getMoneyPeopleIdx] += getMoney;
                //다음 추천인으로 이동
                moneyPeople = referral[getMoneyPeopleIdx];
                if(moneyPeople.equals("-")){
                    break;
                }
                getMoneyPeopleIdx = peopleIdx.get(moneyPeople);
                money -= getMoney;
            }
        }
        return answer;
    }
}{
}
