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
            personne.getHumeur().doYouHaveAMacbook();
        }
    }
}
