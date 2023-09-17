package Lesson4.ProblemD;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        Map<Integer, Integer> serviceability = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            serviceability.put((i + 1), x);
        }
        int k = input.nextInt();
        for (int i = 0; i < k; i++) {
            int y = input.nextInt();
            if (serviceability.get(y) < 0) {
                continue;
            }
            serviceability.put(y, serviceability.get(y) - 1);
        }
        for (Map.Entry<Integer, Integer> entry : serviceability.entrySet()) {
            if(entry.getValue() < 0){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
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
