package hu.petrik.versenyeredmenyek;

import javax.print.attribute.IntegerSyntax;

public class Eredmeny implements  Comparable<Eredmeny>{
    private String reszIdo;
    private String nev;

    public Eredmeny(String reszIdo, String nev) {
        this.reszIdo = reszIdo;
        this.nev = nev;
    }

    public String getReszIdo() {
        return reszIdo;
    }

    public String getNev() {
        return nev;
    }


    //ez csak a file elbaszottsaga miatt van, vizsgalat a jo beolvasas erdekeben
    @Override
    public int compareTo(Eredmeny other) {
      String[] thisReszidok =  this.reszIdo.split(":");
      String[] otherReszidok =  other.reszIdo.split(":");
      Integer thisPerc = Integer.parseInt(thisReszidok[0]);
      Integer thisMasodperc = Integer.parseInt(thisReszidok[1]);
      Integer otherPerc = Integer.parseInt(otherReszidok[0]);
      Integer otherMasodperc = Integer.parseInt(otherReszidok[1]);

      if (thisPerc.compareTo(otherPerc) ==0) {
          return thisMasodperc.compareTo(otherMasodperc);
      }

        return thisPerc.compareTo(otherPerc);
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.nev, this.reszIdo);
    }
}
