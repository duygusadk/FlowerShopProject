package uni.pu.fmi.services;

import uni.pu.fmi.models.Flower;
import uni.pu.fmi.db.MainRepo;


public class AddToCartService {


    public String addFlower(String flowerName, Integer count) {
        Flower flower = MainRepo.findFlowerByName(flowerName);
        if (flower == null) {
            return "Цветето не е намерено";
        }

        String validationMessage = validate(count, flower.getQuantity());
        if (validationMessage != null) {
            return validationMessage;
        }


        flower.setQuantity(flower.getQuantity() - count);
        return generateMessage(flowerName,count);
    }


    private String generateMessage(String flowerName, Integer count)
    {
        StringBuilder message = new StringBuilder("Успешно добавихте продуктите в количката");

        return message.toString();
    }

    private static String validate(Integer count,int flowerCount)
    {

        if (count == null){
            return "Броят не може да съдържа букви или специални знаци";
        }
        if (count==0)
        {
            return "Моля изберете броя";
        }
        if(count>flowerCount){
            return "Количеството,което искате не е налично,налични са по-малко броя";
        }

        try
        {
            if (count < 1 || count > 30)
            {
                return "Броят трябва да е между 1 и 30";
            }
        }
        catch (NumberFormatException e)
        {
            return "Броят не може да съдържа букви или специални знаци";
        }

        return null;
    }
}
