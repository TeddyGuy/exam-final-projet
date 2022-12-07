package org.cal.strategyexercice;

/**
 * 
 * Remanier le code ci-dessous de façon à ce qu'il utilise le 'State/Strategy Pattern'
 * Vous devrez nommer chacun des remaniements que vous faites ainsi que de faire un commit à chaque remaniement.
 *
 */
public class Personne {
    public final static String HEUREUSE = "Heureuse";
    public final static String TRISTE = "Triste";
    public final static String MALHEUREUSE = "Malheureuse";
    private final HumeurStrategy humeur;


    public Personne(String humeur) {
        switch (humeur){
            case HEUREUSE -> this.humeur = new HeureuseStrategy();
            case TRISTE -> this.humeur = new TristeStrategy();
            case MALHEUREUSE -> this.humeur = new MalheureuseStrategy();
            default -> this.humeur = new HeureuseStrategy();
        }
    }

    public HumeurStrategy getHumeur() {
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
