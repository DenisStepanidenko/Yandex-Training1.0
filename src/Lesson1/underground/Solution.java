package Lesson1.underground;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int a = input.nextInt(); // 1
        int b = input.nextInt(); // 2
        int n = input.nextInt(); // 1
        int m = input.nextInt(); // 2

        int min1 = a * (n - 1) + n;
        int max1 = a * (n + 1) + n;
        int min2 = b * (m - 1) + m;
        int max2 = b * (m + 1) + m;

        int totalMin = Math.max(min1, min2);
        int totalMax = Math.min(max1, max2);
        if(totalMax < totalMin){
            System.out.println(-1);
        }
        else{
            System.out.println(totalMin + " " + totalMax);
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
