package Lesson5.ProblemE;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[n + 1];
        Map<Integer, Long> colors = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            colors.put(i, 0L);
        }
        for (int i = 1; i < n + 1; i++) {
            int x = input.nextInt();
            arr[i] = x;
        }

        // теперь самое сложное
        boolean flag = false; // false - будет означать, что мы ещё не набрали того нужно количества цветов в наборе
        int countCurrent = 0;
        int answer = Integer.MAX_VALUE;
        int indexLeft = 0, indexRight = 0;
        int left = 1, right = 1;
        while (left < arr.length) {
            while (right < arr.length && (countCurrent != k)) {
                int currentColor = arr[right];
                //System.out.println(right + " " + currentColor);
                if (colors.get(currentColor) == 0) {
                    colors.put(currentColor, 1L);
                    countCurrent++;
                } else {
                    colors.put(currentColor, colors.get(currentColor) + 1);
                }
                right++;
            }
            right--;
            // сюда мы попадаем в случае либо когда R дошло до конца, либо нашлись все цветочки нужного цвета
//            if (right == (n + 1)) {
//                if (right - left < answer) {
//                    answer = right - left;
//                    indexLeft = left;
//                    indexRight = right - 1;
//                }
//            } else {
            if(countCurrent != k){
                // значит поезд ушел, больше варинтов нет
                left = arr.length;
                break;
            }
            if ((right - left + 1) < answer) {
                answer = right - left + 1;
                indexLeft = left;
                indexRight = right;
            }

            // всю работу с вычислением длины закончили
            // получил конкретную длину , где точно есть хотя бы один цвет
            // можем ли мы уменьшить эту длину - попробуем идти с указателя left до того
            // момента, пока всё ещё будут все цвета

            while (true) {
                int currentColor = arr[left];
                //System.out.println(right);
                if (colors.get(currentColor) == 1) {
                    colors.put(currentColor, 0L);
                    countCurrent--;
                    if (right == (n + 1)) {
                        if ((right - left) < answer) {
                            answer = right - left + 1;
                            indexLeft = left;
                            indexRight = right - 1;
                        }
                    } else {
                        if (right - left + 1 < answer) {
                            answer = right - left + 1;
                            indexLeft = left;
                            indexRight = right;
                        }

                    }
                    right++;
                    if (right == arr.length) {
                        left = arr.length;
                        // это мы делаем, так как у нас уже right дошёл до конца и все способы
                        // найти минимальную длину мы рассмотрели
                    }
                    left++;
                    break;
                } else {
                    left++;
                    colors.put(currentColor, colors.get(currentColor) - 1);
                }
            }
        }
        System.out.println(indexLeft + " " + indexRight);
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
