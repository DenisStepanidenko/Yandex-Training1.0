package Lesson3.ProblemA;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();
    public static void main(String[] args) {
        Set<Long> allNumbers = new HashSet<>();
        String[] s = input.nextLine().split(" ");
        if(s[0].isEmpty()){
            System.out.println(0);
            System.exit(0);
        }
        for(String x : s){
            Long current = Long.parseLong(x);
            allNumbers.add(current);
        }
        System.out.println(allNumbers.size());
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
