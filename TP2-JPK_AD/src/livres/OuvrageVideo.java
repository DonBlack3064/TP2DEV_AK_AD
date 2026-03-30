package livres;

import java.time.LocalDate;

public class OuvrageVideo extends Ouvrage {

    private double tailleMb = 0;

    public OuvrageVideo(String titre, Auteur auteur, LocalDate date, int nombreExemplaires) {
        super(titre, auteur, date, nombreExemplaires);
    }

    public OuvrageVideo (String titre, Auteur auteur, LocalDate date, int nombreExemplaires, double tailleMb){
        super();
        this.tailleMb = tailleMb;

    }


    public double getTailleMb() {
        return tailleMb;
    }

    public void setTailleMb(double tailleMb) {
        this.tailleMb = tailleMb;
    }
}
