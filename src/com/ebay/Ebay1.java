package com.ebay;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vnagpurkar on 7/11/16.
 */
public class Ebay1 {

    // count number of words in a paragraph
    public static int countWords(String paragraph, String word) {

        String wordPattern = "\\b" + word + "\\b";
        Pattern pattern = Pattern.compile(wordPattern);
        Matcher matcher = pattern.matcher(paragraph);

        int count = 0;
        while(matcher.find()) {
            count++;
        }
        return count;
    }

    public static String delDel(String str) {

        if(str == null || str.length() < 4) return str;

        String temp = str.substring(1, 4);
        if(temp.equals("del")) {
            return str.substring(0,1)+str.substring(4,str.length());
        }
        return str;
    }

    // Given String representation of an object and list of classes,
    // how would you determine which class the object belongs to?
    // Note once Object is converted into string representation, isInstanceOf method cannot be used
    public static void getClassName() {

        TestClass object = new TestClass();
        //String cn = object.getClass().getName(); // this can also be done similar to line 43
        String cn = object.toString(); // toString method of the object is overridden to return fully qualified class name


        Class c2 = null;
        try {
            c2 = Class.forName(cn, true, ClassLoader.getSystemClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(object.getClass().equals(c2));
        // reflection can be used to get methods using methodname,
        try {
            // public method
            java.lang.reflect.Method methodPublic = object.getClass().getMethod("testPublicMethod", String.class);
            // private method
            java.lang.reflect.Method methodPrivate = object.getClass().getDeclaredMethod("testPrivateMethod", String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
