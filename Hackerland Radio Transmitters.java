/*
* you can see the problem on this link https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int hackerlandRadioTransmitters(int[] x, int k) {

        x=mergeSort(x);
        int pos = 0;
        int n = x.length-1;
        int count = 0;

        while (pos<=n){
            pos=sljedeciIndeks(pos, x, k);
            count++;
        }
        return count;
    }

    private static int sljedeciIndeks (int pos, int[] lista, int k){
        int n = lista[pos];
        int trazi = n + k;

        int result = binarno(trazi, lista, pos);

        if (result==pos){
            return pos+1;
        }else {
            result = binarno(lista[result]+k, lista, result);
        }
        return result + 1;

    }

    private static int binarno (int trazi, int[] lista, int pos){
        int hi = lista.length-1;
        int lo = pos;
        while (lo<hi){
            int mid = lo + (hi-lo+1) / 2;
            if (lista[mid]>trazi){
                hi = mid - 1;
            }else {
                lo = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] x = new int[n];
        for(int x_i = 0; x_i < n; x_i++){
            x[x_i] = in.nextInt();
        }
        int result = hackerlandRadioTransmitters(x, k);
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