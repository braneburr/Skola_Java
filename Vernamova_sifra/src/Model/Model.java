package Model;
import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;


public class Model {
    private File file;
    public Manager m;
    private File keyFile;

    public Model() {
        m = new Manager();
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getKeyFile() {
        return keyFile;
    }

    public void setKeyFile(File keyFile) {
        this.keyFile = keyFile;
    }

    public String VygenerovatKlic() {

       try {
           Scanner reader = new Scanner(getFile());
           String data = reader.next();
           StringBuilder klic = new StringBuilder();
               for (int i = 0; i < data.length(); i++){
                   klic.append(Random(6, 10).toString());
              }
               return klic.toString();
       }
       catch (FileNotFoundException e) {
           return "";
       }
    }

    public String Sifra() {
        String precteni_souboru = m.precist(file);
        String precteni_klice = m.precist(keyFile);
        Integer[] posun = new Integer[precteni_klice.length()];
        for (int i = 0; i < precteni_klice.length(); i++) {
            posun[i] = Integer.valueOf(String.valueOf(precteni_klice.charAt(i)));
        }
        StringBuilder sifrovanyklic = new StringBuilder();
        for (int i = 0; i < precteni_souboru.length(); i++) {
            sifrovanyklic.append((char) (precteni_souboru.charAt(i) + posun[i]));
         }
         return sifrovanyklic.toString();
        }


    public Integer Random(int min, int max) {
        Random nahodnyposun = new Random();
        return nahodnyposun.nextInt(max - min) + min;
    }

}
