
package restClient;


import loger.LoggerConfig;
import org.apache.log4j.*;

public class RestClient {

    public static Logger logger = Logger.getLogger(RestClient.class);

    public static void main(String[] args) {
        LoggerConfig loggerConfig = new LoggerConfig();
        Logger logger = loggerConfig.createInstance("test");
        logger.debug("this is a debug log message");
        logger.info("this is a information log message");
        logger.warn("this is a warning log message");

    }
}
