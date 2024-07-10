package 이분탐색;

public class leet_74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rows = matrix.length;

            int l = 0, r = rows;
            while(l < r){
                int mid = (l+r)/2;
                if(matrix[mid][0] > target){
                    r = mid;
                }
                else if(matrix[mid][0] == target){
                    return true;
                }
                else{
                    l = mid+1;
                }
            }
            int searchRow = l-1;
            if(searchRow < 0) return false;

            l = 0;
            r = matrix[0].length;
            while(l < r){
                int mid = (l+r)/2;
                if(matrix[searchRow][mid] > target){
                    r = mid;
                }
                else if(matrix[searchRow][mid] == target){
                    return true;
                }
                else{
                    l = mid+1;
                }
            }
            return false;
        }
    }
}
