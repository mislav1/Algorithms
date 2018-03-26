/*
* you can see the problem on this link https://www.hackerrank.com/challenges/gridland-metro/problem
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
 
public class Solution {

    static long gridlandMetro(long n, long m, long k, long[][] track) {

        HashMap<Long, ArrayList<Long>> rijecnik = new HashMap<>();

        for (int i = 0; i<k; i++){
            long r = track[i][0];
            long x = track[i][1];
            long y = track[i][2];

            if (!rijecnik.containsKey(r)){
                ArrayList<Long> list2 = new ArrayList<>();
                list2.add(x);
                list2.add(y);
                rijecnik.put(r, list2);
            }else {
                ArrayList<Long> list2 = rijecnik.get(r);
                rijecnik.put(r, overlap(list2, x,y));
            }

        }

        long suma = 0;

        for (Long i : rijecnik.keySet()){
            ArrayList<Long> list3 = rijecnik.get(i);
            for (int j=0; j<list3.size(); j+=2){
                if(list3.get(j)!=-1){
                    suma+=((list3.get(j+1)-list3.get(j))+1);
                }
            }

        }

        return (n*m)-suma;
    }

    static ArrayList<Long> overlap (ArrayList<Long> lista , long x, long y){
        boolean overlap = false;
        for (int i = 0; i<lista.size(); i+=2){
            Long a = lista.get(i);
            Long b = lista.get(i+1);
            if (a!=-1 && b!=-1){
                if (x>=a && y<=b){
                    return lista;
                }else if (x<=a & y>=b){
                    lista.set(i,(long)-1);
                    lista.set(i+1,(long) -1);

                }else if (x<a && y>=a && y<=b){
                    lista.set(i,(long) -1);
                    lista.set(i+1,(long) -1);

                    y=b;

                }else if (x>=a && x<=b && y>b){
                    lista.set(i+1,(long) -1);
                    lista.set(i,(long)-1);
                    x=a;

                }

            }
        }


        lista.add(x);
        lista.add(y);

        return lista;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        long[][] track = new long[k][3];
        for(int track_i = 0; track_i < k; track_i++){
            for(int track_j = 0; track_j < 3; track_j++){
                track[track_i][track_j] = in.nextInt();
            }
        }
        long result = gridlandMetro(n, m, k, track);
        System.out.println(result);
        in.close();
    }
}