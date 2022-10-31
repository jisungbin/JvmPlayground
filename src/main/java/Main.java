public class Main {
    public static void main(String[] args) {
        System.out.println("20221031 지성빈 클래스");
        Cat3 aCat = new Cat3();
        aCat.setName("야옹이");
        System.out.println(aCat.getName() + "의 장점 = " + aCat.crawling());
        System.out.println(aCat.getName() + "는 " + aCat.identify());
    }
}

class Animal3 {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String identify() {
        return "동물";
    }
}

class Cat3 extends Animal3 {
    public String crawling() {
        return "나무오르기";
    }

    @Override
    public String identify() {
        return "고양이";
    }
}
