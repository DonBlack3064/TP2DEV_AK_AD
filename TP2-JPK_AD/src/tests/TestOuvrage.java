package tests;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

import livres.Ouvrage;
import livres.Auteur;
import livres.Pays;
import livres.Serie;

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
        test.testPaysEtAuteur();
    }


    public void testOuvrages() {
        //Deux auteurs deja prets pour les tests...
        Auteur albertine = new Auteur("Albertine", "Tremblay", "Canada");
        Auteur john = new Auteur("John", "Smith", "Etats-Unis");

        //Voici une partie des tests! Il faut en ajouter, pour les fonctionnalités non testées!
        System.out.println("-----Test des constructeurs d'ouvrage et des diverses validations-----------");
        Ouvrage livreA = new Ouvrage("Titre assez long", john);
        System.out.println(livreA);
        Ouvrage livreB = new Ouvrage("Ti", john);
        System.out.println(livreB);
        Ouvrage livreC = new Ouvrage(null, john);
        System.out.println(livreC);

        //bibliotheque.Auteur null et valeur par défaut de l'bibliotheque.Auteur
        Ouvrage livreA1 = new Ouvrage("Titre assez long", null);
        System.out.println(livreA1);
        //bibliotheque.Auteur fonctionnel
        Ouvrage livre1 = new Ouvrage("Tout va bien", albertine);
        System.out.println(livre1);

        //Date null et valeur par défaut de la date
        livre1.setDate(null);
        System.out.println(livre1);
        livre1.setDate(LocalDate.now().minusYears(5));
        System.out.println(livre1);

        //Test de la validation sur le nb d'exemplaires (valide et non valide)
        Ouvrage livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.AUDIO, LocalDate.now(), -10);
        System.out.println(livre2);

        livre2 = new Ouvrage("Tout va bien", albertine, Ouvrage.Format.PAPIER, LocalDate.now(), 20);
        System.out.println(livre2);

        System.out.println("\n-----Tests des méthodes acheter et vendre-----------");

        Ouvrage livre3 = new Ouvrage("Musique du hasard", new Auteur("Paul", "Auster", "Etats-Unis"), Ouvrage.Format.PAPIER, LocalDate.now(), 5);
        System.out.println(livre3);

        livre3.acheter(5);
        System.out.println(livre3);

        System.out.println("On peut vendre 8 livres? " + livre3.vendre(8));
        System.out.println(livre3);

        System.out.println("On peut vendre 10 livres? " + livre3.vendre(10));
        System.out.println(livre3);

        Ouvrage livre4 = new Ouvrage("Test", new Auteur("A", "B", "Etats-Unis"), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

        System.out.println("\n-----Tests de la  méthode equals()-----------");
        //Deux ouvrages égaux
        Ouvrage livre5 = new Ouvrage("Test", new Auteur("A", "B", "Etats-Unis"), Ouvrage.Format.PAPIER, null, 5);
        Ouvrage livre6 = new Ouvrage("Test", new Auteur("A", "B", "Etats-Unis"), Ouvrage.Format.PAPIER, LocalDate.now(), 10);
        //Un qui ne l'est pas
        Ouvrage livre7 = new Ouvrage("Test", new Auteur("Z", "B", "Etats-Unis"), Ouvrage.Format.PAPIER, LocalDate.now(), 5);

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
        Ouvrage Testouvrage1 = new Ouvrage("le livre 1 ", Test);

        //Afficher la serie vide
        System.out.println(serie1);

        // ajouter un ouvrage
        serie1.ajouterOuvrage(Testouvrage1);
        System.out.println(serie1);

        // Retirer un ouvrage de la liste
        serie1.retirerOuvrage(Testouvrage1);
        System.out.println(serie1);







    }

    private void testPaysEtAuteur() {

        System.out.println("====================== Test PAYS et AUTEUR ===================");

        // 1. Test pays valide
        try {
            Pays p1 = new Pays();

            p1.setNom_pays("Canada");
            p1.setCode_pays("CAN");

            System.out.println("Pays valide créé : " + p1.getNom_pays());
        } catch (Exception e) {
            System.out.println("Erreur (pays valide) : " + e.getMessage());
        }

        // 2. Test pays invalide
        try {
            Pays p2 = new Pays();

            p2.setNom_pays("France");
            p2.setCode_pays("FR"); // invalide

            System.out.println("ERREUR : un code invalide a été accepté");
        } catch (IllegalArgumentException e) {
            System.out.println("OK - Exception pour code invalide : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Autre erreur : " + e.getMessage());
        }

        // 3. Lier avec un auteur
        try {
            Pays p3 = new Pays();

            p3.setNom_pays("Japon");
            p3.setCode_pays("JPN");

            Auteur auteur = new Auteur("Haruki", "Murakami", p3.getNom_pays());

            System.out.println("Auteur avec pays : " + auteur);
        } catch (Exception e) {
            System.out.println("Erreur liaison auteur : " + e.getMessage());
        }
    }
}

