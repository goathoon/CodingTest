package 구현;

public class pg_양궁대회 {
    class Solution {
        static int[] answer = new int[11];
        static int diff = 0;
        public int[] solution(int n, int[] info) {
            int[] shooted = new int[11];
            shoot(n,0,0,info,shooted);
            if(diff == 0){
                return new int[]{-1};
            }
            else{
                System.out.println(diff);
                return answer;
            }
        }
        static void shoot(int n, int curN, int curIdx, int[] info, int[] shooted){
            if(curN == n || curIdx == info.length){
                calDiff(n,info,shooted);
                return;
            }

            for(int i = curIdx; i < info.length; i++){

                int shootByApeach = info[i];
                if(shootByApeach + 1 <= n-curN){
                    shooted[curIdx] = shootByApeach + 1;
                    shoot(n,curN + shootByApeach+1, i+1,info,shooted);
                }
                shooted[curIdx] = 0;
                shoot(n,curN,i+1,info,shooted);
            }
        }
        static void calDiff(int n, int[] info, int[] shooted){
            int apeach = 0;
            int lion = 0;
            int shootLion = 0;
            for(int i = 0; i < info.length; i ++){
                shootLion += shooted[i];
                if (info[i] < shooted[i]){
                    lion += 10 - i;
                }
                else {
                    if(info[i] != 0) apeach += 10 - i;
                }
            }
            if (lion > apeach){
                if (diff < lion - apeach){
                    if (shootLion < n){
                        shooted[info.length-1] = n - shootLion;
                    }
                    System.arraycopy(shooted,0,answer,0,shooted.length);
                    shooted[info.length-1] = 0;
                    diff = lion - apeach;
                }
                else if (diff == lion - apeach){
                    if (shootLion < n){
                        shooted[info.length-1] = n - shootLion;
                    }
                    for(int i = 10; i >= 0 ; i--){
                        if (answer[i] < shooted[i]){
                            System.arraycopy(shooted,0,answer,0,shooted.length);
                            break;
                        }
                        //여기서 디버깅 했어야함. 기존 답에서 낮은 점수를 더 많이 맞췄을 경우 바로 break해야함
                        else if (answer[i] > shooted[i]){
                            break;
                        }
                    }
                    shooted[info.length-1] = 0;
                }
            }

        }
    }
}
