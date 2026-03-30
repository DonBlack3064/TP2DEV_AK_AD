package tests;

import livres.*;

import java.util.ArrayList;
import java.util.List;

public class Librairie {
    private List<Auteur> auteurs  = new ArrayList<>();
    private List<Ouvrage> ouvrages = new ArrayList<>();

    public Librairie(){
        Auteur albertine = new Auteur("Albertine", "Tremblay", "Canada");
        Auteur john = new Auteur("John", "Smith", "Etats-Unis");
        Auteur jean = new Auteur("Jean", "Némarre", "Suisse");
        auteurs.add(albertine);
        auteurs.add(john);
        auteurs.add(jean);

        ouvrages.add(new OuvrageVideo("Titre 1", john,null,13,78));
        ouvrages.add(new OuvrageVideo("Titre 2", jean,null,90,99));
        ouvrages.add(new OuvrageVideo("Titre 3", albertine,null,11,398));
        ouvrages.add(new OuvrageVideo("Titre 4", john,null,13,234));
        ouvrages.add(new OuvrageAudio("Titre 5", albertine,12,Format.NUMERIQUE));
        ouvrages.add(new OuvrageAudio("Titre 6", john,23,Format.ANALOGIQUE));
        ouvrages.add(new OuvrageAudio("Titre 7", john,67,Format.NUMERIQUE));
        ouvrages.add(new OuvragePapier("Titre 8", albertine,34));
        ouvrages.add(new OuvragePapier("Titre 9", john,45));
        ouvrages.add(new OuvragePapier("Titre 10", jean,89));
    }

    public List<Auteur> getAuteurs() {
        return auteurs;
    }

    public List<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public List<Ouvrage> trouverOuvrages(Auteur auteur) {
        //ATTENTION il faut implémenter equals dans auteur pour que ca marche!!!!!
        int count = 0;

        List<Ouvrage> trouves = new ArrayList<>();
        for (Ouvrage ouvrage : ouvrages) {
            if (ouvrage.getAuteur().equals(auteur)) {
                trouves.add(ouvrage);
            }
        }

        return trouves;
    }
}
