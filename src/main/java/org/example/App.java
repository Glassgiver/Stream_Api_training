package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class App
{
    public static void main( String[] args ) {
        part1();
        part2();
    }

    //----------------------------------- part 1 -------------------------------------- //
    public static void part1(){
        ArrayList<Integer> numbers1 = new ArrayList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();
        List<Users> users = Arrays.asList(
                new Users(12, "Bob"),
                new Users(13, "Alex"),
                new Users(22, "Harvey"),
                new Users(62, "Henry"),
                new Users(2, "Greg")
        );
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

        System.out.println(mulEvenNumbers(numbers1));

        System.out.println(countGroups(words1));

        System.out.println(sortByAgeFindEldest(users));
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

    //Найдите все четные числа в списке и умножьте их на 2.
    public static List<Integer> mulEvenNumbers(List<Integer> numbers){
        return numbers.stream().filter(n -> n % 2 == 0).map(n -> n * 2).collect(Collectors.toList());
    }

    //Разделите список строк на группы по первой букве и посчитайте количество строк в каждой группе.
    public static Map<?,?> countGroups(List<String> strings){
        return strings.stream().collect(Collectors.groupingBy(s -> s.charAt(0) , Collectors.counting()));
    }

    //Отсортируйте список пользователей по возрасту и выберите самого старшего.
    public static String sortByAgeFindEldest(List<Users> users){
        List<Users> sortedUsers = users.stream().sorted(Comparator.comparingInt(Users::getAge)).collect(Collectors.toList());
        return "Sorted list: " + sortedUsers.stream().map(Users::getName).collect(Collectors.joining(", ")) + "\nThe eldest: " + sortedUsers.get(sortedUsers.size()-1).getName();
    }


    //----------------------------------- part 2 -------------------------------------- //
    //Из списка корзин получите среднюю сумму заказа для каждого клиента.

    public static void part2(){
        List<Clients> clientsList = Arrays.asList(
                new Clients(1, "Bob"),
                new Clients(2, "Briana"),
                new Clients(3, "Henry")
        );

        List<Cart> carts = Arrays.asList(
                new Cart(1, new ArrayList<>()),
                new Cart(2, new ArrayList<>()),
                new Cart(3, new ArrayList<>())
        );

        List<Products> products = Arrays.asList(
                new Products(1, 202, "pen"),
                new Products(2, 2122, "cake"),
                new Products(3, 1402, "honey"),
                new Products(4, 3202, "cheese"),
                new Products(5, 2312, "lamp"),
                new Products(6, 802, "banana")
        );

        carts.get(0).addProduct(1);
        carts.get(0).addProduct(3);
        carts.get(1).addProduct(5);
        carts.get(1).addProduct(1);
        carts.get(2).addProduct(6);
        carts.get(2).addProduct(5);
        carts.get(2).addProduct(3);

        averageSum(carts, products, clientsList);

    }
    public static void averageSum(List<Cart> carts, List<Products> products, List<Clients> clientsList){
        List<Integer> sums = carts.stream()
                .mapToInt(cart -> cart.getProductList().stream()  // получаем поток всех Integer из списка продуктов каждой корзины
                        .mapToInt(index -> products.get(index - 1).getPrice())  // получаем поток цен каждого продукта
                        .sum())  // вычисляем сумму цен продуктов в каждой корзине
                .boxed()  // преобразуем IntStream в Stream<Integer>
                .collect(Collectors.toList());  // собираем результат в список

        for (int i = 0; i < carts.size(); i++) {
            int index = i;
            System.out.println(clientsList.stream()
                    .filter(client -> client.getId() == carts.get(index).getId())
                    .map(Clients::getName)
                    .findFirst()
                    .orElse("Unknown") + "'s sum: " + sums.get(i));
        }

//        sums.stream()
//                .forEach(s -> System.out.println(s));
    }

}
