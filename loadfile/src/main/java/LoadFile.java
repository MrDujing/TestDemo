import demo.AcquirePath;
import write.WriteConfig;

import java.io.IOException;

public class LoadFile {
    public static void main(String[] args) throws IOException {
        AcquirePath.getPathByClass();
        System.out.println("**********************");
        AcquirePath.getPathByClassLoader();
        WriteConfig.writeByClass();
    }
}
