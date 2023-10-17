package Lesson5.ProblemF;

import java.io.*;
import java.util.*;

public class Solution {
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

    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int[] arr = new int[n]; // минимальные мощности для классов
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            arr[i] = x;
        }
        int m = input.nextInt();
        Kond[] arr2 = new Kond[m]; // имеющиеся кондиционеры
        for (int i = 0; i < m; i++) {
            int b = input.nextInt();
            int c = input.nextInt();
            Kond current = new Kond(b, c);
            arr2[i] = current;
        }
        // рассуждение:
        // есть два кондиционера : F1 F2
        // если стоимость F1 > F2 и при этом мощность F2 больше чем F1 - то F1 покупать невыгодно
        // сейчас хотим удалить все такие кондиционеры
        Arrays.sort(arr2);
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr2));
        //System.out.println(Arrays.toString(arr2));
        List<Kond> finalKond = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < arr2.length && j < arr2.length; ) {
            if (arr2[i].getB() >= arr2[j].getB()) {
                arr2[j] = null;
            } else {
                i = j;
            }
            j++;
        }
        for (Kond kond : arr2) {
            if (kond != null) {
                finalKond.add(kond);
            }
        }
        //System.out.println(finalKond);
        int left = 0, right = 0;
        long answer = 0;
        while (left < arr.length) {
            while (right < finalKond.size() && (arr[left] > finalKond.get(right).getB())) {
                right++;
            }
            answer += finalKond.get(right).getC();
            left++;
        }
        System.out.println(answer);
    }

    static class Kond implements Comparable<Kond> {
        int b; // мощность
        int c; // стоимость

        @Override
        public String toString() {
            return "Kond{" +
                    "b=" + b +
                    ", c=" + c +
                    '}';
        }

        public Kond(int b, int c) {
            this.b = b;
            this.c = c;
        }

        public int getB() {
            return b;
        }

        public int getC() {
            return c;
        }

        @Override
        public int compareTo(Kond o) {
            if (c < o.getC()) {
                return -1;
            } else if (c > o.getC()) {
                return 1;
            } else {
                if (b < o.getB()) {
                    return -1;
                } else if(b > o.getB()){
                    return 1;
                }
                return 0;
            }
        }
    }
}
