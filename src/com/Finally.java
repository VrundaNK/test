package com;

/**
 * Created by vnagpurkar on 7/24/16.
 */
/*
Example to explain behaviour of try, catch and finally
 */
public class Finally {

    private static String lem() {
        System.out.println("lem");
        return "return from lem";
    }

    private static String foo() {
        int x = 0;
        int y = 5;
        try {
            System.out.println("start try");
            int b = y / x;
            System.out.println("end try");
            return "returned from try";
        } catch (Exception ex) {
            System.out.println("catch");
            return lem() + " | returned from catch";
        } finally {
            System.out.println("finally");
        }
    }

    public static void bar() {
        System.out.println("start bar");
        String v = foo();
        System.out.println(v);
        System.out.println("end bar");
    }

}
