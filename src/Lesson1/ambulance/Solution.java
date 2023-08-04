package Lesson1.ambulance;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int k1 = input.nextInt();
        int m = input.nextInt();
        int k2 = input.nextInt();
        int p2 = input.nextInt();
        int n2 = input.nextInt();
        if(n2 > m){
            System.out.println("-1 -1");
        }

        else if(p2 == 1 && n2 == 1 && (k1 < k2)){
            System.out.println("1 1");
        }
        else if (k2 == 1) {
            if (m == 1) {
                System.out.println("0 1");
            } else {
                System.out.println("0 0");
            }
        }
        else if( ( (p2 * m - m + n2 - 1) == 0) && ((p2*m-m+n2) == 0)){
            System.out.println("0 0");
        }else if (((p2 * m - m + n2 - 1) == 0)) {
            System.out.println("1 0");
        }
        else if( (p2*m-m+n2) == 0){
            System.out.println("0 1");

        }
        else {
            int start = (int) Math.ceil(k2 / (double) (p2 * m - m + n2));
            //System.out.println(start);
            int finish = (int) Math.floor((k2 - 1) / (double) (p2 * m - m + n2 - 1));
            //System.out.println(finish);
            // когда данные противоречивы
            if (start > finish) {
                System.out.println("-1 -1");
            } else {
                // нужно описать выбор про k2 = 1
                // и далее всё по схеме
                int[] arr = new int[finish - start + 1];
                int counter = 0;
                for (int i = start; i <= finish; i++) {
                    arr[counter] = (int) Math.ceil((k1) / (double) (i * m));
                    counter++;
                }
                int entrance = arr[0];
                boolean flag = true;
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] == entrance) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    entrance = 0;
                }
                // с подъездом разобрались
                // теперь квартира
                int[] floor = new int[arr.length];
                int j = start;
                for (int i = 0; i < arr.length; i++) {
                    floor[i] = (int) Math.ceil((k1 - m * j * (arr[i] - 1)) / (double) (j));

                    j++;
                }
                int floorAnswer = floor[0];
                flag = true;
                for (int i = 1; i < floor.length; i++) {
                    if (floor[i] == floorAnswer) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (!flag) {
                    floorAnswer = 0;
                }
                System.out.println(entrance + " " + floorAnswer);
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
