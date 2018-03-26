/*
* you can see the problem on this link https://www.hackerrank.com/challenges/countingsort4/problem
*/
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();

        ArrayList<String>[] lista = new ArrayList[100];
        for (int i=0; i<100; i++){
            ArrayList<String> nova = new ArrayList<>();
            nova.add("");
            lista[i]= nova;

        }



        for(int a0 = 0; a0 < n; a0++){
            int x = sc.nextInt();
            String s = sc.next();
            if (a0<n/2){
                s="-";
            }
            lista[x].add(s);


        }


        for(int i= 0; i<100; i++){
            if(lista[i].size()!=1){

                for (int j = 1; j<lista[i].size(); j++){
                    out.print(lista[i].get(j));
                    out.print(" ");
                }
            }else {
                break;
            }

        }
        out.close();
    }
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    //--------------------------------------------------------
}