package livres;

public class Pays {

    private String nom_pays;
    private String code_pays;

    public Pays(String nom_pays, String code_pays) {
        setNom_pays(nom_pays);
        setCode_pays(code_pays);
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
         nom_pays.substring(0,3);
         nom_pays.toUpperCase();
         code_pays = nom_pays;
        VerifierCodePays(code_pays);
    }

    public void VerifierCodePays(String code_pays) {


        code_pays.toUpperCase();

        if (!(code_pays.length() == 3)) {
            throw new IllegalArgumentException("Code invalide (doit contenir 3 lettres)");

        }
    }
}
