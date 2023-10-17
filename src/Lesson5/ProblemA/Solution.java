package Lesson5.ProblemA;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            arr1[i] = x;
        }
        int m = input.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            int x = input.nextInt();
            arr2[i] = x;
        }

        // идея в двух указателях

        int number1 = 0, number2 = 0;
        int minDifference = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (left < arr1.length && right < arr2.length) {
            int currentMinDifference = Integer.MAX_VALUE;
            while (right < arr2.length && (Math.abs(arr1[left] - arr2[right]) < currentMinDifference)) {
                //System.out.println(arr1[left] + " " + arr2[right] + " " + minDifference);
                currentMinDifference = Math.abs(arr1[left] - arr2[right]);
                right++;
            }
            //System.out.println(currentMinDifference + " " + right);
            if (currentMinDifference < minDifference) {
                minDifference = currentMinDifference;
                number1 = arr1[left];
                number2 = arr2[right - 1];
            }
            right--;
            left++;
        }
        if(right == arr2.length){
            for(int i = left; i < arr1.length; i++){
                if(Math.abs(arr1[left] - arr2[right-1]) < minDifference){
                    minDifference = Math.abs(arr1[left] - arr2[right-1]);
                    number1 = arr1[left];
                    number2 = arr2[right-1];
                }
            }
        }
        if (left == arr1.length) {
            for (int i = right; i < arr2.length; i++) {
                if (Math.abs(arr1[left - 1] - arr2[i]) < minDifference) {
                    minDifference = Math.abs(arr1[left - 1] - arr2[i]);
                    number1 = arr1[left - 1];
                    number2 = arr2[i];
                }
            }
//        } else if (right == arr2.length) {
//            for (int i = left; i < arr1.length; i++) {
//                if (Math.abs(arr1[i] - arr2[right - 1]) > minDifference) {
//                    minDifference = Math.abs(arr1[i] - arr2[right - 1]);
//                    number1 = arr1[i];
//                    number2 = arr2[right - 1];
//                }
//            }
//        }
        }
        System.out.println(number1 + " " + number2);

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
