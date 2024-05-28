package uni.pu.fmi.flowershop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.db.MainRepo;
import uni.pu.fmi.models.Order;
import uni.pu.fmi.services.MyOrdersService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MyOrdersSteps {
   private String message;

 private MyOrdersHelperModel myOrdersHelperModel;

    public MyOrdersSteps(MyOrdersHelperModel myOrdersHelperModel) {
        this.myOrdersHelperModel = myOrdersHelperModel;
    }

    @When("отваряне на приложението")
    public void openApp() {

    }

    @Then("Визуализира списък с направените {int} поръчки")
    public void checkOrderList(int expectedOrderCount) {

        if (null == myOrdersHelperModel.getOrders()) {
            MyOrdersService myOrdersServiceService = new MyOrdersService();
            myOrdersHelperModel.setOrders(myOrdersServiceService.load(myOrdersHelperModel.getPeriod(),myOrdersHelperModel.getTrackingNumber()));
        }
        assertNotNull(myOrdersHelperModel.getOrders());
        assertEquals(expectedOrderCount, myOrdersHelperModel.getOrders().size());
    }

    @And("натиска бутона за търсене")
    public void clickSearchButton() {
        MyOrdersService orderService = new MyOrdersService();
        myOrdersHelperModel.setOrders(orderService.load(myOrdersHelperModel.getPeriod(),
                                                        myOrdersHelperModel.getTrackingNumber()));

       }



    @Then("Връща съобщение: {string}")
    public void noOrdersMessage(String expectedMessage) {
        message = MyOrdersService.checkOrders(myOrdersHelperModel.getOrders());
       assertEquals(expectedMessage, message);
    }

    @When("потребителя въвежда номер на поръчкатата {string} в полето за търсене")
    public void enterTrackingNumber(String trackingNumber) {
       myOrdersHelperModel.setTrackingNumber(trackingNumber);
    }

   @When("потребителя избира период от време: {string}")
   public void selectPeriod(String period) {
       myOrdersHelperModel.setPeriod(period);
   }
}
