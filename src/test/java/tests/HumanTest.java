package tests;

import com.jayway.restassured.response.Response;
import json.JsonParser;
import models.Address;
import models.Human;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import restClient.HumanService;


public class HumanTest {
    @Test
    public void getHumanTest() {
        HumanService humanService = new HumanService();
        Response response = humanService.getHumans();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void createHumanTest() {
        HumanService humanService = new HumanService();
        Human human = new Human("Vova", "Grub", 18, new Address("Dnipro", "Banderu", 25));
        Response response = humanService.createHuman(human);
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Test
    public void deleteHumanBySurnameTest() {
        Human human = new Human("Ivan", "Uolup", 18, new Address("Dnipro", "Banderu", 25));
        HumanService humanService = new HumanService();
        humanService.createHuman(human);
        Response response = humanService.deleteHumansBySurname("Uolup");
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
    }
    @Test
    public void deleteHumanByIdTest() {
        Human human = new Human("Ivan", "Tupak", 18, new Address("Dnipro", "Banderu", 25));
        HumanService humanService = new HumanService();
        Response responseCreate = humanService.createHuman(human);
        Human human1 = JsonParser.convertJsonToHuman(responseCreate.body().asString());
        Response response = humanService.deleteHumansById(human1.getId());
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
    }

}
