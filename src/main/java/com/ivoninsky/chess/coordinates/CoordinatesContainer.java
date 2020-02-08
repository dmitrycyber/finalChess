package com.ivoninsky.chess.coordinates;

import java.util.HashMap;
import java.util.Map;

public class CoordinatesContainer {
    private static CoordinatesContainer coordinatesContainer;

    private Map<Coordinate, String> coordinateStringMap;
    private Coordinate a8 = new Coordinate(0, 0);
    private Coordinate b8 = new Coordinate(100, 0);
    private Coordinate c8 = new Coordinate(200, 0);
    private Coordinate d8 = new Coordinate(300, 0);
    private Coordinate e8 = new Coordinate(400, 0);
    private Coordinate f8 = new Coordinate(500, 0);
    private Coordinate g8 = new Coordinate(600, 0);
    private Coordinate h8 = new Coordinate(700, 0);

    private Coordinate a7 = new Coordinate(0, 100);
    private Coordinate b7 = new Coordinate(100, 100);
    private Coordinate c7 = new Coordinate(200, 100);
    private Coordinate d7 = new Coordinate(300, 100);
    private Coordinate e7 = new Coordinate(400, 100);
    private Coordinate f7 = new Coordinate(500, 100);
    private Coordinate g7 = new Coordinate(600, 100);
    private Coordinate h7 = new Coordinate(700, 100);

    private Coordinate a6 = new Coordinate(0, 200);
    private Coordinate b6 = new Coordinate(100, 200);
    private Coordinate c6 = new Coordinate(200, 200);
    private Coordinate d6 = new Coordinate(300, 200);
    private Coordinate e6 = new Coordinate(400, 200);
    private Coordinate f6 = new Coordinate(500, 200);
    private Coordinate g6 = new Coordinate(600, 200);
    private Coordinate h6 = new Coordinate(700, 200);

    private Coordinate a5 = new Coordinate(0, 300);
    private Coordinate b5 = new Coordinate(100, 300);
    private Coordinate c5 = new Coordinate(200, 300);
    private Coordinate d5 = new Coordinate(300, 300);
    private Coordinate e5 = new Coordinate(400, 300);
    private Coordinate f5 = new Coordinate(500, 300);
    private Coordinate g5 = new Coordinate(600, 300);
    private Coordinate h5 = new Coordinate(700, 300);

    private Coordinate a4 = new Coordinate(0, 400);
    private Coordinate b4 = new Coordinate(100, 400);
    private Coordinate c4 = new Coordinate(200, 400);
    private Coordinate d4 = new Coordinate(300, 400);
    private Coordinate e4 = new Coordinate(400, 400);
    private Coordinate f4 = new Coordinate(500, 400);
    private Coordinate g4 = new Coordinate(600, 400);
    private Coordinate h4 = new Coordinate(700, 400);

    private Coordinate a3 = new Coordinate(0, 500);
    private Coordinate b3 = new Coordinate(100, 500);
    private Coordinate c3 = new Coordinate(200, 500);
    private Coordinate d3 = new Coordinate(300, 500);
    private Coordinate e3 = new Coordinate(400, 500);
    private Coordinate f3 = new Coordinate(500, 500);
    private Coordinate g3 = new Coordinate(600, 500);
    private Coordinate h3 = new Coordinate(700, 500);

    private Coordinate a2 = new Coordinate(0, 600);
    private Coordinate b2 = new Coordinate(100, 600);
    private Coordinate c2 = new Coordinate(200, 600);
    private Coordinate d2 = new Coordinate(300, 600);
    private Coordinate e2 = new Coordinate(400, 600);
    private Coordinate f2 = new Coordinate(500, 600);
    private Coordinate g2 = new Coordinate(600, 600);
    private Coordinate h2 = new Coordinate(700, 600);

    private Coordinate a1 = new Coordinate(0, 700);
    private Coordinate b1 = new Coordinate(100, 700);
    private Coordinate c1 = new Coordinate(200, 700);
    private Coordinate d1 = new Coordinate(300, 700);
    private Coordinate e1 = new Coordinate(400, 700);
    private Coordinate f1 = new Coordinate(500, 700);
    private Coordinate g1 = new Coordinate(600, 700);
    private Coordinate h1 = new Coordinate(700, 700);


    private CoordinatesContainer() {
        coordinateStringMap = new HashMap<>();

        coordinateStringMap.put(a8, "n");
        coordinateStringMap.put(a7, "n");
        coordinateStringMap.put(a6, "n");
        coordinateStringMap.put(a5, "n");
        coordinateStringMap.put(a4, "n");
        coordinateStringMap.put(a3, "n");
        coordinateStringMap.put(a2, "n");
        coordinateStringMap.put(a1, "n");

        coordinateStringMap.put(b8, "n");
        coordinateStringMap.put(b7, "n");
        coordinateStringMap.put(b6, "n");
        coordinateStringMap.put(b5, "n");
        coordinateStringMap.put(b4, "n");
        coordinateStringMap.put(b3, "n");
        coordinateStringMap.put(b2, "n");
        coordinateStringMap.put(b1, "n");

        coordinateStringMap.put(c8, "n");
        coordinateStringMap.put(c7, "n");
        coordinateStringMap.put(c6, "n");
        coordinateStringMap.put(c5, "n");
        coordinateStringMap.put(c4, "n");
        coordinateStringMap.put(c3, "n");
        coordinateStringMap.put(c2, "n");
        coordinateStringMap.put(c1, "n");

        coordinateStringMap.put(d8, "n");
        coordinateStringMap.put(d7, "n");
        coordinateStringMap.put(d6, "n");
        coordinateStringMap.put(d5, "n");
        coordinateStringMap.put(d4, "n");
        coordinateStringMap.put(d3, "n");
        coordinateStringMap.put(d2, "n");
        coordinateStringMap.put(d1, "n");

        coordinateStringMap.put(e8, "n");
        coordinateStringMap.put(e7, "n");
        coordinateStringMap.put(e6, "n");
        coordinateStringMap.put(e5, "n");
        coordinateStringMap.put(e4, "n");
        coordinateStringMap.put(e3, "n");
        coordinateStringMap.put(e2, "n");
        coordinateStringMap.put(e1, "n");

        coordinateStringMap.put(f8, "n");
        coordinateStringMap.put(f7, "n");
        coordinateStringMap.put(f6, "n");
        coordinateStringMap.put(f5, "n");
        coordinateStringMap.put(f4, "n");
        coordinateStringMap.put(f3, "n");
        coordinateStringMap.put(f2, "n");
        coordinateStringMap.put(f1, "n");

        coordinateStringMap.put(g8, "n");
        coordinateStringMap.put(g7, "n");
        coordinateStringMap.put(g6, "n");
        coordinateStringMap.put(g5, "n");
        coordinateStringMap.put(g4, "n");
        coordinateStringMap.put(g3, "n");
        coordinateStringMap.put(g2, "n");
        coordinateStringMap.put(g1, "n");

        coordinateStringMap.put(h8, "n");
        coordinateStringMap.put(h7, "n");
        coordinateStringMap.put(h6, "n");
        coordinateStringMap.put(h5, "n");
        coordinateStringMap.put(h4, "n");
        coordinateStringMap.put(h3, "n");
        coordinateStringMap.put(h2, "n");
        coordinateStringMap.put(h1, "n");
    }

    public static CoordinatesContainer getInstance(){
        if (coordinatesContainer == null){
            coordinatesContainer = new CoordinatesContainer();
        }
        return coordinatesContainer;
    }

    public Map<Coordinate, String> getCoordinateStringMap() {
        return coordinateStringMap;
    }

//    -------------------------------


    public Coordinate getA8() {
        return a8;
    }

    public Coordinate getB8() {
        return b8;
    }

    public Coordinate getC8() {
        return c8;
    }

    public Coordinate getD8() {
        return d8;
    }

    public Coordinate getE8() {
        return e8;
    }

    public Coordinate getF8() {
        return f8;
    }

    public Coordinate getG8() {
        return g8;
    }

    public Coordinate getH8() {
        return h8;
    }

    public Coordinate getA7() {
        return a7;
    }

    public Coordinate getB7() {
        return b7;
    }

    public Coordinate getC7() {
        return c7;
    }

    public Coordinate getD7() {
        return d7;
    }

    public Coordinate getE7() {
        return e7;
    }

    public Coordinate getF7() {
        return f7;
    }

    public Coordinate getG7() {
        return g7;
    }

    public Coordinate getH7() {
        return h7;
    }

    public Coordinate getA6() {
        return a6;
    }

    public Coordinate getB6() {
        return b6;
    }

    public Coordinate getC6() {
        return c6;
    }

    public Coordinate getD6() {
        return d6;
    }

    public Coordinate getE6() {
        return e6;
    }

    public Coordinate getF6() {
        return f6;
    }

    public Coordinate getG6() {
        return g6;
    }

    public Coordinate getH6() {
        return h6;
    }

    public Coordinate getA5() {
        return a5;
    }

    public Coordinate getB5() {
        return b5;
    }

    public Coordinate getC5() {
        return c5;
    }

    public Coordinate getD5() {
        return d5;
    }

    public Coordinate getE5() {
        return e5;
    }

    public Coordinate getF5() {
        return f5;
    }

    public Coordinate getG5() {
        return g5;
    }

    public Coordinate getH5() {
        return h5;
    }

    public Coordinate getA4() {
        return a4;
    }

    public Coordinate getB4() {
        return b4;
    }

    public Coordinate getC4() {
        return c4;
    }

    public Coordinate getD4() {
        return d4;
    }

    public Coordinate getE4() {
        return e4;
    }

    public Coordinate getF4() {
        return f4;
    }

    public Coordinate getG4() {
        return g4;
    }

    public Coordinate getH4() {
        return h4;
    }

    public Coordinate getA3() {
        return a3;
    }

    public Coordinate getB3() {
        return b3;
    }

    public Coordinate getC3() {
        return c3;
    }

    public Coordinate getD3() {
        return d3;
    }

    public Coordinate getE3() {
        return e3;
    }

    public Coordinate getF3() {
        return f3;
    }

    public Coordinate getG3() {
        return g3;
    }

    public Coordinate getH3() {
        return h3;
    }

    public Coordinate getA2() {
        return a2;
    }

    public Coordinate getB2() {
        return b2;
    }

    public Coordinate getC2() {
        return c2;
    }

    public Coordinate getD2() {
        return d2;
    }

    public Coordinate getE2() {
        return e2;
    }

    public Coordinate getF2() {
        return f2;
    }

    public Coordinate getG2() {
        return g2;
    }

    public Coordinate getH2() {
        return h2;
    }

    public Coordinate getA1() {
        return a1;
    }

    public Coordinate getB1() {
        return b1;
    }

    public Coordinate getC1() {
        return c1;
    }

    public Coordinate getD1() {
        return d1;
    }

    public Coordinate getE1() {
        return e1;
    }

    public Coordinate getF1() {
        return f1;
    }

    public Coordinate getG1() {
        return g1;
    }

    public Coordinate getH1() {
        return h1;
    }

    public void printField(){
        System.out.println("-----------------------------------------------------------------");
        System.out.println(coordinateStringMap.get(a8) + "\t" + coordinateStringMap.get(b8) + "\t" + coordinateStringMap.get(c8) + "\t" + coordinateStringMap.get(d8) + "\t" + coordinateStringMap.get(e8) + "\t" + coordinateStringMap.get(f8) + "\t" + coordinateStringMap.get(g8) + "\t" + coordinateStringMap.get(h8));
        System.out.println(coordinateStringMap.get(a7) + "\t" + coordinateStringMap.get(b7) + "\t" + coordinateStringMap.get(c7) + "\t" + coordinateStringMap.get(d7) + "\t" + coordinateStringMap.get(e7) + "\t" + coordinateStringMap.get(f7) + "\t" + coordinateStringMap.get(g7) + "\t" + coordinateStringMap.get(h7));
        System.out.println(coordinateStringMap.get(a6) + "\t" + coordinateStringMap.get(b6) + "\t" + coordinateStringMap.get(c6) + "\t" + coordinateStringMap.get(d6) + "\t" + coordinateStringMap.get(e6) + "\t" + coordinateStringMap.get(f6) + "\t" + coordinateStringMap.get(g6) + "\t" + coordinateStringMap.get(h6));
        System.out.println(coordinateStringMap.get(a5) + "\t" + coordinateStringMap.get(b5) + "\t" + coordinateStringMap.get(c5) + "\t" + coordinateStringMap.get(d5) + "\t" + coordinateStringMap.get(e5) + "\t" + coordinateStringMap.get(f5) + "\t" + coordinateStringMap.get(g5) + "\t" + coordinateStringMap.get(h5));
        System.out.println(coordinateStringMap.get(a4) + "\t" + coordinateStringMap.get(b4) + "\t" + coordinateStringMap.get(c4) + "\t" + coordinateStringMap.get(d4) + "\t" + coordinateStringMap.get(e4) + "\t" + coordinateStringMap.get(f4) + "\t" + coordinateStringMap.get(g4) + "\t" + coordinateStringMap.get(h4));
        System.out.println(coordinateStringMap.get(a3) + "\t" + coordinateStringMap.get(b3) + "\t" + coordinateStringMap.get(c3) + "\t" + coordinateStringMap.get(d3) + "\t" + coordinateStringMap.get(e3) + "\t" + coordinateStringMap.get(f3) + "\t" + coordinateStringMap.get(g3) + "\t" + coordinateStringMap.get(h3));
        System.out.println(coordinateStringMap.get(a2) + "\t" + coordinateStringMap.get(b2) + "\t" + coordinateStringMap.get(c2) + "\t" + coordinateStringMap.get(d2) + "\t" + coordinateStringMap.get(e2) + "\t" + coordinateStringMap.get(f2) + "\t" + coordinateStringMap.get(g2) + "\t" + coordinateStringMap.get(h2));
        System.out.println(coordinateStringMap.get(a1) + "\t" + coordinateStringMap.get(b1) + "\t" + coordinateStringMap.get(c1) + "\t" + coordinateStringMap.get(d1) + "\t" + coordinateStringMap.get(e1) + "\t" + coordinateStringMap.get(f1) + "\t" + coordinateStringMap.get(g1) + "\t" + coordinateStringMap.get(h1));
    }
}
