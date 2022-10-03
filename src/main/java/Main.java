@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        System.out.println("20221003 지성빈 반복");
        int i = 1, sum = 0;
        do {
            sum += i++;
        } while (i <= 100);
        System.out.println("1 부터 100 까지 합 = " + sum);
    }
}