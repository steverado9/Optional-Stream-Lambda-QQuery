package org.example.optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
//creating Optional Object
public class Main {
    public static void main(String[] args) {
        Optional<String> empty = Optional.empty();
        System.out.println("is there is value " + empty.isPresent());

        String name = "Stephen";
        Optional<String> opt = Optional.of(name);
        System.out.println("is there a value " + opt.isPresent());

        //But in case we expect some null values, we can use the ofNullable() method
        //By doing this, if we pass in a null reference, it doesn’t throw an exception but rather returns an empty Optional object
        String username = null;
        Optional<String> opt1 = Optional.ofNullable(username);
        System.out.println("is there a value " + opt1.isEmpty());

        // Conditional Action With ifPresent()
        opt.ifPresent( n -> System.out.println("yes"));

        // Default Value With orElse
        String value = Optional.ofNullable(username).orElse("john");
        System.out.println("Value = " + value);

        // Default Value With orElse
        String value1 = Optional.ofNullable(username).orElseGet(() -> "john");
        System.out.println("Value = " + value1);

        //Exception with orElseThrow()
        // String value2 = Optional.ofNullable(username).orElseThrow(IllegalArgumentException::new);
        // String value2 = Optional.ofNullable(username).orElseThrow();

        //Returning Value With get()
        String value2 = opt.get();
        System.out.println("Value = " + value2);

        //Conditional Return With filter()
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        System.out.println("is2016 = " +  is2016);

        boolean is2017 = yearOptional.filter(y -> y ==2017).isPresent();
        System.out.println("is2017 = " + is2016);


        //Transforming Value With map()
        List<String> companyNames = Arrays.asList( "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional
                .map(List::size)
                .orElse(0);
        System.out.println("Size = " + size);

        //Transforming Value With flatMap()
        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);

        Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);

        Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);

        String name1 = nameOptional.orElse("");
        System.out.println("John " + name1);

        String name2 = personOptional.flatMap(Person::getName).orElse("");
        System.out.println("john " + name2);

        //The or() Method
        String expected = "properValue";
        Optional<String> value3 = Optional.of(expected);
        Optional<String> defaultValue = Optional.of("default");

//        Optional<String> result = value.or(() -> defaultValue);

    }

}
