package livres;

public class OuvragePapier extends Ouvrage {

    private int nombrePages;

    public OuvragePapier(String titre, Auteur auteur, int nombrePages) {
        super(titre, auteur);
        this.nombrePages = nombrePages;
    }

    public int getNombrePages() {
        return nombrePages;
    }

}
