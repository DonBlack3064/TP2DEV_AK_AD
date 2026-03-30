package livres;

public class OuvrageAudio extends Ouvrage {

    private int dureeMinutes;
    private Format format;

    public OuvrageAudio(String titre, Auteur auteur, int dureeMinutes, Format format) {
        super(titre, auteur);
        this.dureeMinutes = dureeMinutes;
        this.format = format;
    }

}
