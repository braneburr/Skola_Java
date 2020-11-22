package com.homework;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        Zamestnanec zamestnanec = new Zamestnanec("Jan", "Strach", Pracovni_zarazeni.inzenyr);
        Scanner scan = new Scanner(System.in);

        NacteniDochazky(zamestnanec);
        vypisInfo(zamestnanec);

        while (true) {
            System.out.print("\nVase volba: ");

            String volbaStr = scan.next();

            int volba;

            try {
                volba = Integer.parseInt(volbaStr);
            } catch (NumberFormatException nfe) {
                volba = 4;
            }

            switch (volba) {
                case 0 -> {
                    UlozeniDochazky(zamestnanec);
                    System.exit(0);
                }
                case 1 -> {
                    vypisInfo(zamestnanec);
                    if (zamestnanec.getDochazka().isEmpty() || zamestnanec.getDochazka().get(zamestnanec.getDochazka().size() - 1).getOdchod() != null)
                        zamestnanec.prichodDoPrace(getCurrentTimeStamp());
                }
                case 2 -> {
                    vypisInfo(zamestnanec);
                    if (!zamestnanec.getDochazka().isEmpty() && zamestnanec.getDochazka().get(zamestnanec.getDochazka().size() - 1).getOdchod() == null) {
                        zamestnanec.odchodZPrace(getCurrentTimeStamp());
                    }
                }
                case 3 -> {
                    vypisInfo(zamestnanec);
                    vypisDochazku(zamestnanec);
                }
                default -> vypisInfo(zamestnanec);
            }
        }
    }

    public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static void vypisDochazku(Zamestnanec zamestnanec) {
        System.out.println("\n\nDochazka zamestnance - " + zamestnanec.getJmeno() + " " + zamestnanec.getPrijmeni() + ":");
        System.out.println(zamestnanec.getDochazkaStr());
    }

    public static void vypisInfo(Zamestnanec zamestnanec) {
        System.out.println("\n\n\n/********************************/");
        System.out.println("Jmeno zamestance: " + zamestnanec.getJmeno() + " " + zamestnanec.getPrijmeni());
        System.out.println("Pracovni zarazeni: " + zamestnanec.getPracovni_zarazeni());
        System.out.println("/********************************/");

        System.out.println("1) Zadejte prichod");
        System.out.println("2) Zadejte odchod");
        System.out.println("3) Vypis dochazku");
        System.out.println("0) Ukonci program");
    }

    public static void UlozeniDochazky(Zamestnanec zamestnanec) {
        try {
            BufferedWriter save = new BufferedWriter(new FileWriter("dochazka-" + zamestnanec.getJmeno() + "_" + zamestnanec.getPrijmeni() + ".txt", false));

            save.write(zamestnanec.getDochazkaStr());

            save.close();
        } catch (IOException ex) {
            System.out.println("Doslo k chybe pri ukladani dochazky.");
        }
    }

    public static void NacteniDochazky(Zamestnanec zamestnanec) {
        File dochazka = new File("dochazka-" + zamestnanec.getJmeno() + "_" + zamestnanec.getPrijmeni() + ".txt");

        if (dochazka.exists()) {
            try {
                Scanner myReader = new Scanner(dochazka);

                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();

                    if (data.contains("Prichod: ")) {
                        zamestnanec.prichodDoPrace(data.split("Prichod: ")[1]);
                    } else if (data.contains("Odchod: ")) {
                        zamestnanec.odchodZPrace(data.split("Odchod: ")[1]);
                    }
                }

                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("Nelze nacist dochazku.");
            }
        }
    }

}
