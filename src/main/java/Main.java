@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        System.out.println("20221011 지성빈 배열");

        for (int i = 1; i <= 30; i++) {
            printIfPrime(i);
        }
    }

    public static void printIfPrime(int number) {
        if (number < 2) {
            return;
        }
        if (number == 2) {
            System.out.print(number + " ");
            return;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return;
            }
        }
        System.out.print(number + " ");
    }
}