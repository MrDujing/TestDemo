package write;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteConfig {
    public static void writeByClass() throws IOException {
        String path = WriteConfig.class.getResource("../db/db.properties").getPath();
        Properties props = new Properties();
        props.load(new FileReader(path));
        OutputStream fos = new FileOutputStream(path);
        props.setProperty("write","true");
        props.store(fos,"update write");
    }
}
