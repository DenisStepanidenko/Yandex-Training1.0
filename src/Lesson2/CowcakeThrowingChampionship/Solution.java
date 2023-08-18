package Lesson2.CowcakeThrowingChampionship;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int max = -1, previous = 0, next = 0;
        int n = input.nextInt();
        int answer = -1;
        boolean isCheck = false;
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 0; i < n; ) {
            if (i == 0) {
                int x = input.nextInt();
                max = x;
                next = x;
                allNumbers.add(x);
                i++;
            } else if (i == (n - 1)) {
                int x = input.nextInt();
                allNumbers.add(x);
                if (x > max) {
                    answer = -1;
                } else if (isCheck && (next > x) && next > answer) {
                    answer = next;
                }
                break;
            } else {
                int x = input.nextInt();
                allNumbers.add(x);
                i++;
                previous = next;
                next = x;
                if (isCheck && next < previous && previous > answer) {
                    answer = previous;
                }
                isCheck = false;
                if (x > max) {
                    answer = -1;
                    max = x;
                } else if (x % 10 == 5) {
                    isCheck = true;
                }
            }
        }
        if (answer == -1) {
            System.out.println(0);
        } else {
            int answerPlace = 0;
            Collections.sort(allNumbers);
            for (int i = 0; i < allNumbers.size(); i++) {
                if (answer == allNumbers.get(i)) {
                    answerPlace = allNumbers.size() - i;
                }
            }
            System.out.println(answerPlace);
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
