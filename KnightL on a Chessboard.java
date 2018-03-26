/*
* you can see the problem on this link https://www.hackerrank.com/challenges/knightl-on-chessboard/problem
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static class Node2 {

        int xVariable;
        int yVariable;
        int mDistance;

        public Node2 (int x, int y, int distance){
            xVariable = x;
            yVariable = y;
            mDistance = distance;
        }

        public int getxVariable (){
            return xVariable;
        }

        public int getyVariable(){
            return yVariable;
        }

        public int getDistance (){
            return mDistance;
        }

        @Override
        public int hashCode() {
            return xVariable * 13 + yVariable *18;
        }

        @Override
        public boolean equals(Object obj) {
            Node2 node2 = (Node2) obj;
            return xVariable == node2.xVariable && yVariable == node2.yVariable;
        }
    }

    public static Node2[] listOfChildren(Node2 node, int a, int b, int n) {
        int x = node.getxVariable();
        int y = node.getyVariable();

        ArrayList<Node2> lista = new ArrayList<>();
        if ( x+a<=n-1 && y+b<=n-1){
            lista.add(new Node2(x+a, y+b, node.getDistance()+1));
        }
        if ( x+a<=n-1 && y-b>=0){
            lista.add(new Node2(x+a, y-b, node.getDistance()+1));
        }
        if ( x-a>=0 && y+b<=n-1){
            lista.add(new Node2(x-a, y+b, node.getDistance()+1));
        }
        if ( x-a>=0 && y-b>=0){
            lista.add(new Node2(x-a, y-b, node.getDistance()+1));
        }
        if ( x+b<=n-1 && y+a<=n-1){
            lista.add(new Node2(x+b, y+a, node.getDistance()+1));
        }
        if ( x+b<=n-1 && y-a>=0){
            lista.add(new Node2(x+b, y-a, node.getDistance()+1));
        }
        if ( x-b>=0 && y+a<=n-1){
            lista.add(new Node2(x-b, y+a, node.getDistance()+1));
        }
        if ( x-b>=0 && y-a>=0){
            lista.add(new Node2(x-b, y-a, node.getDistance()+1));
        }
        Node2[] nodovi = new Node2[lista.size()];
        for (int i=0; i<lista.size(); i++){
            nodovi[i] = lista.get(i);
        }

        return nodovi;

    }



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        Node2 zero = new Node2(0, 0, 0);


        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                HashSet<Node2> set = new HashSet<>();
                LinkedList<Node2> red = new LinkedList<>();
                red.offer(zero);
                int solution = -1;
                while (red.peek()!=null) {

                    Node2 first = red.poll();
                    set.add(first);
                    Node2[] children = listOfChildren(first, a, b, n);
                    for (int i = 0; i < children.length; i++) {

                        if (children[i].getxVariable() == n - 1 && children[i].getyVariable() == n - 1) {
                            solution = children[i].getDistance();
                            red.clear();
                            break;
                        }

                        if (!set.contains(children[i])) {
                            set.add(children[i]);
                            red.add(children[i]);
                        }
                    }

                }

                System.out.print(solution + " ");
            }
            System.out.println();
        }

    }
}