package Lesson5.ProblemJ;

import java.io.*;
import java.util.*;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        List<Point> allPoints = new ArrayList<>(); // будем хранить все точки
        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            allPoints.add(new Point(x, y));
        }
        //System.out.println(allPoints);
        long answer = 0;
        // теперь основной цикл
        // будем для каждой точки считать расстояния, и сразу же считать сколько равнобедреннных треугольников у нас будет
        for (int i = 0; i < n; i++) {
            Set<Point> wrongPoint = new HashSet<>();
            List<Long> neigh = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                long newX = allPoints.get(j).x - allPoints.get(i).x;
                long newY = allPoints.get(j).y - allPoints.get(i).y;
                if (wrongPoint.contains(new Point(-newX, -newY))) {
                    // проверка на такие три точки, которые лежат на одной прямой
                    answer--;
                }
                wrongPoint.add(new Point(newX, newY));
                long dlina = newX * newX + newY * newY;
                neigh.add(dlina);
            }
            Collections.sort(neigh);
            int right = 0;
            for (int k = 0; k < neigh.size(); k++) {
                while (right < neigh.size() && (Objects.equals(neigh.get(k), neigh.get(right)))) {
                    right++;
                }
                answer += right - k - 1;
            }
        }
        System.out.println(answer);
    }

    // класс точка
    static class Point {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = (int) (x ^ (x >>> 32));
            result = 31 * result + (int) (y ^ (y >>> 32));
            return result;
        }

        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public long getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public long getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
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
