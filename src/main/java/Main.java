@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        System.out.println("20221011 지성빈 함수");
        System.out.println(genderToKor("female"));
        System.out.println(genderToKor("male"));
    }

    static String genderToKor(String gender) {
        if (gender == "female") return "여자";
        else return "남자";
    }
}