package Lesson6.ProblemA;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[k];
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            arr1[i] = x;
        }
        for (int i = 0; i < k; i++) {
            int x = input.nextInt();
            arr2[i] = x;
        }
        Arrays.sort(arr1);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < k; i ++) {
            boolean flag = binPoisk(arr1 , arr2[i]);
            if(flag) {
                answer.append("YES").append('\n');
            }
            else{
                answer.append("NO").append('\n');
            }
        }
        System.out.println(answer);
    }

    public static boolean binPoisk(int[] arr, int x) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] == x) {
                return true;
            } else if (arr[mid] > x) {
                right = mid;
            } else left = mid + 1;
        }
        return false;
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
