import java.awt.Toolkit;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        test: {
            System.out.println("Hello!");
            break test;
        }
        System.out.println("World!");
    }
}