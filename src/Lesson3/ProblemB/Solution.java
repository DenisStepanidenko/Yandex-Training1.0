package Lesson3.ProblemB;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        Set<Long> first = new HashSet<>();
        Set<Long> second = new HashSet<>();

        String[] firstString = input.nextLine().split(" ");
        String[] secondString = input.nextLine().split(" ");
        toSet(firstString , first);
        toSet(secondString , second);
        //System.out.println(first);
        Set<Long> answer = new TreeSet<>();
        for(Long x : first){
            if(second.contains(x)){
                answer.add(x);
            }
        }
        for(Long y : answer){
            System.out.print(y + " ");
        }
    }
    public static void toSet(String[] s , Set<Long> numbers){
        for (String s1 : s) {
            Long current = Long.parseLong(s1);
            numbers.add(current);
        }
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
