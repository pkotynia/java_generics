package pl.polcodex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _01Subtyping {
    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2.0);
        System.out.println(numbers);

        List<Integer> integers = new ArrayList<>();
        //List<Number> numbers2 = integers;
        //numbers2.add(1.0); - this will not compile because of type safety in generics 

        List<Number> numbers2 = new ArrayList<>();
        numbers2.add(1.0);
        // List<Integer> integers2  = numbers2 - this will also not compile because of type safety in generics

        List<Number> numbers3 = new ArrayList<>();
        List<Integer> ints = List.of(1, 2, 3);
        List<Double> doubles = List.of(1.0, 2.0, 3.0);

        numbers3.addAll(ints); // this is possible because addAll method is defined as addAll(Collection<? extends E> c)
        numbers3.addAll(doubles);

        System.out.println(numbers3); // [1, 2, 3, 1.0, 2.0, 3.0]

        List<Object> objects = Stream.of(1,2,3,"tralala").collect(Collectors.toList());
        List<Integer> integers2 = List.of(7, 8, 9);
        Collections.copy(objects, integers2);

        System.out.println(objects); // [1, 3, 4, "tralala"]
        System.out.println(integers2); // [1, 3, 4]

        Collections.<Object>copy(objects, integers2);
        System.out.println(objects); // [7, 8, 9, "tralala"]


    }
}
