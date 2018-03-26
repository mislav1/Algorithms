/*
* you can see the problem on this link https://www.hackerrank.com/challenges/insertionsort2/problem
*/
import java.util.*;

public class Solution {

    static void insertionSort1(int n, int[] arr) {
        for (int i = 1; i<n; i++){
            int k = arr[i];

            for (int j = i-1; j>=0; j--){
                if (arr[j]>k){

                    swap(arr, j,j+1);

                }else {

                    continue;
                }
            }
            String s = Arrays.toString(arr);
            s=s.substring(1, s.length()-1).replaceAll(",", "");
            System.out.println(s);
        }
    }
    static void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;

    }
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        insertionSort1(n, arr);
        in.close();
    }
}