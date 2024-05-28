package uni.pu.fmi.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private  Long id;
    private String trackingNumber;
    private int itemQuantity;
    private double totalPrice;
    private LocalDate orderDate;
}
