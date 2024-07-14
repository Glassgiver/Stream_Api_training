package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class App
{
    public static void main( String[] args ) {
        ArrayList<Integer> numbers1 = new ArrayList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();
        numbers1.add(2);
        numbers1.add(5);
        numbers1.add(5);
        numbers1.add(8);
        System.out.println(averageOfListOfInteger(numbers1));

        List <String> words1 = Arrays.asList("Apple", "JUICE", "baNAna", "chocolatE");
        ArrayList<String> words2 = new ArrayList<>();
        words2.add("aAA");
        words2.add("baAAaaaa");
        words2.add("AA");
        System.out.println(upperCaseToLowerCase(words1));
        System.out.println(upperCaseToLowerCase(words2));

        System.out.println(sumOfEvenOddNum(numbers1));

        System.out.println(deleteDuplicates(numbers1));

        System.out.println("Counted: " + countSpecificLetterStart(words2, "a"));

        System.out.println(words2);

        System.out.println(alphabeticOrder(words1, "asc"));
        System.out.println(alphabeticOrder(words1, "des"));

        try{
            System.out.println(maxAndMin(numbers1, "min"));
            System.out.println(maxAndMin(numbers1, "max"));
        } catch (NullPointerException e){
            System.out.println("Your list is incorrect: numbers1 = " + numbers1);
        }


        try{
            System.out.println(maxAndMin(numbers2, "max"));
        }
        catch (NullPointerException e){
            System.out.println("Your list is incorrect: numbers2 = " + numbers2);
        }


    }



    //1. Write a Java program to calculate the average of a list of integers using streams.
    public static double averageOfListOfInteger(List<Integer> numbers){
        return numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
    }

    //Write a Java program to convert a list of strings to uppercase or lowercase using streams.
    public static List<String> upperCaseToLowerCase(List<String> list){
        return list.stream().map(String::toLowerCase).collect(Collectors.toList());
    }

    //Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
    public static String sumOfEvenOddNum(List<Integer> numbers){
        int sumEven = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        int sumOdd = numbers.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        return "Sum of Even: " + sumEven + "\nSum of Odd: " + sumOdd;
    }

    //Write a Java program to remove all duplicate elements from a list using streams.
    public static List<?> deleteDuplicates(List<?> list){
        return list.stream().distinct().collect(Collectors.toList());
    }

//    //Write a Java program to count the number of strings in a list that start with a specific letter using streams.
    public static long countSpecificLetterStart(List<?> list, String letter){
        return list.stream()
                .map(Object::toString)
                .map(String::toLowerCase)
                .filter(el -> el.startsWith(letter.toLowerCase()))
                .count();
    }

    // Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
    public static List<String> alphabeticOrder(List<String> words, String var){
        if (var.equalsIgnoreCase("asc")) {
            return words.stream()
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList());
        } else if (var.equalsIgnoreCase("des")) {
            return words.stream()
                    .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                    .collect(Collectors.toList());
        }
        return words;
    }

    //Write a Java program to find the maximum and minimum values in a list of integers using streams.
    public static int maxAndMin(List<Integer> numbers, String var) throws NullPointerException{
        Optional<Integer> res = Optional.empty();
        if (var.equalsIgnoreCase("max")){
           res = numbers.stream().max(Integer::compare);
        } else if (var.equalsIgnoreCase("min")) {
            res = numbers.stream().min(Integer::compare);
        }
        return res.orElse(null);
    }




}
