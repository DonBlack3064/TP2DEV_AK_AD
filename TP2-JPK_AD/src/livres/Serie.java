package livres;

import java.util.ArrayList;

public class Serie {

    private String nom;
    private ArrayList<String> Serie;

    public Serie(String nom) {
        this.nom = nom;
        this.Serie = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterOuvrage(Ouvrage ouvrage) {
        Serie.add(String.valueOf(ouvrage));
    }

    public void retirerOuvrage(Ouvrage ouvrage) {
        Serie.remove(String.valueOf(ouvrage));
    }


    @Override
    public String toString() {
        return "Serie{" +
                "nom='" + nom + '\'' +
                ", ouvrages=" + Serie +
                '}';
    }
}
