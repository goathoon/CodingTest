package 순열조합;
import java.io.*;
import java.util.*;
public class boj_20366 {
    static List<Man> man;
    static class Man{
        int idx1;
        int idx2;
        int sum;
        Man(int idx1, int idx2, int sum){
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.sum = sum;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] snow = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            snow[i] = Integer.parseInt(st.nextToken());
        }
        man = new ArrayList<>();
        combination(0,0,new ArrayList<>(),snow);
        Collections.sort(man,(m1,m2)->m1.sum-m2.sum);
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < man.size()-1; i++){
            Man x = man.get(i);
            Man y = man.get(i+1);
            if(x.idx1 == y.idx1 || x.idx1 == y.idx2 || x.idx2 == y.idx1 || x.idx2 == y.idx2) continue;
            ans = Math.min(y.sum - x.sum, ans);
        }
        System.out.println(man);
        System.out.println(ans);
    }

    public static void combination(int curIdx, int cnt, List<Integer> chooseIdx, int[] snow){

        if(cnt == 2){
            int x1 = chooseIdx.get(0);
            int x2 = chooseIdx.get(1);
            Man m = new Man(x1,x2,snow[x1] + snow[x2]);
            man.add(m);
            return;
        }
        if(curIdx == snow.length) return;

        for(int i = curIdx; i < snow.length; i++){
            chooseIdx.add(i);
            combination(i+1,cnt+1,chooseIdx,snow);
            chooseIdx.remove(Integer.valueOf(i));
        }
    }
}
