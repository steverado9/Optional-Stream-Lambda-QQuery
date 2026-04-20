package org.example.lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Example2 {
    public static void main(String[] args) {
        //Lambda with No Parameters
        Runnable runnable = () -> System.out.println("Hello, World");
        runnable.run();

        // Lambda with multiple Parameters
        Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
        System.out.println(comparator.compare(3, 3));

        //Functional Interfaces
        Predicate<Integer> isEven = number -> number % 2 == 0;
        System.out.println(isEven.test(4));

        Consumer<String> print = message -> System.out.println(message);
        print.accept("Hello, Consumer!");

        //Using Lambda Expressions with Collections
        // Sorting a List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.sort((a, b) -> a.compareTo(b));
        names.forEach(System.out::println);

        //Filtering a List
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        //Mapping a List
        List<String> words = Arrays.asList("lambda", "stream", "function");
        List<Integer> length = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(length);
    }

}
