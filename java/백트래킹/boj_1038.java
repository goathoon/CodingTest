package 백트래킹;
import java.io.*;
import java.util.*;
public class boj_1038 {
    static int N;
    static int rank;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        rank = -1;
        long ans = -1;
        for(int totalLength = 1; totalLength <= 10; totalLength++){
            long returnVal = dfs(-1,0,totalLength);
            if(returnVal != -1) {
                ans = returnVal;
                break;
            }
        }
        System.out.println(ans);
    }

    public static long dfs(long number, int curLength, int length){
        if(curLength == length) rank++;
        if(rank == N) return number;

        // 첫째자리수 채우기
        if(number == -1){
            for(int first = length-1; first <= 9; first++){
                if(curLength+1 > length) continue;
                long ans = dfs(first,curLength+1,length);
                if(ans != -1){
                    return ans;
                }
            }
            return -1;
        }
        // 나머지 자리 채우기
        else{
            long lastDigit = number%10;
            for(int nextDigit = 0; nextDigit <= lastDigit-1; nextDigit++){
                if(curLength+1 > length) continue;
                long ans = dfs(number*10+nextDigit,curLength+1,length);
                if(ans != -1){
                    return ans;
                }
            }
            return -1;
        }
    }
}
