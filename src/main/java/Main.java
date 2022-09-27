public class Main {
    public static void main(String[] args) {
        System.out.println("20220927 지성빈 연산자");
        int x = 6, y = 7;
        System.out.println("!(x>6): " + !(x > 6));
        System.out.println("(x == 6 && x == 5): " + (x == 6 && x == 5));
        System.out.println("(x == 6 || x == 5): " + (x == 6 || x == 5));
        System.out.println("(x > -1 && y < 10): " + (x > -1 && y < 10));
        System.out.println("(x > 10 && y < 5): " + (x > 10 && y < 5));
    }
}