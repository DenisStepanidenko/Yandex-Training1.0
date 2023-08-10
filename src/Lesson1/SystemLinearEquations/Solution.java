package Lesson1.SystemLinearEquations;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        // a, b, c, d, e, f
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        // сначала рассмотрим случай, когда все коэффициенты равны 0
        if (a == 0 && b == 0 && c == 0 && d == 0) {
            if (e == 0 && f == 0) {
                // любая пара (x,y) является решением
                System.out.println(5);
            } else {
                // решений нет
                System.out.println(0);
            }
        } else {
            if (((a * d) - (b * c)) != 0) {
                double main = (a * d) - (b * c);
                //System.out.println("main" + main);
                // система имеет единственное решение
                double x = (a * f) - (c * e);
                //System.out.println("x " + x);
                double y = (e * d) - (b * f);
                System.out.println(2 + " " + (y / main) + " " + (x / main));
            } else {
                double x = (a * f) - (c * e);
                double y = (e * d) - (b * f);
                if (x != 0 && y != 0) {
                    // система не имеет решений
                    System.out.println(0);
                } else {
                    if (a == 0 && c == 0) {
                        if (b != 0 && d != 0) {
                            if ((e / b) == (f / d)) {
                                // cистема имеет решения вида x - любое , y = y0
                                System.out.println(4 + " " + (e / b));
                            } else {
                                // система не имеет решений
                                System.out.println(0);
                            }
                        } else if (b != 0) {
                            if (f == 0) {
                                // cистема имеет решения вида x - любое , y = y0
                                System.out.println(4 + " " + (e / b));
                            } else {
                                // система не имеет решений
                                System.out.println(0);
                            }
                        } else {
                            if (e == 0) {
                                // cистема имеет решения вида x - любое , y = y0
                                System.out.println(4 + " " + (f / d));
                            } else {
                                // система не имеет решений
                                System.out.println(0);
                            }
                        }

                    } else if (b == 0 && d == 0) {
                        if (a != 0 && c != 0) {
                            if ((e / a) == (f / c)) {
                                System.out.println(3 + " " + (e / a));
                            } else {
                                System.out.println(0);
                            }
                        } else if (a != 0) {
                            if (f == 0) {
                                System.out.println(3 + " " + (e / a));
                            } else {
                                System.out.println(0);
                            }
                        } else {
                            if (e == 0) {
                                System.out.println(3 + " " + (f / c));
                            } else {
                                System.out.println(0);
                            }
                        }
                    } else if (c != 0 && d != 0 && f != 0) {
                        if (((a / c) == (b / d)) && ((b / d) == (e / f))) {
                            // система имеет бесконечно много решений вида y = kx + b
                            System.out.println(1 + " " + (-c / d) + " " + (f / d));
                        } else {
                            System.out.println(0);
                        }

                    } else if (a != 0 && b != 0 && e != 0) {
                        if (((c / a) == (d / b)) && ((d / b) == (f / e))) {
                            // система имеет бесконечно много решений вида y = kx + b
                            System.out.println(1 + " " + (-a / b) + " " + (e / b));
                        } else {
                            System.out.println(0);
                        }
                    } else if (e == 0 && f == 0) {
                        if (((-a) / b) == (-c / d)) {
                            System.out.println(1 + " " + (-a/b) + " " + 0);
                        }
                    }
                }
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
