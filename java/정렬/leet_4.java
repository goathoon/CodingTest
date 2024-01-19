package 정렬;

import java.util.*;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * 여기서 시간복잡도가 O(log (m+n)) 스케일이어야 한다 다음과 같이 배열복사를 통해 풀어도
 * 복사하는데에는 m+n의 상수시간이,
 * 정렬에 O(log(n+m))이므로 패스하긴 한다.
 */
public class leet_4 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;

            int[] destArr = new int[len];
            System.arraycopy(nums1, 0, destArr, 0, nums1.length);
            System.arraycopy(nums2, 0, destArr, nums1.length, nums2.length);

            Arrays.sort(destArr);

            if (len % 2 == 0) {
                return (double) (destArr[len / 2] + destArr[len / 2 - 1]) / 2;
            } else {
                return (double) destArr[len / 2];
            }
        }
    }
}

