/**
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 *
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EsauBZ
 *
 * Super class Personnage qui contient les méthodes communes pour les subs class
 * Archer, Paysan Guerrier, Mage
 */
public class Personnage extends Creature {

    private String nom;
    private int ptMana;
    private int pourcentageMag;
    private int pourcentageResistMag;
    private int degMag;
    private int distAttMax;
    private ArrayList<Nourriture> nourriture;

    /**
     * Constructeur avec parametres de la super class Personnage
     *
     * @param Nom Le nom du personnage
     * @param ptV Les points de vie du personnage
     * @param ptM Les points mana du personnage
     * @param pA Le pourcentage d'Attack du personnage
     * @param pP Le pourcentage de par du personnage
     * @param pM Le pourcentage de Magie du personnage
     * @param rM Les points de resistance magic du personnage
     * @param dA Les points de damage attack
     * @param dM Les points de damage magic
     * @param distMax Distance max d'attack
     * @param pos variable (point) qui represent la position du personnage
     */
    Personnage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptP) {
        super(ptV, pA, pP, dA, pos, ptP);
        this.nom = nom;
        ptMana = ptM;
        pourcentageMag = pM;
        pourcentageResistMag = rM;
        degMag = dM;
        distAttMax = distMax;
        nourriture = new ArrayList<>();
    }

    /**
     * Constructeur avec un parametre de la super class Personnage ce
     * constructeur prends un objet Personnage et fait une copie de l'objet
     *
     * @param perso (class personnage)
     */
    Personnage(Personnage perso) {
        super(perso.getPtVie(), perso.getPourcentageAtt(), perso.getPourcentagePar(), perso.getDegAtt(), perso.getPos(), perso.getPtPar());
        this.nom = perso.getNom();
        ptMana = perso.getPtMana();
        pourcentageMag = perso.getPourcentageMag();
        pourcentageResistMag = perso.getPourcentageResistMag();
        degMag = perso.getDegMag();
        distAttMax = perso.getDistAttMax();
        nourriture = new ArrayList<>();
    }

    /**
     * Constructeur sans parametres de la class personnage il est utilise par
     * defaut et initialise tous le parametres en zero
     *
     */
    Personnage() {
        super();
        this.nom = "";
        ptMana = 0;
        pourcentageMag = 0;
        pourcentageResistMag = 0;
        degMag = 0;
        distAttMax = 0;
        nourriture = new ArrayList<>();
    }

    /**
     * methode setNom pour changer le nom du personnage
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * methode setPtMana pour etablir les points mana
     *
     * @param ptMana
     */
    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }

    /**
     * methode setPourcentageMag pour etablir le pourcentage de magie
     *
     * @param pourcentageMag
     */
    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    /**
     *
     * @param pourcentageResistMag
     */
    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
    }

    /**
     *
     * @param degMag
     */
    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    /**
     *
     * @param distAttMax la distance max d'attaque
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
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
    public int getPtMana() {
        return ptMana;
    }

    /**
     *
     * @return
     */
    public int getPourcentageMag() {
        return pourcentageMag;
    }

    /**
     *
     * @return
     */
    public int getPourcentageResistMag() {
        return pourcentageResistMag;
    }

    /**
     *
     * @return
     */
    public int getDegMag() {
        return degMag;
    }

    /**
     *
     * @return distance max de l'attaque du personnage
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     *
     * @return distance max de l'attaque du personnage
     */
    public ArrayList<Nourriture> getNourriture() {
        return nourriture;
    }

    /**
     * methode affiche: cet methode affiche toute l'information du personnage
     * touts les parametres initiaux sont affiches dans l'ecran avec un petit
     * description.
     *
     */
    @Override
    public void affiche() {

        System.out.println("");
        System.out.println("**************************************");
        System.out.println("Joeur: " + nom);
        System.out.println("Point de Vie: " + this.getPtVie());
        System.out.println("Point de Mana: " + ptMana);
        System.out.println("Pourcentage d'attaque: " + this.getPourcentageAtt());
        System.out.println("Pourcentage de Par: " + this.getPourcentagePar());
        System.out.println("Pourcentage de Magie: " + pourcentageMag);
        System.out.println("Resistence au Magie: " + pourcentageResistMag);
        System.out.println("Damage Attaque: " + this.getDegAtt());
        System.out.println("Damage Magie: " + degMag);
        System.out.println("Distance d'ataque: " + distAttMax);
        this.getPos().affiche();
    }

    /**
     * Methode deplace: cet methode donne la possibilite de changer la position
     * d'un joeur dans 8 directions differents, le joeur peut choisir quelle
     * direction.
     *
     */
    @Override
    public void deplacer() {
        int dir = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Dans quelle direction voulez-vous vous déplacer(numero)?");
        System.out.println("1)haut 2)bas 3)gauche 4)droite Coins: 5)sup. droit 6)sup. gauche 7)inf. droite 8)inf. gauche");
        try {
            dir = Integer.parseInt(sc.next());
        } catch (NumberFormatException e) {
            System.out.println("Vous avez choisi un direction invalide");
            throw e;
        }
        switch (dir) {
            case 1:
                this.getPos().translate(0, 2);
                break;
            case 2:
                this.getPos().translate(0, -2);
                break;
            case 3:
                this.getPos().translate(-2, 0);
                break;
            case 4:
                this.getPos().translate(2, 0);
                break;
            case 5:
                this.getPos().translate(-2, 2);
                break;
            case 6:
                this.getPos().translate(2, -2);
                break;
            case 7:
                this.getPos().translate(-2, -2);
                break;
            case 8:
                this.getPos().translate(2, 2);
                break;
        }
    }

    public void combattre(Creature c) {

    }

    /**
     * Methode MettreAJourDuree: cet methode met à jour la duree de l'effet
     * qu'une nourriture cause à un personnage
     *
     *
     *
     */
    public void MettreAJourDuree() {
        for (int x = 0; x < nourriture.size(); x++) {
            nourriture.get(x).setDuree(nourriture.get(x).getDuree() - 1);
            if (nourriture.get(x).getDuree() == 0) {
                nourriture.get(x).setValeur(nourriture.get(x).getValeur() * (-1));
                this.MettreAJourCaract(nourriture.get(x));
                nourriture.remove(x);
                x--;
            }
        }
    }

    /**
     * Methode MettreAJourCaract: cet methode met est appelé au moment qu'un
     * personnage prendre une nourriture et elle a comme fonction actualiser la
     * valeur d'un de ces parametres
     *
     *
     * @param r qui represente une nourriture pris par un personnage
     */
    public void MettreAJourCaract(Nourriture r) {
        //si c'est un Bonus on fait une addition
        if ("Bonus".equals(r.getType())) {
            String carac = r.getCaract();
            switch (carac) {
                case "pA":
                    this.setPourcentageAtt(this.getPourcentageAtt() + r.getValeur());
                    break;

                case "pP":
                    this.setPourcentagePar(this.getPourcentagePar() + r.getValeur());
                    break;

                case "pM":
                    this.setPourcentageMag(this.getPourcentageMag() + r.getValeur());
                    break;

                case "rM":
                    this.setPourcentageResistMag(this.getPourcentageResistMag() + r.getValeur());
                    break;

                case "dA":
                    this.setDegAtt(this.getDegAtt() + r.getValeur());
                    break;

                case "dM":
                    this.setDegMag(this.getDegMag() + r.getValeur());
                    break;

                case "distMax":
                    this.setDistAttMax(this.getDistAttMax() + r.getValeur());
                    break;
            }
        }
        //Si c'est un malus on fait une soustraction
        if ("Malus".equals(r.getType())) {
            String carac = r.getCaract();
            switch (carac) {
                case "pA":
                    this.setPourcentageAtt(this.getPourcentageAtt() - r.getValeur());
                    break;

                case "pP":
                    this.setPourcentagePar(this.getPourcentagePar() - r.getValeur());
                    break;

                case "pM":
                    this.setPourcentageMag(this.getPourcentageMag() - r.getValeur());
                    break;

                case "rM":
                    this.setPourcentageResistMag(this.getPourcentageResistMag() - r.getValeur());
                    break;

                case "dA":
                    this.setDegAtt(this.getDegAtt() - r.getValeur());
                    break;

                case "dM":
                    this.setDegMag(this.getDegMag() - r.getValeur());
                    break;

                case "distMax":
                    this.setDistAttMax(this.getDistAttMax() - r.getValeur());
                    break;
            }
        }
    }

    public String makeStringInfo() {
        String info = "";

        info = info + "Point de Vie: " + this.getPtVie() + "\n";
        info = info + "Point de Mana: " + this.ptMana + "\n";
        info = info + "Pourcentage d'attaque: " + this.getPourcentageAtt() + "\n";
        info = info + "Pourcentage de Par: " + this.getPourcentagePar() + "\n";

        info = info + "Pourcentage de Magie: " + this.pourcentageMag + "\n";
        info = info + "Resistence au Magie: " + this.pourcentageResistMag + "\n";
        info = info + "Damage Attaque: " + this.getDegAtt() + "\n";
        info = info + "Damage Magie: " + this.degMag + "\n";

        info = info + "Distance d'ataque: " + this.getDistAttMax() + "\n";

        return info;
    }
}
