package Lesson2.Sapper;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt(); // количество строк
        int m = input.nextInt(); // количество столбцов
        int k = input.nextInt(); // количество мин
        int[][] arr = new int[n][m];
        for (int i = 0; i < k; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            arr[x - 1][y - 1] = -1; // -1 будет означать мину
        }

        // теперь нужно заполнять другие поля - количество смежных мин
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == -1) {
                    continue;
                }
                int count = 0;
                if (j != 0) {
                    if (arr[i][j - 1] == -1) {
                        count++;
                    }
                }
                if (j != (m - 1)) {
                    if (arr[i][j + 1] == -1) {
                        count++;
                    }
                }
                if (i != 0) {
                    if (arr[i - 1][j] == -1) {
                        count++;
                    }
                }
                if (i != (n - 1)) {
                    if (arr[i + 1][j] == -1) {
                        count++;
                    }
                }
                if (i != 0 && j != 0) {
                    if (arr[i - 1][j - 1] == -1) {
                        count++;
                    }
                }
                if (i != (n - 1) && j != 0) {
                    if (arr[i + 1][j - 1] == -1) {
                        count++;
                    }
                }
                if (i != 0 && j != (m - 1)) {
                    if (arr[i - 1][j + 1] == -1) {
                        count++;
                    }
                }
                if (i != (n - 1) && j != (m - 1)) {
                    if (arr[i + 1][j + 1] == -1) {
                        count++;
                    }
                }
                arr[i][j] = count;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == -1){
                    System.out.print("* ");
                }
                else{
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
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
