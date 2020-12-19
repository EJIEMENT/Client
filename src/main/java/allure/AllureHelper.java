package allure;

import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

public class AllureHelper {

    @Attachment(type = "text/plain", value = "{filename}", fileExtension = ".log")
    public static byte[] attachLog(final String filename) {
        try {
            return Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
