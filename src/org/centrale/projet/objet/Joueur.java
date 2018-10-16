/*
 * * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 *
 */
package org.centrale.projet.objet;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author EsauBZ Classe qui represente un joeur dans le monde WoE tu peux
 * choisir un classe et un nom pour ton personnage
 */
public class Joueur {

    /**
     * Nom de Joeur *
     */
    private String nom;
    /**
     * Classe du Joeur*
     */
    private String classeJ;
    /**
     * Personnage*
     */
    private Personnage perso;

    /**
     * Constructeur de la classe Joeur sans parametres(pas necessaires) on
     * demande le nom et la classe avec un entree du clavier et les autres
     * parametres du joeur sont random (ca depende de la classe)
     */
    public Joueur() {
        demandeNomJoeur();
        demandeClasse();
        constructorJoeur();
    }

    /**
     * Methode qui demande le nom du joeur avec un entree du clavier ce methode
     * private car il est appelle seulement dans le constructeur de la classe
     */
    private void demandeNomJoeur() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel sera le nom de votre personnage?");
        System.out.println("Nom: ");
        this.nom = sc.next();
    }

    /**
     * Methode qui demande la classe du joeur avec un entree du clavier ce
     * methode est private car il est appelle seulement dans le constructeur de
     * la classe
     */
    private void demandeClasse() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel sera la classe de votre personnage?");
        System.out.println("vous pouvez choisir entre: ");
        System.out.println("Guerrier/Paysan/Mage/Archer");
        System.out.println("Classe: ");
        this.classeJ = sc.next();
    }

    /**
     * Methode qui appelle a le constructeur de la classe qui a ete choisi ici
     * on utilise le nom que le utilisateur a ecrit et les autres parametres
     * sont random. on utilise un switch car le parametres sont differentes pour
     * chaque classe de personnage different c'est un methode private car il est
     * appelle seulement dans le constructeur de la classe
     */
    private void constructorJoeur() {
        Random gA = new Random();
        Point2D p = new Point2D(gA.nextInt(50), gA.nextInt(50));
        switch (classeJ) {
            case "Guerrier":
                this.perso = new Guerrier(nom, gA.nextInt(100), gA.nextInt(100), gA.nextInt(100)/*attack*/, gA.nextInt(90)/*Par*/, gA.nextInt(30)/*magie*/, gA.nextInt(50), gA.nextInt(100), gA.nextInt(30), gA.nextInt(20), p, gA.nextInt(100));
                break;
            case "Paysan":
                this.perso = new Paysan(nom, gA.nextInt(100), gA.nextInt(100), gA.nextInt(50)/*attack*/, gA.nextInt(100)/*Par*/, gA.nextInt(70)/*magie*/, gA.nextInt(70), gA.nextInt(70), gA.nextInt(90), gA.nextInt(20), p, gA.nextInt(100));
                break;
            case "Archer":
                this.perso = new Archer(nom, gA.nextInt(100), gA.nextInt(100), gA.nextInt(100)/*attack*/, gA.nextInt(100)/*Par*/, gA.nextInt(30)/*magie*/, gA.nextInt(60), gA.nextInt(100), gA.nextInt(30), gA.nextInt(40), p, gA.nextInt(100), gA.nextInt(100));
                break;
            case "Mage":
                this.perso = new Mage(nom, gA.nextInt(100), gA.nextInt(100), gA.nextInt(80)/*attack*/, gA.nextInt(100)/*Par*/, gA.nextInt(100)/*magie*/, gA.nextInt(100), gA.nextInt(70), gA.nextInt(100), gA.nextInt(50), p, gA.nextInt(100));
                break;
            default:
                System.out.println("La clase: " + classeJ + " n'existe pas");
                this.demandeClasse();
                this.constructorJoeur();
                break;
        }
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return
     */
    public String getClasseJ() {
        return classeJ;
    }

    /**
     *
     * @return
     */
    public Personnage getPerso() {
        return perso;
    }

    /**
     *
     * @param nom Le nom du personnage
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param classeJ quelle type de classe le jouer a choisi
     */
    public void setClasseJ(String classeJ) {
        this.classeJ = classeJ;
    }

    /**
     *
     * @param perso personnage
     */
    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

}
