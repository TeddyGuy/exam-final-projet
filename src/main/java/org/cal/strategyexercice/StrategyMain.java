package org.cal.strategyexercice;

import java.util.ArrayList;
import java.util.List;

public class StrategyMain {
    
    public static void main(String[] args) {

        List<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne(Personne.HEUREUSE));
        personnes.add(new Personne(Personne.MALHEUREUSE));
        personnes.add(new Personne(Personne.TRISTE));

        personnes.forEach(p -> p.printHumeur());
        
        for (Personne personne : personnes) {
            if (personne.getHumeur().equals(Personne.MALHEUREUSE)) {
                System.out.println("J'ai besoin d'un MacBook Pro pour être une personne heureuse!");
            } else if (personne.getHumeur().equals(Personne.HEUREUSE)) {
                System.out.println("J'ai un MacBook Pro, j'ai tout ce qu'il me faut  pour être une personne heureuse!");
            } else if (personne.getHumeur().equals(Personne.TRISTE)) {
                System.out.println("Je fais parti des gens qui n'auront jamais de MacBook Pro");
            }
        }
    }
}
