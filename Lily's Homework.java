/*
* you can see the problem on this link https://www.hackerrank.com/challenges/lilys-homework/problem
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int lilysHomework(int[] arr) {
        // Complete this function
        int count=0;
        int count2=0;

        int[]arr2=new int[arr.length];
        int[] sorted= mergeSort(arr);
        HashMap<Integer,Integer> myMap = new HashMap<>();
        HashMap<Integer,Integer> myMap2 = new HashMap<>();
        for(int i=0; i<arr.length;i++){
            myMap.put(arr[i],i);
        }
        int w=0;
        for(int z = arr.length-1;z>=0;z--){
            arr2[w]=arr[z];
            myMap2.put(arr[z],w);
            w++;
        }

        for(int j=0;j<arr.length;j++){
            if(arr[j]!=sorted[j]){
                int k= myMap.get(arr[j]);
                int z=myMap.get(sorted[j]);
                int temp=arr[j];
                arr[k]=sorted[j];
                arr[z]=temp;
                myMap.put(temp,z);
                myMap.put(sorted[j],k);
                count++;
            }

        }

        for(int j=arr2.length-1;j>0;j--){
            if(arr2[j]!=sorted[j]){
                int k= myMap2.get(arr2[j]);
                int z=myMap2.get(sorted[j]);
                int temp=arr2[j];
                arr2[k]=sorted[j];
                arr2[z]=temp;
                myMap2.put(temp,z);
                count2++;
            }

        }
        
        if(count<count2) {
            return count;
        }else {
            return count2;
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = lilysHomework(arr);
        System.out.println(result);
        in.close();
    }

    public static int[] mergeSort(int[] A){
        if(A.length<=1){
            return A;
        }else{
            int low = 0;

            int high = A.length ;
            int mid=A.length/2;
            int[] leftArray = Arrays.copyOfRange(A, low, mid);
            int[] rightArray = Arrays.copyOfRange(A,mid,high);
            leftArray=mergeSort(leftArray);
            rightArray=mergeSort(rightArray);
            int[] result = merge(leftArray,rightArray);
            return result;
        }
    }
    public static int[] merge(int[] left, int[] right ){
        int totLenght = left.length+right.length;
        int[] result = new int[totLenght];
        int i=0;
        int l=0;
        int r=0;
        while(l<left.length || r<right.length){
            if(l<left.length && r<right.length){
                if(left[l]<right[r]){
                    result[i]=left[l];
                    i++;
                    l++;
                }else {
                    result[i]=right[r];
                    i++;
                    r++;
                }
            }else {
                if (l < left.length) {
                    result[i]=left[l];
                    i++;
                    l++;
                }
                if (r < right.length) {
                    result[i]=right[r];
                    r++;
                    i++;
                }
            }
        }
        return result;
    }
}
