package uni.pu.fmi.db;

import uni.pu.fmi.models.Flower;
import uni.pu.fmi.models.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainRepo {

    public static List<Flower> flowers = new ArrayList<Flower>();
    public static List<Order> orderList = new ArrayList<Order>();

    static{


        Flower f1=new Flower(1L,"Роза","Айсберг","розово",5);
        Flower f2=new Flower(2L,"Лале","Ван Ейк","червено",3);
        Flower f3=new Flower(3L,"Нарцис","Tazetta","жълто",3);

        flowers.add(f1);
        flowers.add(f2);
        flowers.add(f3);

        Order o1 = new Order(1L, "2345678", 5, 22.30, LocalDate.of(2023, 3, 3));
        Order o2 = new Order(2L, "12346", 2, 15.00, LocalDate.of(2023, 4, 10));
        Order o3 = new Order(3L, "12347", 7, 30.50, LocalDate.of(2023, 5, 15));
        Order o4 = new Order(4L, "12348", 1, 5.99, LocalDate.of(2023, 6, 20));
        Order o5 = new Order(5L, "12349", 10, 50.00, LocalDate.of(2024, 5, 1));

        orderList.add(o1);
        orderList.add(o2);
        orderList.add(o3);
        orderList.add(o4);
        orderList.add(o5);

    }

    public static Flower findFlowerByName(String name) {
        return flowers.stream()
                .filter(flower -> flower.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
