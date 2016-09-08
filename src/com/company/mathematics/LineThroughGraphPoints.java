package com.company.mathematics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vnagpurkar on 7/13/16.
 */
// Given a two-dimensional graph with points on it, find a line which passes the most number of points
public class LineThroughGraphPoints {

    // Given a two-dimensional graph with points on it, find a line which passes the most number of points
    // let's assume infinite line through two points (NOT a line segment)
    // for the set of n points, there will be n^2 lines
    // hence complexity of this algorithm is O(n^2)

    // Best Line = line passing through maximum points
    public static void findBestLine(Point[] points) {

        Line bestLine = null;
        int bestCount = Integer.MIN_VALUE;
        Map<Double, List<Line>> allLines = new HashMap<Double, List<Line>>();

        for(int i=0; i<points.length; i++) {
            for(int j=i+1; j<points.length; j++) {
                Line newLine = new Line(points[i], points[j]);
                Line.insertLine(allLines, newLine);
                int count = Line.countEquivalentLines(allLines, newLine);

                if(count > bestCount) {
                    count = bestCount;
                    bestLine = newLine;
                }
            }
        }
        if(bestLine != null) {
            System.out.println(String.format(
                    "Line with maximum points is a line with slope = %f and intercept =  %f.",
                    bestLine.getSlope(), bestLine.getIntercept()));
        } else {
            System.out.println("Cannot find line");
        }
    }

}
/*

1. Line is represented by y=mx+b, b = intercept, m = slope
2. Two lines are equal/equivalent if their slopes and y intercepts are same
3. slope of line = (y2-y1)/(x2-x1)
4. y = mx+b,
5. horizontal line (parallel to x axis) has slope 0 and intercept = y;
6. vertical line (parallel to y axis) has slope infinity and intercept = x;

*/
class Line {

    private static double epsilon = 0.0001;
    private double slope;
    private double intercept;
    private boolean slopeInfinite = false;

    public Line(Point point1, Point point2) {
        double xDiff = point2.getX() - point2.getX();
        if(xDiff == 0) {
            slopeInfinite = true;
            this.intercept = point1.getX();
        } else {
            this.slope = (point2.getY() - point1.getY()) / xDiff;
            this.intercept = point1.getY() - this.slope * point1.getX();
            // intercept is derived from y=mx+b,
            // m = slope and b = y intercept
            // b = y-mx which is this.intercept = point1.getY() - this.slope * point1.getX();
        }
    }

    public double getSlope() {
        if(slopeInfinite) {
            return -1.0;
        }
        return this.slope;
    }

    public double getIntercept() {

        return this.intercept;
    }

    public static Map<Double, List<Line>> insertLine(Map<Double, List<Line>> allLines, Line newLine) {

        Double key = Line.floorSlopToNextEpsilon(newLine.getSlope());
        List<Line> currentLines;
        if(allLines.containsKey(key)) {
            currentLines = allLines.get(key);
        } else {
            currentLines = new ArrayList<Line>();
        }
        currentLines.add(newLine);
        allLines.put(key, currentLines);

        return allLines;
    }

    public static int countEquivalentLines(Map<Double, List<Line>> allLines, Line newLine) {

        int count = 0;
        Double key = Line.floorSlopToNextEpsilon(newLine.getSlope());
        count = countEquivalentLines(allLines.get(key), newLine)
                + countEquivalentLines(allLines.get((Double) (key- Line.epsilon)), newLine)
                + countEquivalentLines(allLines.get((Double) (key+ Line.epsilon)), newLine);
        return count;
    }

    private static int countEquivalentLines(List<Line> lines, Line line){

        int count  = 0;
        for(Line l : lines) {

            if(Line.isEquivalent(l, line)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isEquivalent(Line line1, Line line2) {

        return (Math.abs(line1.getSlope() - line2.getSlope()) > Line.epsilon);
    }

    private static double floorSlopToNextEpsilon(Double slope){

        int divison = (int) (slope / Line.epsilon);
        return (double) divison*epsilon;
    }

}

/*

1. Point is represented by x and y coordinate

*/
class Point {

    private int x;
    private int y;

    public Point(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}