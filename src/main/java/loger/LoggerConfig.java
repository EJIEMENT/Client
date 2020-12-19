package loger;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class LoggerConfig {
    private String filePath;

    public Logger createInstance(String filePath) {
        PatternLayout layout = new PatternLayout();
        String conversionPattern = "%-7p %d [%t] %c %x - %m%n";
        layout.setConversionPattern(conversionPattern);

        // creates file appender
        FileAppender fileAppender = new FileAppender();
        fileAppender.setName("file");
        this.filePath = "log/" + filePath +".log";
        fileAppender.setFile(filePath);
        fileAppender.setLayout(layout);
        fileAppender.activateOptions();

        // configures the root logger
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.INFO);
        rootLogger.addAppender(fileAppender);
        Logger logger = Logger.getLogger(LoggerConfig.class);
        return logger;
    }

    public String getFilePath(){
        return filePath;
    }
}
