/*
 * * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 *
 */
package org.centrale.projet.objet;

import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

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
     * @param nom*
     * @param classe********************************/
    public Joueur(String nom, String classe) {
        this.nom = nom;
        this.classeJ = classe;
        constructorJoeur();
    }
    /*************************************/
    /**
     * Constrcuteur de la classe Joueur qui creer un joueur avec les informations 
     * fournies dans un fichier texte
     * 
     * @param ligne qui contient la ligne avec les informations pour l'initialisation d'un joueur
     */
    
    public Joueur(String ligne){
        String delimiteurs = " ,.;";
        StringTokenizer tokenizer = new StringTokenizer(ligne, delimiteurs); 
        String nomP = null; 
        int pV = 0, ptM = 0, pA = 0, pP = 0, pM = 0, rM = 0, dA = 0, dM = 0, distMax = 0, ptP = 0, coordX = 0, coordY = 0, nbF = 0;
        Point2D p = null;
        String type = "0";
        if (tokenizer.hasMoreTokens()){
            type = tokenizer.nextToken();
            type = tokenizer.nextToken();
            nomP = tokenizer.nextToken();
                
            try {
                pV = Integer.parseInt(tokenizer.nextToken());
                ptM = Integer.parseInt(tokenizer.nextToken());
                pA = Integer.parseInt(tokenizer.nextToken());
                pP = Integer.parseInt(tokenizer.nextToken());
                pM = Integer.parseInt(tokenizer.nextToken());
                rM = Integer.parseInt(tokenizer.nextToken());
                dA = Integer.parseInt(tokenizer.nextToken());
                dM = Integer.parseInt(tokenizer.nextToken());
                distMax = Integer.parseInt(tokenizer.nextToken());
                ptP = Integer.parseInt(tokenizer.nextToken());
                coordX = Integer.parseInt(tokenizer.nextToken());
                coordY = Integer.parseInt(tokenizer.nextToken());
                p = new Point2D(coordX, coordY);
                if (tokenizer.hasMoreTokens()){
                    nbF = Integer.parseInt(tokenizer.nextToken()); //Au cas il s'agit d'un Archer - récuperer son nombre de Fleches 
                }
                
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());  
            }   
        }
        //Appel au constructeur en fonction du type de classe du Joueur humain
        switch (type){
            case "Guerrier":
                this.perso = new Guerrier(nomP, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, ptP);
                this.nom = nomP;
                this.classeJ = "Guerrier";
                break;
            case "Mage":
                this.perso = new Mage(nomP, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, ptP);
                this.nom = nomP;
                this.classeJ = "Mage";
                break;
            case "Paysan":
                this.perso = new Paysan(nomP, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, ptP);
                this.nom = nomP;
                this.classeJ = "Paysan";
                break;
            case "Archer":
                this.perso = new Archer(nomP, pV, ptM, pA, pP, pM, rM, dA, dM, distMax, p, nbF, ptP);
                this.nom = nomP;
                this.classeJ = "Archer";
                break;
            default:
                System.out.println("La classe: " + type + " n'existe pas");
                System.out.println("Format du fichier invalide");
                break;
        }
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
        Point2D p = new Point2D(gA.nextInt(20), gA.nextInt(20));
        switch (classeJ) {
            case "Guerrier":
                this.perso = new Guerrier(nom, gA.nextInt(100), gA.nextInt(30), gA.nextInt(100)/*attack*/, gA.nextInt(80)/*Par*/, gA.nextInt(30)/*magie*/, gA.nextInt(50), gA.nextInt(70), gA.nextInt(30), gA.nextInt(5)+1, p, gA.nextInt(80));
                break;
            case "Paysan":
                this.perso = new Paysan(nom, gA.nextInt(100), gA.nextInt(100), gA.nextInt(50)/*attack*/, gA.nextInt(100)/*Par*/, gA.nextInt(70)/*magie*/, gA.nextInt(70), gA.nextInt(50), gA.nextInt(90), gA.nextInt(5)+1, p, gA.nextInt(90));
                break;
            case "Archer":
                this.perso = new Archer(nom, gA.nextInt(100), gA.nextInt(50), gA.nextInt(80)/*attack*/, gA.nextInt(50)/*Par*/, gA.nextInt(30)/*magie*/, gA.nextInt(60), gA.nextInt(70), gA.nextInt(30), gA.nextInt(10)+1, p, gA.nextInt(100), gA.nextInt(60));
                break;
            case "Mage":
                this.perso = new Mage(nom, gA.nextInt(100), gA.nextInt(100), gA.nextInt(80)/*attack*/, gA.nextInt(50)/*Par*/, gA.nextInt(100)/*magie*/, gA.nextInt(100), gA.nextInt(70), gA.nextInt(80), gA.nextInt(12)+1, p, gA.nextInt(60));
                break;
            default:
                System.out.println("La classe: " + classeJ + " n'existe pas");
                this.demandeClasse();
                this.constructorJoeur();
                break;
        }
    }

    /**
     *
     * @return renvoie le nom du personnage
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return renvoie le nom de la classe du personnage
     */
    public String getClasseJ() {
        return classeJ;
    }

    /**
     *
     * @return renvoie un instence de personnage
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
    
    public String makeStringInfo(){
        String info = "";
        info = info + this.nom + "\n";
        info = info + this.classeJ + "\n";
        info = info + this.perso.makeStringInfo();
        return info;
    }

}
