package dbService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderQuery {
    private static StringBuffer stringBuffer = new StringBuffer();
    public static String readQueryFromFile(String path){
        try (BufferedReader reader = new BufferedReader(new FileReader(path));){
            while (reader.ready()) {
                stringBuffer.append(reader.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuffer.toString();
    }
}
