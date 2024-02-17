

/*
        all platform method payment class ("Gopay", "Dana") implements Payment

 */
public class PlayingFactoryMethodPattern {
    public static void main(String[] args) {

        call(new UserGopayPayment());
        call(new UserDanaPayment());

    }

    private static void call(User userPayment) {
        userPayment.proceed();
    }
}

interface Payment {}

class Gopay implements Payment{}
class Dana implements Payment{}

interface User {
    Payment getPayment();
    default void proceed(){
        System.out.println("Do payment using " + getPayment());
    }
}

class UserGopayPayment implements User{

    @Override
    public Payment getPayment() {
        return new Gopay();
    }
}
class UserDanaPayment implements User{

    @Override
    public Payment getPayment() {
        return new Dana();
    }
}