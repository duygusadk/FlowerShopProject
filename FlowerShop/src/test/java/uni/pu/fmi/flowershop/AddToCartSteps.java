package uni.pu.fmi.flowershop;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uni.pu.fmi.services.AddToCartService;

import static org.junit.Assert.assertEquals;

public class AddToCartSteps {

    private String flowerName;
    private String message;
    private FlowerCount flowerCount;

    public AddToCartSteps() {

    }
    public AddToCartSteps(FlowerCount flowerCount) {
        this.flowerCount = flowerCount;
    }



    @Given("Потребителя избира цвете {string} от списъка с наличните цветя")
    public void openFlowerDetails(String flowerName) {
        this.flowerName = flowerName;
    }

    @And("Натиска бутона Добави")
    public void submitCount() {
        final AddToCartService flowerCountService = new AddToCartService();

        String result = flowerCountService.addFlower(flowerName, flowerCount.getCount());
        message = result;
    }

    @Then("Вижда съобщение {string}")
    public void checkMessage(String expectedMessage) {assertEquals(expectedMessage, message);
    }


    @When("Потребителят не въвежда броя цветя")
    public void selectCountNull() { this.flowerCount.setCount(0);
    }

    @When("Потребителят избира {string} броя цветя")
    public void selectStringCount(String count) {
       flowerCount.setCount(null);

    }
    @When("Потребителят избира {int} броя цветя")
    public void selectCount(Integer count) {
        this.flowerCount.setCount(count);
    }
}
