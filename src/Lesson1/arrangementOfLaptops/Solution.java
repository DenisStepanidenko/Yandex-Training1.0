package Lesson1.arrangementOfLaptops;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int xTest = input.nextInt();
        int yTest = input.nextInt();
        int x = Math.min(xTest, yTest); // ширина первого ноутбука
        int y = Math.max(xTest, yTest); // длина первого ноутбука
        int mTest = input.nextInt();
        int nTest = input.nextInt();
        int m = Math.min(mTest, nTest); // ширина второго ноутбука
        int n = Math.max(mTest, nTest); // длина второго ноутбука

        if (x >= m) {
            int first = x * (y + n);
            int second = (y + m) * (Math.max(x, n));
            int third = (x + m) * Math.max(y, n);
            int four = (x + n) * y;
            int result = Math.min(Math.min(first,second) , Math.min(third , four));
            if(result == first){
                System.out.println(x + " " + (y+n));
            }
            else if(result == second){
                System.out.println((y+m) + " " + Math.max(x,n));
            }
            else if(result == third){
                System.out.println((x+m) + " " + Math.max(y,n));
            }
            else{
                System.out.println((x+n) + " " + y);
            }
        } else {
            int first = m * (n + y);
            int second = (n + x) * Math.max(m, y);
            int third = (m+x) * (Math.max(y,n));
            int four = (m+y) * (n);
            int result = Math.min(Math.min(first,second) , Math.min(third , four));
            if(result == first){
                System.out.println(m + " " + (n+y));
            }
            else if(result == second){
                System.out.println((n+x) + " " + Math.max(m,y));
            }
            else if(result == third){
                System.out.println((m+x) + " " + Math.max(y,n));
            }
            else{
                System.out.println((m+y) + " " + n);
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
