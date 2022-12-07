package org.cal.strategyexercice;

/**
 * 
 * Remanier le code ci-dessous de façon à ce qu'il utilise le 'State/Strategy Pattern'
 * Vous devrez nommer chacun des remaniements que vous faites ainsi que de faire un commit à chaque remaniement.
 *
 */
public class Personne {
    public static String HEUREUSE = "Heureuse";
    public static String TRISTE = "Triste";
    public static String MALHEUREUSE = "Malheureuse";
    private final String humeur;
    public Personne(String humeur) {
        this.humeur = humeur;
    }

    public String getHumeur() {
        return humeur;
    }
    @Override
    public String toString() {
        return "Personne [humeur=" + humeur + "]";
    }

    public void printHumeur() {
        System.out.println(humeur);
    }

}
