package 분할정복;
import java.io.*;
import java.util.*;
public class boj_10830 {
    static long[][] originArr ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long count = Long.parseLong(st.nextToken());
        long [][] arr = new long[N][N];
        originArr = new long[N][N];
        for(int i = 0; i< N; i ++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j<N; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
                originArr[i][j] = arr[i][j];
            }
        }
        long[][] result = pow(arr,count);


        for( int r = 0; r< arr.length; r ++){
            for (int c = 0; c< arr[0].length; c++){
                System.out.printf("%d ", result[r][c] % 1000);
            }
            System.out.println();
        }
    }
    public static long[][] pow(long[][] result, long count){
        if (count == 1){
            return result;
        }
        if (count % 2 ==0L){
            // 불필요한 pow 계산. 하나로 처리할 수 있음.
//            return multiplyMatrix(pow(result,count/2),pow(result,count/2));
            return squareMatrix(pow(result,count/2));
        }
        else{
//            return multiplyMatrix(multiplyMatrix(pow(result,count/2),pow(result,count/2)),originArr);
            return multiplyMatrix(squareMatrix(pow(result,count/2)),originArr);
        }
    }
    public static long[][] multiplyMatrix(long[][] mat1, long[][] mat2){
        long[][] result = new long[mat1.length][mat1[0].length];
        for (int r = 0; r < mat1.length; r ++){
            for (int c = 0; c < mat1[0].length; c++){
                for(int i = 0; i< mat1.length; i++){
                    result[r][c] += mat1[r][i] * mat2[i][c];
                }
                // 생계산하면 틀림..!
                result[r][c] %= 1000;

            }
        }
        return result;
    }
    public static long[][] squareMatrix(long[][] mat){
        long[][] result = new long[mat.length][mat[0].length];
        for (int r = 0; r < mat.length; r ++){
            for (int c = 0; c < mat.length; c++){
                for(int i = 0; i< mat.length; i++){
                    result[r][c] += mat[r][i] * mat[i][c];
                }
                result[r][c] %= 1000;
            }
        }
        return result;
    }
}