package uni.pu.fmi.services;

import uni.pu.fmi.models.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import uni.pu.fmi.db.MainRepo;

public class MyOrdersService {


    public static String checkOrders(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return "Нямате направени поръчки";
        } else {
            return "Имате направени поръчки";}
    }

    public List<Order> load(String period, String trackingNumber) {

        List<Order> result = MainRepo.orderList;

        if (result.isEmpty()){

            return null;}


        if (trackingNumber!=null){
        result = filterByTrackingNumber(trackingNumber, result);
        } else if (period!=null) {
            result = filterByPeriod(period, result);
        }

        return result;
    }

    public static List<Order> filterByTrackingNumber(String trackingNumber, List<Order> result) {
        if (trackingNumber != null && !trackingNumber.trim().isEmpty()) {
            result =  result.stream().filter(m -> m.getTrackingNumber().contains(trackingNumber)).collect(Collectors.toList());
        }
        return result;
    }


    public static List<Order> filterByPeriod(String period, List<Order> orders) {
        LocalDate now = LocalDate.now();
        LocalDate startDate = calculateStartDate(period, now);

        if (startDate != null) {
            orders = orders.stream()
                    .filter(order -> order.getOrderDate().isAfter(startDate))
                    .collect(Collectors.toList());
        }
        return orders;
    }

    private static LocalDate calculateStartDate(String period, LocalDate now) {
        switch (period.toLowerCase()) {
            case "1 месец":
                return now.minusMonths(1);
            case "3 месеца":
                return now.minusMonths(3);
            case "6 месеца":
                return now.minusMonths(6);
            case "1 година":
                return now.minusYears(1);
            default:
                return null;
        }
    }


}
