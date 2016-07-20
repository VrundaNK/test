package com.company.mathematics.lines;

/**
 * Created by vnagpurkar on 7/13/16.
 */
// Given two lines on a Cartesian plane, determine whether the two lines would intersect
public class AreLinesIntersect {

    // Given two lines on a Cartesian plane, determine whether the two lines would intersect
    // 1. Two lines do not intersect if those are parallel to each other,
    // If slopes of two lines are same then lines are parallel (DO NOT INTERSECT)

    // 2. Two lines are same
    // a. slopes of two lines are same and
    // b. y intercepts of two lines are same

    // Few Assumptions to solve this problems
    // 1. If both lines line1 and line2 are same (as per point 2) then those intersect
    // 2. We can choose datastructure of line and define a line using slope and y intercept y = mx+b
    // 3. if assumption 2 is not allowed, then we need to calculate slope of line using points (y2-y1)/(m2-m1)
    public static boolean areLinesIntersect(Line line1, Line line2) {

        // Case 1
        //slopes of line1 and line2 are SAME (differ just by epsilon) and
        // y intercepts of line1 and line2 are same (differ just by epsilon) then lines are same
        // using assumption 2 they intersect

        // Case 2
        //slopes of line1 and line2 are DIFFERENT (greater than epsilon)
        // then lines intersect.
        if(   (Math.abs(line1.getSlope()-line2.getSlope()) >= Line.epsilon) // for both case1 and case2
            || (Math.abs(line1.getIntercept() - line2.getIntercept()) < Line.epsilon)) //for case1
        {
            return true;
        }

        return false;
    }
}

/*
This is line representation using slope and y intercept
y = mx + b, m = slope and b = y intercept
slope = (y2-y1) / (x2-x1)

y intercept which is b = y-mx
 */
class Line {

    private double slope;
    private double intercept;
    public static double epsilon = 0.0001;
    private boolean isInfiniteSlope = false;

    public Line(double slope, double intercept) {

        this.slope = slope;
        this.intercept = intercept;

        if (slope == -1) {
            isInfiniteSlope = true;
        }
    }

    public double getSlope() {
        return this.slope;
    }

    public double getIntercept() {
        return this.intercept;
    }

}