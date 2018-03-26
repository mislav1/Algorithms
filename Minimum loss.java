/*
* you can see the problem on this link https://www.hackerrank.com/challenges/minimum-loss/problem
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long minimumLoss(long[] price) {

        long[] priceSorted = Arrays.copyOf(price, price.length);
        Arrays.sort(priceSorted);

        HashMap<Long, Integer> dictionary = new HashMap<>();

        for (int i = 0; i < price.length; i++){

            dictionary.put(price[i], i);
        }

        long min = priceSorted[priceSorted.length - 1];

        for (int i = 1; i < price.length; i++){

            if(priceSorted[i] - priceSorted[i-1] < min
                    && dictionary.get(priceSorted[i]) < dictionary.get(priceSorted[ i- 1])){

                min = priceSorted[i] - priceSorted[i - 1];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] price = new long[n];
        for(int price_i = 0; price_i < n; price_i++){
            price[price_i] = in.nextLong();
        }
        long result = minimumLoss2(price);
        System.out.println(result);
        in.close();
    }

    static long minimumLoss2(long[] price) {

        TreeSet<Long> set = new TreeSet<>();
        long  min = Long.MAX_VALUE;

        for (int i = price.length - 2; i >= 0; i--){
            set.add(price[i+1]);
            if (set.lower(price[i])!=null){
                if (price[i] - set.lower(price[i]) < min){
                    min = price[i] - set.lower(price[i]);
                }
            }
        }
        return min;
    }
}