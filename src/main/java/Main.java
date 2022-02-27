import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        final SomeResource resource = new SomeResource(3);

        for (int i = 1; i <= 10; i++) {
            Thread t = new Thread(resource::use);
            t.start();
        }

    }
}

class SomeResource {
    private final Semaphore semaphore;
    private final int maxThread;

    public SomeResource(int maxThread) {
        this.maxThread = maxThread;
        this.semaphore = new Semaphore(maxThread);
    }

    public void use() {
        try {
            semaphore.acquire(); // Thread 가 semaphore 에게 시작을 알림

            System.out.println("[" + Thread.currentThread().getName() + "]" + (maxThread - semaphore.availablePermits()) + "쓰레드가 점유중");

            // semaphore.availablePermits() 사용가능한 Thread 의 숫자

            Thread.sleep((long) (Math.random() * 10000));

            semaphore.release(); // Thread 가 semaphore 에게 종료를 알림
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}