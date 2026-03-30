package livres;

public class Pays {

    private String nom_pays;
    private String code_pays;

    public Pays() {

    }


    public String getNom_pays() {
        return nom_pays;
    }

    public void setNom_pays(String nom_pays) {
        this.nom_pays = nom_pays;
    }

    public String getCode_pays() {
        return code_pays;
    }

    public void setCode_pays(String code_pays) {
        if (code_pays == null || code_pays.length() != 3) {
            throw new IllegalArgumentException("Code invalide (doit contenir 3 lettres)");
        }
        this.code_pays = code_pays.toUpperCase();
    }
 }
