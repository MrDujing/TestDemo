package log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {
    private static final Logger logger = LogManager.getLogger(Log4jExample.class);

    public static void main(String[] args) {
        System.out.println( logger.getLevel().toString());


        logger.info("The main() method is called");

        doWork();

        logger.warn("Warning message");
        logger.error("Error message");
        logger.debug("debugmessages");
    }

    public static void doWork() {

        // doing some work

        logger.info("The doWork() method is called");
    }
}
