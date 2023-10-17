package Lesson5.ProblemC;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int[] leftRight = new int[n + 2];
        int[] rightLeft = new int[n + 2];
        for (int i = 0; i < 2; i++) {
            leftRight[i] = 0;
            rightLeft[i] = 0;
        }
        int j = 2;
        int yPrev = 0;
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            if (i == 0) {
                yPrev = y;
            } else {
                // есть два случая
                if (y > yPrev) {
                    leftRight[j] = (y - yPrev) + leftRight[j - 1];
                    rightLeft[j] = rightLeft[j - 1];
                    yPrev = y;
                    j++;
                } else {
                    leftRight[j] = leftRight[j - 1];
                    rightLeft[j] = (yPrev - y) + rightLeft[j - 1];
                    yPrev = y;
                    j++;
                }
            }
        }
        int m = input.nextInt();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int s = input.nextInt();
            int f = input.nextInt();
            if(s < f){
                answer.append(leftRight[f] - leftRight[s]).append('\n');
            }
            else{
                answer.append(rightLeft[s] - rightLeft[f]).append('\n');
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
