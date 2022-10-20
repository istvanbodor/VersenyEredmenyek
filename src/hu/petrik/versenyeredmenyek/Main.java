package hu.petrik.versenyeredmenyek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    //hashmap - hozzarendeli a stringhez szamok helyett a mit szeretnenk. tehat egy lista ami tud barmihez barmit rendelni.
    //Itt az olimpiai sportagakhoz rendeljuk a versenyzok eredmenyek akik abban a sportagban indultak
    private static Map<String, List<Eredmeny>> sportagEredmenyek = new HashMap<>();
    public static void main(String[] args) {

        String fajlNev = "eredmenyek.txt";
        try {
            beolvas(fajlNev);
            kiiras();
        } catch (FileNotFoundException e) {
            System.out.printf("Nem található a fájl: %s", fajlNev);
        }


    }

    private static void kiiras() {

        //csunya, de ez a kiiratas. ha tudnam szivesen elmagyaraznam xd
        for (Map.Entry<String, List<Eredmeny>> entry : sportagEredmenyek.entrySet()) {

            String sportag = entry.getKey();
            List<Eredmeny> eredmenyek = entry.getValue();
            System.out.println(sportag);
            for (Eredmeny eredmeny: eredmenyek) {
                System.out.println("\t" +eredmeny);
            }

        }


    }

    private static void beolvas(String FajlNev) throws FileNotFoundException {
            Scanner file = new Scanner(new File(FajlNev));
            while (file.hasNext()){

                String[] sor = file.nextLine().split(" ");
                String sportag = sor[0];
                String reszIdo = sor[1];
                String nev = sor[2] +" " +sor[3];
                //ha a sportag nem letezett letre kell hozni a keyt, ami egy listat rendel maga melle.
                sportagEredmenyek.putIfAbsent(sportag, new ArrayList<>());
                Eredmeny eredmeny = new Eredmeny(reszIdo, nev);
                //a keyhez tartozo listahoz adod az adott eredmenyt
                sportagEredmenyek.get(sportag).add(eredmeny);

            }
        file.close();
    }
}
