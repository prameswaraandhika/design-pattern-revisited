import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.List.of;

public class PlayingIterators {
    public static void main(String[] args) {

        var fruits = of("Apple", "Banana", "Avocado", "Strawberry", "Durian", "Anggur");
        List<String> expiredFruits = new ArrayList<>();
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
//        the code below its bad idea
//        because the fruit result may be unpredictable
//        so we prerered not populate in stream
        fruits.parallelStream()
                .filter(fruit -> fruit.startsWith("A"))
                .map(String::toUpperCase)
                .forEach(expiredFruits::add); // bad idea

//        instead code above. we can use toList
        expiredFruits = fruits.stream()
                        .filter(fruit -> fruit.startsWith("A"))
                        .map(fruit -> fruit.concat(" has an expired!"))
                                .collect(Collectors.toList()); // good approach

        System.out.println(expiredFruits);
    }
}
