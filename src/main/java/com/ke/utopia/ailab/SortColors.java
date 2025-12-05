package com.ke.utopia.ailab;

import java.util.Arrays;

/**
 * 类名：SetMatrixZeroes
 * 描述：
 * 作者：zifengchen
 * 日期：2025/12/4
 */
public class SortColors {

    public static void main(String[] args) {
        int[] array = new int[]{2,0,1,0,2,1,2};
        sort(array);

        System.out.println(Arrays.toString(array));
    }




    public static void sort (int[] args) {
        int len = args.length;
        int right =len-1;
        int left =0;
        while (args[left]==0) {
            left++;
        }
        while (args[right]==2) {
            right--;
        }


        for(int i=0; i<right;i++) {
            if (args[i]==0) {
                swap(i, left, args);
                left++;
            }else if (args[i]==2) {
                swap(i, right, args);
                right--;
            }
        }
    }


    static void swap(int n, int m , int[] array) {
        int temp = array[n];
        array[n]= array[m];
        array[m] = temp;
    }


}
