import java.util.function.Supplier;

public class PlayingLaziness {
    public static void main(String[] args) {

        var n = 9;

        // eager evaluation
        // var temp = compute(n);

        // lazy evaluation
        Lazy<Integer> temp = new Lazy<>(() -> compute(n));


        // first condition false, and next condition will be not call. (AND)
        // the condition name is short circuiting
        // An concept in which the compiler skips the execution or evaluation of some sub-expressions in a logical expression.
//        if (n > 9 && compute(n) > 10){
        if (n > 9 && temp.getInstance() > 10){
            System.out.println("Path a");
        } else {
            System.out.println("Path b");
        }

    }

    private static int compute(int n) {
        System.out.println("compute called " + (n * 100));
        return n * 100;
    }
}

class Lazy<T> {
    private T instance;
    private Supplier<T> supplier;
    Lazy(Supplier<T> supplier){
        this.supplier = supplier;
    }

    public T getInstance() {
        if (instance == null) {
            instance = supplier.get();
        }
        return instance;
    }
}
