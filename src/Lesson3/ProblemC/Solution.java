package Lesson3.ProblemC;

import java.io.*;
import java.util.*;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int m = input.nextInt();
        List<Integer> kate = new ArrayList<>();
        List<Integer> boris = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int current = input.nextInt();
            kate.add(current);
        }
        for (int i = 0; i < m; i++) {
            int current = input.nextInt();
            boris.add(current);
        }
        Collections.sort(kate);
        Collections.sort(boris);


        List<Integer> kateNew = new ArrayList<>();
        List<Integer> borisNew = new ArrayList<>();
        List<Integer> allTogether = new ArrayList<>();

        int borisIter = 0 , kateIter = 0;
        while(borisIter < boris.size() && kateIter < kate.size()){
            int x = boris.get(borisIter);
            int y = kate.get(kateIter);
            if(Objects.equals(x, y)){
                allTogether.add(x);
                borisIter++;
                kateIter++;
            }
            else if(x > y){
                kateNew.add(y);
                kateIter++;
            }
            else{
                // тут x < y
                borisNew.add(x);
                borisIter++;
            }
        }
        if(borisIter < boris.size()){
            for(int i = borisIter; i < boris.size(); i++){
                borisNew.add(boris.get(i));
            }
        }
        if(kateIter < kate.size()){
            for(int i = kateIter; i < kate.size(); i++){
                kateNew.add(kate.get(i));
            }
        }
//        for (Integer x : boris) {
//            if(kate.contains(x)){
//                continue;
//            }
//            borisNew.add(x);
//        }
        // можно выводить ответ
        System.out.println(allTogether.size());
        StringBuilder all = new StringBuilder();
        for (Integer x : allTogether) {
            all.append(x).append(" ");
        }
        System.out.println(all.toString());
        System.out.println(kateNew.size());
        StringBuilder k = new StringBuilder();
        for (Integer x : kateNew) {
            k.append(x).append(" ");
        }
        System.out.println(k.toString());
        System.out.println(borisNew.size());
        StringBuilder b = new StringBuilder();
        for (Integer x  : borisNew) {
            b.append(x).append(" ");
        }
        System.out.println(b.toString());
    }

    static class Reader extends PrintWriter {

        private BufferedReader r;
        private StringTokenizer st;
        // standard input

        public Reader() {
            this(System.in, System.out);
        }

        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input

        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName));
        }

        // returns null if no more input
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {

            return Long.parseLong(next());
        }
    }
}
