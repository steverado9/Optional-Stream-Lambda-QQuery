package org.example.JavaStreams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        //finding the even numbers in a list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        //with streams
        var evenNumbers1 = numbers.stream()
                .filter(number -> number % 2 == 0)
                .toList();
        System.out.println(evenNumbers1);
    }
}
