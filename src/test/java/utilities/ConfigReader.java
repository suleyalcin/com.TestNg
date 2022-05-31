package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties properties;

    static {//static blog herseyden once calisir properties objesine atamayi yapacak
        String dosyaYolu = "configuration.properties";
        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);
            //fis dosyaYolunu tanimladigimiz configuration.properties dosyasini okudu
            properties = new Properties();
            properties.load(fis);//fis'in okudugu bilgileri properties'e yukledi

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String getProperty(String key) {
    /*
    Test methodundan yoladigimiz String key degerinin alip
    Properties class'indan getProperty()methodunu kullanarak bu key'e ait value bize getirdi

    */
        return properties.getProperty(key);
    }

}
