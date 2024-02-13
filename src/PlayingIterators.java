import java.util.ArrayList;

import static java.util.List.of;

public class PlayingIterators {
    public static void main(String[] args) {

        var fruits = of("Apple", "Banana", "Avocado", "Strawberry", "Durian", "Anggur");
        var expiredFruits = new ArrayList<>();
//        external iterator
        for (String fruit :
                fruits) {
            if (fruit.startsWith("A")){
                System.out.println(fruit.toUpperCase());
            }
        }

//        we can do same iteration like above with a simple way using stream
//        example code below called internal iterator
//        because we aren't controlling the flow of iteration instead we focused on what we want as a result
        fruits.stream()
                .filter(fruit -> fruit.startsWith("A"))
                .limit(2) // limit and takeWhile are equivalent of a break from the imperative style
                .map(String::toUpperCase)
                .forEach(System.out::println);

//        if we want to populate to another list for example expiredFruits
        fruits.parallelStream() // instead using stream we can use parallelStream
                .filter(fruit -> fruit.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(expiredFruits::add);

        System.out.println(expiredFruits);
    }
}
