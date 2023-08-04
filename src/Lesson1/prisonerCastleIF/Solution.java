package Lesson1.prisonerCastleIF;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        long a = input.nextLong();
        long b = input.nextLong();
        long c = input.nextLong();
        long dTest = input.nextLong();
        long eTest = input.nextLong();

        long d = Math.min(dTest, eTest);
        long e = Math.max(dTest, eTest);
        boolean flag = false;
        if (a <= d) {
            if (b <= e || c <= e) {
                System.out.println("YES");
                System.exit(0);
            }
        }
        if (b <= d) {
            if (a <= e || c <= e) {
                System.out.println("YES");
                System.exit(0);
            }
        }
        if(c <= d){
            if(a <= e || b <= e){
                System.out.println("YES");
                System.exit(0);
            }
        }
        System.out.println("NO");
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
