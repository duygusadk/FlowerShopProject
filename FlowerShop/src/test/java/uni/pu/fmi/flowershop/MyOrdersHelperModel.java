package uni.pu.fmi.flowershop;

import lombok.Getter;
import lombok.Setter;
import uni.pu.fmi.models.Order;

import java.util.List;

@Getter
@Setter
public class MyOrdersHelperModel {

    private  String trackingNumber;
    private String period;
    private List<Order> orders;
}
