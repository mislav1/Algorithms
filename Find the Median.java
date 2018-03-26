/*
* you can see the problem on this link https://www.hackerrank.com/challenges/find-the-median/problem
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int findMedian(int[] arr) {
        return arr[(arr.length/2)];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = findMedian(mergeSort(arr));
        System.out.println(result);
        in.close();
    }

    public static int[] mergeSort(int[] list){
        if (list.length<=1){
            return list;
        }

        int midpoint = list.length/2;
        int[] left = new int[midpoint];
        int[] right;
        if (list.length%2==0){
            right = new int[midpoint];
        }else {
            right = new int[midpoint+1];
        }
        for (int i =0; i<midpoint; i++){
            left[i]=list[i];
        }

        int x = 0;

        for (int i =midpoint; i<list.length; i++){
            right[x]=list[i];
            x++;
        }

        left = mergeSort(left);
        right = mergeSort(right);
        int[] result = new int[list.length];
        result = merge (left, right);
        return result;
    }

    public static int[] merge (int[] left, int[] right){
        int[] result = new int[left.length+right.length];
        int indexLeft = 0;
        int indexRight = 0;
        int indexReslut = 0;

        while (indexLeft < left.length || indexRight < right.length){

            if (indexLeft < left.length && indexRight < right.length){
                if (left[indexLeft]<=right[indexRight]){
                    result[indexReslut] = left[indexLeft];
                    indexReslut++;
                    indexLeft++;
                }else {

                    result[indexReslut] = right[indexRight];
                    indexReslut++;
                    indexRight++;

                }
            } else if (indexLeft < left.length){
                result[indexReslut] = left[indexLeft];
                indexReslut++;
                indexLeft++;
            } else {
                result[indexReslut] = right[indexRight];
                indexReslut++;
                indexRight++;
            }
        }

        return result;
    }
}