package com.dudchenko.cache;

import java.util.Scanner;

public class Run {

    public static void main(String[] arg){

        LRUCache<String, Integer> cache = new LRUCache<>(4);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello: ");
        String input;
        do {
            input = scanner.nextLine();
            System.out.println("lenght from cahce befor putting it there " + cache.get(input));
            cache.put(input, input.length());
            System.out.println("    actual length " + input.length());
            System.out.println("lenght from cahce " + cache.get(input));

            System.out.println(cache.toString());

        } while (!input.equalsIgnoreCase("exit"));





    }

}
