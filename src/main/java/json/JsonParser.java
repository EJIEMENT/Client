package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Human;

public class JsonParser {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static Human convertJsonToHuman(String json){
        try {
            return objectMapper.readValue(json, Human.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new Human();
    }
    public static String convertHumanToJson(Human human){
        try {
            return objectMapper.writeValueAsString(human);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

}
