import java.util.List;
import java.util.function.Predicate;

public class StrategyPattern {
    /*
        Strategy Pattern
        we want to vary a small part of an algorithm while keeping the rest of the algorithm same
        "memvariasikan sebagian kecil dari sebuah algoritma sambil menjaga agar algoritma lainnya tetap sama"

        Design pattern often kick in to fill the gaps of a programming language
        "Pola desain sering kali digunakan untuk mengisi kekosongan dengan bahasa pemrograman"

        A more power lang is, the less we talk about design pattern

        in the past, we created an interface and then a bunch of classes then wire them together often use factories
        instead of we can use lambda.
        lambda are lightweight strategies

    */
    public static void main(String[] args) {

        /*
            Suppose we have list of qty product
         */

        var products = List.of(1, 3, 4, 11, 2, 6);
        var total = getTotalValues(products, ignore -> true);

        // we just pass condition in param instead make another method
//        var totalEvenValue = getTotalValues(products, x -> x % 2 == 0); 
//        var totalOddValue = getTotalValues(products, x -> x % 2 != 0);

        // we can use this way too StrategyPattern::methodName instead of give an explicit condition like "x % 2 == 0" in params
        var totalEvenValue = getTotalValues(products, StrategyPattern::isEven);
        var totalOddValue = getTotalValues(products, StrategyPattern::isOdd);
        System.out.println("Total: "+total);
        System.out.println("Total product even: "+totalEvenValue);
        System.out.println("Total product odd: "+totalOddValue);


    }

    private static boolean isOdd(Integer integer) {
        return integer % 2 != 0;
    }

    private static boolean isEven(Integer integer) {
        return integer % 2 == 0;
    }

    //    Sum using stream
    private static Integer getTotalValues(List<Integer> products,
                                          Predicate<Integer> selector) {
        return products
                .stream()
                .filter(selector)
                .mapToInt(e -> e)
                .sum();
    }

    private static Integer getTotalEvenValues(List<Integer> products) {
        var total = 0;
        for (var p :
                products) {
            if (p % 2 == 0) {
                total += p;
            }
        }
        return total;
    }
//      Using traditional loop
//    private static Integer getTotalValues(List<Integer> products,
//                                          Predicate<Integer> selector) {
//        var total = 0;
//        for (var p :
//                products) {
//            if (selector.test(p)){
//                total += p;
//            }
//        }
//        return total;
//    }
}
