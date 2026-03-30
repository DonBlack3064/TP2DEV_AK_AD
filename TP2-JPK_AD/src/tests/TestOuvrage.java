package tests;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

import livres.*;

/**
 * CoursPOO 1
 *
 * @author Julien.Brunet màj Jocelyn
 * @since H25
 */
public class TestOuvrage {

    public static void main(String[] args) {
        TestOuvrage test = new TestOuvrage();
        test.testOuvrages();
        test.testTrouver();
        test.testSerie();
    }


    public void testOuvrages() {
        //Deux auteurs deja prets pour les tests...
        Auteur albertine = new Auteur("Albertine", "Tremblay", "Canada");
        Auteur john = new Auteur("John", "Smith", "Etats-Unis");

        //Voici une partie des tests! Il faut en ajouter, pour les fonctionnalités non testées!
        System.out.println("-----Test des constructeurs d'ouvrage et des diverses validations-----------");
        Ouvrage livreA = new OuvragePapier("Titre assez long", john,15);
        System.out.println(livreA);
        Ouvrage livreB = new OuvrageAudio("Ti", john,799,Format.NUMERIQUE);
        System.out.println(livreB);
        Ouvrage livreC = new OuvrageVideo(null, john,null,5);
        System.out.println(livreC);

        //bibliotheque.Auteur null et valeur par défaut de l'bibliotheque.Auteur
        Ouvrage livreA1 = new OuvragePapier("Titre assez long", john,9);
        System.out.println(livreA1);
        //bibliotheque.Auteur fonctionnel
        Ouvrage livre1 = new OuvrageVideo("Tout va bien", albertine,null,4,100);
        System.out.println(livre1);

        //Date null et valeur par défaut de la date
        livre1.setDate(null);
        System.out.println(livre1);
        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

        //Test de la validation sur le nb d'exemplaires (valide et non valide)
        Ouvrage livre2 = new OuvrageAudio("Tout va bien", albertine, 5, Format.ANALOGIQUE);
        System.out.println(livre2);

        livre2 = new OuvrageVideo("Tout va bien", albertine,null,4,19);
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new OuvrageVideo("Musique du hasard", new Auteur("Paul", "Auster", "Etats-Unis"), LocalDate.now(), 5);
        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new OuvrageVideo("Test", new Auteur("A", "B", "Etats-Unis"), LocalDate.now(), 5);

        System.out.println("\n-----Tests de la  méthode equals()-----------");
        //Deux ouvrages égaux
        Ouvrage livre5 = new OuvrageAudio("Test", new Auteur("A", "B", "Etats-Unis"), 4, Format.NUMERIQUE);
        Ouvrage livre6 = new OuvrageVideo("Test", new Auteur("A", "B", "Etats-Unis"), LocalDate.now(), 10);
        //Un qui ne l'est pas
        Ouvrage livre7 = new OuvragePapier("Test", new Auteur("Z", "B", "Etats-Unis"), 5);

        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre5));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + livre4.equals(livre6));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(livre7));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(john));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals(null));
        System.out.println("Test de la méthode equals d'bibliotheque.Ouvrage:" + !livre4.equals("Test"));
    }


    private void testTrouver() {
        Librairie bibliotheque = new Librairie();
        Auteur john = bibliotheque.getAuteurs().get(1);

        System.out.println("\n-----Test de votre méthode trouverOuvrage-----------");
        List<Ouvrage> resultat = bibliotheque.trouverOuvrages(new Auteur("Albertine", "Tremblay", "Canada"));
        System.out.println("Livres de albertine: " + resultat);

        resultat = bibliotheque.trouverOuvrages(john);
        System.out.println("Livres de john: " + resultat);

        resultat = bibliotheque.trouverOuvrages(new Auteur("Jacques", "Beaulieu", "France"));
        System.out.println("Livres de Jacques: " + resultat);
    }


    public void testSerie(){

        System.out.println("====================== Test Serie ============================");
        //Creation de la serie
        Serie serie1 = new Serie("Test");
        Auteur Test = new Auteur("jeanphilippe", "koye","Canada");
        Ouvrage Testouvrage1 = new OuvrageVideo("le livre 1 ", Test, null,4,23.9);

        //Afficher la serie vide
        System.out.println(serie1);

        // ajouter un ouvrage
        serie1.ajouterOuvrage(Testouvrage1);
        System.out.println(serie1);

        // Retirer un ouvrage de la liste
        serie1.retirerOuvrage(Testouvrage1);
        System.out.println(serie1);







    }

}

