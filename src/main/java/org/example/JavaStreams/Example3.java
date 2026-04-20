package org.example.JavaStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Terminal Operations
public class Example3 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Reflection", "Collection", "Stream", "Structure", "Sorting", "State"
        );

        //forEach: Print each name
        System.out.println("ForEach: ");
        names.stream().forEach(System.out::println);

        //collect: Collect names starting with 'S' into a list
        List<String> sNames = names.stream()
                .filter(name -> name.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println("collect names starting with 's': " );
        sNames.forEach(System.out::println);

        //reduce : Concatenate all names into single string
        String concatenatedNames = names.stream()
                .reduce("", (partialString, element) -> partialString + " " + element);
        System.out.println("reduce (concatenated names):");
        System.out.println(concatenatedNames.trim());

        //count: Count the number of names
        long count = names.stream().count();
        System.out.println("count");
        System.out.println(count);

        //findFirst: FInd the first name
        Optional<String> firstName = names.stream().findFirst();
        System.out.println("findFirst:");
        firstName.ifPresent(System.out::println);

        //allMatch: Check if all names start with 'S'
        boolean allStartWithS = names.stream().allMatch(name -> name.startsWith("S"));
        System.out.println("All match that start with 'S'");
        System.out.println(allStartWithS);

        boolean anyStartWithS = names.stream().anyMatch(name -> name.startsWith("S"));
        System.out.println("All match that start with 'S'");
        System.out.println(anyStartWithS);



    }
}
