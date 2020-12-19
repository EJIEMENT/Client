package restClient;

import com.jayway.restassured.response.Response;
import json.JsonParser;
import models.Human;

public class HumanService {
    private BaseClient baseClient = new BaseClient();

    public Response getHumans() {
        return baseClient.get("/getHumans");
    }

    public Response createHuman(Human human) {
        return baseClient.create("/createHuman",human);
    }

    public Response deleteHumansBySurname(String surname) {
        return baseClient.delete("/deleteHuman","surname",surname);
    }

    public Response deleteHumansById(Integer id) {
        return baseClient.delete("/deleteHumanById","id",String.valueOf(id));
    }
}
