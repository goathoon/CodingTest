package 순열조합;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class boj_1759 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        int length = Integer.parseInt(st.nextToken());
        int totalLength = Integer.parseInt(st.nextToken());
        char[] chars = new char[totalLength];
        boolean[] visited = new boolean[totalLength];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<totalLength; i ++){
            chars[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(chars);
        dfs(chars,visited,0,0,0,length);
    }
    public static void dfs(char[] array, boolean[] visited, int startIdx, int vCount, int cur, int target ){
        if (cur == target){
            if (vCount == 0 || target - vCount < 2) return;
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < visited.length; i++){
                if (visited[i] == true){
                    sb.append(array[i]);
                }
            }
            System.out.println(sb.toString());
        }

        for(int idx = startIdx; idx < array.length; idx++){
            if (visited[idx] == true){
                continue;
            }
            boolean isVowel = isVowel(array[idx]);
            visited[idx] = true;
            if(isVowel) vCount ++;
            dfs(array,visited,idx,vCount,cur+1,target);
            visited[idx] = false;
            if(isVowel) vCount --;
        }
    }
    public static boolean isVowel(char c){
        return "aeiou".indexOf(c) != -1;
    }

}
