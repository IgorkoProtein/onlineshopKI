package kupchack.com.ua;

import java.io.*;

public class Serializator {

    public static void saveData(String file_path, Object obj) {
        try {
            FileOutputStream someFile = new FileOutputStream(file_path + ".ser");
            ObjectOutputStream someObject = new ObjectOutputStream(someFile);
            someObject.writeObject(obj);
            someObject.close();
            someFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object loadData(String file_path) {
        Object tempObj = null;
        try {
            FileInputStream someFile = new FileInputStream(file_path + ".ser");
            ObjectInputStream someObject = new ObjectInputStream(someFile);
            tempObj = someObject.readObject();
            someObject.close();
            someFile.close();
        } catch (FileNotFoundException e) {
           // e.printStackTrace();
        } catch (IOException e) {
           // e.printStackTrace();
        } catch (ClassNotFoundException e) {
           // e.printStackTrace();
        }
        return tempObj;
    }


}
