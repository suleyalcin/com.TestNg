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
            FileInputStream fis = new FileInputStream(dosyaYolu);//throws da denilebilir ancak her kullanmak
            // istedigimizde throws yazmaliyiz.Bu yuzden her seferinde throws ile ugrasmamak icin try caytch yapariz
            //fis dosyaYolunu tanimladigimiz configuration.properties dosyasini okudu
            properties = new Properties();
            properties.load(fis);//fis'in okudugu bilgileri properties'e yukledi

        } catch (IOException e) {//IO exeption hepsini karsiladigi icin FileInputExeption'i sildik
            e.printStackTrace();
        }


    }

    public static String getProperty(String key) {
    /*
    Test methodundan yoladigimiz String key degerinin alip
    Properties class'indan getProperty() methodunu kullanarak bu key'e ait value'u bize getirdi

    */
        return properties.getProperty(key);
    }

}
