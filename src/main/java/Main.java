@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        System.out.println("20221019 지성빈 힘수");
        int x1 = 10, y1 = 30, x2 = 20, y2 = 60;
        double length = calcLength(x1, y1, x2, y2);
        System.out.println("두 점 사이의 거리는 " + length + "입니다.");
    }

    private static double calcLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}