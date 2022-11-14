@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        System.out.println("20221114 지성빈 인터페이스");
        KHello4 hello1 = new KHello4();
        hello1.goodMorning3();
        hello1.goodNight3();
        hello1.goodAftermoon3();
    }
}

interface GoodMoring3 {
    void goodMorning3();
}

interface GoodNight3 {
    void goodNight3();
}

class KHello3 implements GoodMoring3, GoodNight3 {
    @Override
    public void goodMorning3() {
        System.out.println("좋은 아침");
    }

    @Override
    public void goodNight3() {
        System.out.println("좋은 저녁");
    }
}

interface KSay extends GoodMoring3, GoodNight3 {
    void goodAftermoon3();
}

class KHello4 extends KHello3 implements KSay {
    @Override
    public void goodAftermoon3() {
        System.out.println("좋은 점심");
    }
}