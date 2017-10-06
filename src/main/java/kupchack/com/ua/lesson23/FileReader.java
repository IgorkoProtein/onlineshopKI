package kupchack.com.ua.lesson23;

import javafx.scene.shape.Path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader implements IRead {
    public String readInformatoin() {
        String path = "C:/sometext.txt";
        String text = " ";
        try {
            text = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return text;
    }
}
