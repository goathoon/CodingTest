package 분할정복;
import java.util.*;
public class boj_5904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int len = 3;
        int mid = 3;

        while(len < n){
            mid++;
            len += (mid + len);
        }

        sol(len,mid,n);
    }

    public static void sol(int len, int mid, int n){
        int left = (len-mid)/2;
        int midStart = left+1;

        if(n >= midStart + mid) {
            sol(left, mid-1, n-left-mid);
        }

        else if(n < midStart) {
            sol(left, mid-1, n);
        }
        else if(n == midStart) {
            System.out.println("m");
        }

        else{
            System.out.println("o");
        }
    }
}
