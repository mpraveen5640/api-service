package com.example.api_service.constants;

import java.util.Arrays;
import java.util.List;

public class DemoClass {
    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        input.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
    }
}
