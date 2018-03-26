/*
* you can see the problem on this link https://www.hackerrank.com/challenges/extra-long-factorials/problem
*/
import java.math.BigInteger;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long counter=(n-1);
        BigInteger umnozak= BigInteger.valueOf(n);

        while (counter>0){
            umnozak=umnozak.multiply(BigInteger.valueOf(counter));
            counter--;
        }
        System.out.println(umnozak);



    }
}