@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("20221114 지성빈 예외");
            int throwing =1/0;
        } catch (Exception e) {
            System.out.println("예외처리루틴: " + e + "예외 발생");
        } finally {
            System.out.println("예외처리 후 finally 블럭 수행함");
        }
    }
}