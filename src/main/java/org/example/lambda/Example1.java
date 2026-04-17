package org.example.lambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Consumer;

interface StringFunction {
    String run(String str);
}

public class Example1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(1);
        //lambda expression
        numbers.forEach((n) -> {System.out.println(n);});

        LinkedList<Integer> nums = new LinkedList<>();
        nums.add(5);
        nums.add(6);
        nums.add(8);
        nums.add(9);
        //lambda inside a variable
        Consumer<Integer> method = (n) -> {System.out.println(n);};
        nums.forEach(method);

        StringFunction exclaim = (s) -> s + "!";
        StringFunction ask = (s) -> s + "?";
        printFormatted("Hello", exclaim);
        printFormatted("Hello", ask);

    }

    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
    }

}
