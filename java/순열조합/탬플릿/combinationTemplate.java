package 순열조합.탬플릿;

// Back Tracking 으로 구현한 조합입니다
public class combinationTemplate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        boolean[] visited = new boolean[arr.length];
        // arr의 배열에서 2개의 원소를 뽑는 경우의 수
        combination(arr,visited,0,0,2);
        
    }
    static void combination(int[] arr, boolean[] visited, int startIdx, int cnt, int targetCnt){
        if (cnt == targetCnt){
            for (int i = 0; i < arr.length; i ++){
                if(visited[i]){
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        

        for (int idx = startIdx; idx < arr.length; idx ++){
            if (visited[idx] == false){
                visited[idx] = true;
                combination(arr,visited,idx+1,cnt+1,targetCnt);
                visited[idx] = false;
            }
        }
    }
}
