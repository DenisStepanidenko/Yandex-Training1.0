package Lesson5.ProblemB;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int k = input.nextInt();
        int[] prefix = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int x = input.nextInt();
            if (i == 1) {
                prefix[i] = x;
            } else {
                prefix[i] = prefix[i - 1] + x;
            }
        }
        int right = 0, answer = 0;
        for (int i = 0; i < prefix.length; i++) {
            while (right < prefix.length && (prefix[right] - prefix[i] < k)) {
                right++;
            }
            if(right == prefix.length){
                break;
            }
            if( (prefix[right] - prefix[i]) == k){
                answer++;
                right++;
            }
        }
        System.out.println(answer);
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
