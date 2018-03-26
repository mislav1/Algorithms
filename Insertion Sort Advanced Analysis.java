/*
* you can see the problem on this link https://www.hackerrank.com/challenges/insertion-sort/problem
*/
import java.util.Scanner;


public class Solution{

    public static long insertionSort1( int[] array, int maks) {
        BIT fenwick = new BIT(maks);

        long counter = 0;
        int n = array.length;

        counter+=0;


        fenwick.update(maks, 1);

        for (int i = 0; i<n; i++){

            int x = array[i];
            if (x==maks){
                continue;
            }

            counter+=(i-fenwick.sum(x));

            //System.out.println(fenwick.sum(x));
            fenwick.update(x, 1);

        }

        return counter;
    }




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            int maks = 0;
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
                if (maks<arr[arr_i] ){
                    maks=arr[arr_i];
                }
            }
            long result = insertionSort1(arr, maks);
            System.out.println(result);
        }
        in.close();
    }

    private static class BIT {
        int size;
        int[] table;

        public BIT (int size){
            table = new int[size+1];
            this.size=size;
        }

        public  void update (int i, int delta){

            while (i<size){
                table[i] += delta;
                i+=Integer.lowestOneBit(i);
            }
        }

        public int sum (int i){
            int sum = 0;
            while (i>0){
                sum+=table[i];
                i-=Integer.lowestOneBit(i);
            }
            return sum;
        }

        public int rangeSum (int i, int j){

            return sum(j)-sum(i-1);
        }
    }
}