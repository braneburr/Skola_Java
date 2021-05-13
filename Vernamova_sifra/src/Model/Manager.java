package Model;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    public  boolean Ulozeni(String text, File soubor) {
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(soubor.getPath()));
            bw.write(text);
            bw.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public String precist (File soubor) {
        try {
            ArrayList<String> vytah = new ArrayList<>();
            Scanner reader = new Scanner(soubor);
            while (reader.hasNextLine()) {
                vytah.add(reader.nextLine());
            }
            StringBuilder vytahdal = new StringBuilder();
            for (String zbytek : vytah) {
                vytahdal.append(zbytek);
            }
            return vytahdal.toString();
        }
        catch (FileNotFoundException e) {
            return "";

            }
        }

    }

