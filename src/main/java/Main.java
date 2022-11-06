public class Main {
    public static void main(String[] args) {
        System.out.println("20221107 지성빈 상속");
        new SmartPhone().display();
    }
}

abstract class Device {
    String name;

    abstract void display();
}

class SmartPhone extends Device {
    void display() {
        System.out.println("스마트폰 디스플레이");
    }
}