import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Cycle(@NonNull String name, @NonNull Int price, @Nullable Date rentDate) 로 자전거 객체 관리
 * CycleList#rent 로 대여한 자전거 추가
 * CycleList#checkOut 으로 자전거 반납 상태로 설정대여 시간 1분당 Cycle#price 원으로 측정
 */

public class Main {
    public static void main(String[] args) {
        CycleList cycleList = new CycleList();

        Cycle cycle = new Cycle("자전거1", 1000, LocalTime.now().minusHours(1));
        Cycle cycle2 = new Cycle("자전거2", 2000, LocalTime.now().minusHours(2));
        Cycle cycle3 = new Cycle("자전거3", 3000, LocalTime.now().minusHours(3));
        Cycle cycle4 = new Cycle("자전거4", 4000, LocalTime.now().minusHours(4));

        cycleList.rent(cycle);
        cycleList.rent(cycle2);
        cycleList.rent(cycle3);
        cycleList.rent(cycle4);

        cycleList.checkOut(cycle);
        cycleList.checkOut(cycle2);
        cycleList.checkOut(cycle3);
        cycleList.checkOut(cycle4);
    }

    public static class Cycle {
        private final String name;
        private final int price;
        private final LocalTime rentDate;

        public Cycle(@NotNull String name, int price, @Nullable LocalTime rentDate) {
            this.name = name;
            this.price = price;
            this.rentDate = rentDate;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }

        public LocalTime getRentDate() {
            return rentDate;
        }
    }

    public static class CycleList {
        private final List<Cycle> cycleList = new ArrayList<>();

        public void rent(Cycle cycle) {
            cycleList.add(cycle);
            System.out.println(cycle.getName() + " 대여 완료");
        }

        public void checkOut(Cycle cycle) {
            cycleList.remove(cycle);
            System.out.println(cycle.getName() + " 반납 완료. 대여 가격 : " + calculatePrice(cycle) + "원");
        }

        public int calculatePrice(@NotNull Cycle cycle) {
            if (cycle.getRentDate() == null) {
                return 0;
            }
            return (int) ((LocalTime.now().getHour() - cycle.getRentDate().getHour()) * 60 * cycle.getPrice());
        }
    }
}
