package Lesson3.ProblemJ;

import java.io.*;
import java.util.*;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int t = input.nextInt();
        int d = input.nextInt();
        int n = input.nextInt();
        List<Integer> personRect = new ArrayList<>(4); // изначальный прямоугольник, в котором мы можем оказаться
        // мин х , мах х , min y , max y
        personRect.add(0);
        personRect.add(0);
        personRect.add(0);
        personRect.add(0);
        for (int i = 0; i < n; i++) {
            updatePersonRect(personRect, t);
            int x = input.nextInt();
            int y = input.nextInt();
            // нужно построить прямоугольник для навигатора
            List<Integer> man = new ArrayList<>(4);
            man.add(x + y);
            man.add(x + y);
            man.add(x - y);
            man.add(x - y);
            List<Integer> navRect = createNavReact(man, d);
            // теперь нужно пересечение сделать
            personRect = intersection(personRect, navRect);
        }
        // теперь у нас есть границы прямоугольника, в которых может находиться человек, нужно лишь вывести все точки
        List<Point> answer = new ArrayList<>();
        for (int i = personRect.get(0); i <= personRect.get(1); i++) {
            for (int j = personRect.get(2); j <= personRect.get(3); j++) {
                if ((i + j) % 2 == 0) {
                    int x = (i + j) / 2;
                    int y = i - x;
                    answer.add(new Point(x, y));
                }
            }
        }
        System.out.println(answer.size());
        for(Point current : answer){
            System.out.print(current.getX() + " " + current.getY());
            System.out.println();
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static List<Integer> intersection(List<Integer> navRect, List<Integer> personRect) {
        List<Integer> newPersonRect = new ArrayList<>(4);
        // x min , x max , y min , y max
        newPersonRect.add(Math.max(navRect.get(0), personRect.get(0)));
        newPersonRect.add(Math.min(navRect.get(1), personRect.get(1)));
        newPersonRect.add(Math.max(navRect.get(2), personRect.get(2)));
        newPersonRect.add(Math.min(navRect.get(3), personRect.get(3)));
        return newPersonRect;
    }

    public static void updatePersonRect(List<Integer> personRect, int t) {
        int xMin = personRect.get(0);
        int xMax = personRect.get(1);
        int yMin = personRect.get(2);
        int yMax = personRect.get(3);
        personRect.set(0, xMin - t);
        personRect.set(1, xMax + t);
        personRect.set(2, yMin - t);
        personRect.set(3, yMax + t);
    }

    public static List<Integer> createNavReact(List<Integer> man, int d) {
        List<Integer> navRect = new ArrayList<>(4);
        // x min , x max , y min , y max
        navRect.add(man.get(0) - d);
        navRect.add(man.get(1) + d);
        navRect.add(man.get(2) - d);
        navRect.add(man.get(3) + d);
        return navRect;
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
