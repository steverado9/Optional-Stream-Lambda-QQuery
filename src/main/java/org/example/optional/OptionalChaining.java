package org.example.optional;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalChaining {

    private Optional<String> getEmpty() {
        return Optional.empty();
    }

    private Optional<String> getHello() {
        return Optional.of("hello");
    }

    private Optional<String> getBye() {
        return Optional.of("bye");
    }

    private Optional<String> createOptional(String input) {
        if (input == null || "".equals(input) || "empty".equals(input)) {
            return Optional.empty();
        }
        return Optional.of(input);
    }

    //In order to chain several Optional objects and get the first non-empty one in Java 8, we can use the Stream API
    Optional<String> found = Stream.of(getEmpty(), getHello(), getBye())
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst();

    public static void main(String[] args) {

    }
}
