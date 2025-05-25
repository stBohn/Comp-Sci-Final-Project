import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadGame {
    public static String loadFromFile(String path) {
        StringBuilder data = new StringBuilder();
        try {
            File file = new File(path);
            if (!file.exists()){
                return null;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.toString();
    }
}
