import java.util.Optional;

/*
    Null is smell
    A good design reads like a story and not like a puzzle
    Make the obvious

    When don't use Optional?
    - If a method will always have single value "nilai selalu ada(non null)" as a result
    - If the result is Collections.
    - Never use Optional<T> as a parameter to Methods. if needed to set an empty value use overloading instead

 */
public class PlayingOptionalPattern {


    public static void main(String[] args) {

        /*
               smell code example

               var email = getEmail();

               if(email != null) {
                  System.out.println(email);
               }
         */
        var email = getEmail();

        System.out.println(email.orElse("Email not found")); // good idea
        System.out.println(email.orElseThrow()); // good idea
//        System.out.println(email.get()); // smell

    }

    private static Optional<String> getEmail() {
        if (Math.random() <= 0.5)
            return Optional.of("example@gmail.com");


//        return null --bad idea
        return Optional.empty(); // --good idea
    }
    /*
        Effective way: Don't return null, instead return an empty *collections
     */
}
