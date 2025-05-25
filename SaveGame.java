import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class SaveGame {
    public static void saveToFile(String path, String data) {
        try {
            File file = new File(path);
            FileWriter writer = new FileWriter(file);
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}