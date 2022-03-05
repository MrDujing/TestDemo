package logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackDemo {
    private static final Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

    public static void main(String[] args) {

        logger.debug("Hello from Logback");

        logger.debug("getNumber() : {}", getNumber());

        logger.error("this is error");
    }

    static int getNumber() {
        return 5;
    }
}
