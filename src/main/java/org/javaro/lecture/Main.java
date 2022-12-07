package org.javaro.lecture;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CycleList cycles = new CycleList();

        Cycle cycle = new Cycle("Cycle", 1000, LocalTime.now().minusHours(1));
        Cycle cycle2 = new Cycle("Good Cycle", 2000, LocalTime.now().minusHours(2));
        Cycle cycle3 = new Cycle("Amazing Cycle", 3000, LocalTime.now().minusHours(3));
        Cycle cycle4 = new Cycle("Awesome Cycle", 4000, LocalTime.now().minusHours(4));

        cycles.rent(cycle);
        cycles.rent(cycle2);
        cycles.rent(cycle3);
        cycles.rent(cycle4);

        cycles.checkOut(cycle);
        cycles.checkOut(cycle2);
        cycles.checkOut(cycle3);
        cycles.checkOut(cycle4);
    }

    public static class Cycle {
        private final String name;
        private final int price;
        private final LocalTime rentDate;

        public Cycle(String name, int price, LocalTime rentDate) {
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
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        private final List<Cycle> cycles = new ArrayList<>();

        public void rent(Cycle cycle) {
            cycles.add(cycle);
            System.out.println(cycle.getName() + " rental completed");
        }

        public void checkOut(Cycle cycle) {
            cycles.remove(cycle);
            System.out.println(cycle.getName() + " return complete. rental price : " + calculatePrice(cycle) + "won");
        }

        public int calculatePrice(Cycle cycle) {
            if (cycle.getRentDate() == null) {
                return 0;
            }
            return (LocalTime.now().getHour() - cycle.getRentDate().getHour()) * 60 * cycle.getPrice();
        }
    }
}
