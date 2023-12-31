package pattern.singleton;

public class PatternMain {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        System.out.println("singleton1 address : " + singleton1);

        Singleton singleton2 = Singleton.getInstance();
        System.out.println("singleton2 address : " + singleton2);

        if (singleton1 == singleton2) {
            System.out.println("singleton success");
        }
    }

}
