package 순열조합.탬플릿;

import java.io.BufferedInputStream;
import java.io.InputStream;


public class permutationTemplate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        boolean [] visited = new boolean[arr.length];
        int choice = 3;
        int [] result = new int[choice];
        permutation(arr,visited,result,0,0,choice);
    }
    static void permutation(int[] arr, boolean[] visited, int[] output, int startIdx, int cnt,int targetCnt){
        if  (cnt == targetCnt){
            printResult(output);
            return;
        }
        for (int i = startIdx; i< arr.length; i ++){
            if(!visited[i]){
                visited[i] = true;
                output[cnt] = arr[i];
                permutation(arr,visited,output,startIdx+1,cnt+1,targetCnt);
                visited[i] = false;
            }
        }
    }
    static void printResult(int[] output){
        for(int x : output){
            System.out.print(x +" ");
        }
        System.out.println();
    }
}
