package Lesson2.MoreOfYourNeighbors;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        String[] allNumbers = input.nextLine().split(" ");
        int[] arr = toArray(allNumbers);
        // Обработаем случай когда размер массива равен 1
        int answer = 0;
        if (arr.length == 1 || arr.length == 2) {
            System.out.println(answer);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    continue;
                } else if (i == (arr.length - 1)) {
                    continue;
                }
                else{
                    if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    public static int[] toArray(String[] s) {
        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        return arr;
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
