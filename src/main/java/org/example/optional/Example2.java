package org.example.optional;

import java.util.Optional;

public class Example2 {
    public static void main(String[] args) {
        Optional<String> name = Optional.of("Alice");
        name.ifPresent(System.out::println);
    }
}
