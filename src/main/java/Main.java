public class Main {

    static double PI = 3.141592;
    static double rd = 15.3;

    public static void main(String[] args) {
        System.out.println("20211152 지성빈 변수");
        System.out.println("원주율 " + PI + ", 반지름 " + rd + "cm 인 원의 면적은 " + String.format("%e", PI * rd * rd) + "cm^2 입니다.");
    }
}