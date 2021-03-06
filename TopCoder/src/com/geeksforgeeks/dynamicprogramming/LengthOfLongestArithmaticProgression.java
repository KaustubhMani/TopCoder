package com.geeksforgeeks.dynamicprogramming;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

/**
 * Created by sshil on 8/6/2016.
 */
//http://www.geeksforgeeks.org/length-of-the-longest-arithmatic-progression-in-a-sorted-array/
public class LengthOfLongestArithmaticProgression {

    public void dynamicProgramming(int[] arr){
        int n = arr.length;
        int[][] matrix = new int[n][n];
        for ( int i = 0 ; i < n ; i++) {
            matrix[i][n-1] =2 ;
        }
        int llap = 2;
        for ( int j = n-2 ; j >= 1 ; j--){
            int i = j-1;
            int k = j+1;
            while( i >= 0 && k <= n-1) {
                if (arr[i] + arr[k] < 2 * arr[j]) {
                    k++;
                } else if (arr[i] + arr[k] > 2 * arr[j]) {
                    matrix[i][j] = 2;
                    i--;
                } else {
                    matrix[i][j] = matrix[j][k] + 1;
                    llap = Math.max(llap, matrix[i][j]);
                    i--;
                    k++;
                }
            }
            while(i >= 0){
                matrix[i][j] = 2;
                i--;
            }
        }
        System.out.println(llap);
    }


    public void find(int[] arr ){
        IntSummaryStatistics summaryStatistics = Arrays.stream(arr).summaryStatistics();
        int result = summaryStatistics.getMax();
        System.out.println(result);
        int[] diffArr = new int[result];
        for ( int i = 1 ; i < arr.length ; i++) {
            for ( int j = 0 ; j < i ; j++ ){
                int diff = arr[i] - arr[j];
                diffArr[diff] = diffArr[diff]+1;
            }
        }
        int finalResult = Integer.MIN_VALUE;
        for (int i = 0 ; i < diffArr.length ; i++){
            if (finalResult < diffArr[i]){
                finalResult = diffArr[i];
            }
        }
        System.out.println(finalResult+1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 10, 13, 14, 19};
        new LengthOfLongestArithmaticProgression().dynamicProgramming(arr);
    }
}
