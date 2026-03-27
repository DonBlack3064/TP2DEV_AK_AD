package livres;
import java.util.ArrayList;

public class Serie
{

    private String nom;
    private ArrayList<String> ouvrages;

    public Serie(String nom) {
        this.nom = nom;
        this.ouvrages = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterOuvrage(String ouvrage)
    {
        ouvrages.add(ouvrage);
    }

    public void afficherOuvrage()
    {
        for (String o : ouvrages){
            System.out.println(o);
        }
    }


}
