/**
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 *
 */
package org.centrale.projet.objet;

import java.util.*;

/**
 *
 * @author EsauBZ
 *
 */
public class World {

    /**
     * list de ElementsJeu (Monstres et Potions) *
     */
    private ArrayList<ElementDeJeu> listElmentsJeu;
    /**
     * lists de personnages *
     */
    private ArrayList<Joueur> listJouers;
    /**
     * taille du monde
     */
    int tailleX;
    int tailleY;

    /**
     * Constructeur du monde Woe on cree les differents lists pour les
     * differents personnages et on appelle le methode ou 100 personnages sont
     * cree dans les differents lists
     */
    public World() {
        /**
         * Lists de personnages *
         */
        this.listJouers = new ArrayList<>();
        /**
         * Lists de potions *
         */
        this.listElmentsJeu = new ArrayList<>();
        /**
         * Variables taille du monde *
         */
        tailleX = 50;
        tailleY = 50;
        this.creationJoueur();
        this.creationElementsDeJeu();
    }

    /**
     * Ce methode done une position aleatoire a les diferents Joueurs les
     * personnages ne peut pas avoir la meme position donc il change la position
     * des personnages jusqu'a le moment sa position et different des autres
     * personnages.
     */
    public void creeMondeAlea() {

        Random generateurAleatoire = new Random();
        Point2D p = new Point2D();

        /*CHANGER POSITION DU PREMIER PERSONNAGE*/
        p.setCoordX(generateurAleatoire.nextInt(tailleX));
        p.setCoordY(generateurAleatoire.nextInt(tailleY));
        listJouers.get(0).getPerso().getPos().setCoordX(p.getCoordX());
        listJouers.get(0).getPerso().getPos().setCoordY(p.getCoordY());

        for (int i = 1; i < listJouers.size(); i++) {
            //On change les coordonnes  

            listJouers.get(i).getPerso().getPos().setCoordX(p.getCoordX());
            listJouers.get(i).getPerso().getPos().setCoordY(p.getCoordY());
        }
    }

    /**
     * Tour de Jeu il fait un decision pour le joueur, se deplace o se battre
     * avec un monstre
     */
    public void tourdeJeu() {
        if (listJouers != null) {
            Scanner sc = new Scanner(System.in);
            for (Joueur a : listJouers) {
                System.out.println("Voulez-vous faire un mouvement ou se battre?");
                System.out.println("1)Deplacement 2)Battre");
                int i = 0;
                try {
                    i = Integer.parseInt(sc.next());
                } catch (NumberFormatException e) {
                    System.out.println("vous avez écrit une option incorrecte");
                    throw e;
                }
                switch (i) {
                    case 1:
                        a.getPerso().deplacer();
                        verifierPotions(a.getPerso());
                        break;
                    case 2:
                        //a.getPerso().combattre();
                        break;
                }

            }
        }
    }

    /**
     * Affiche de tout le monde
     *
     * ce methode affiche l'ensembre des personnages qui sont dans les
     * differents lists il fait un boucle de chaque type et affiche les details
     * de tous les personnages.
     */
    public void afficheWorld() {
        /**
         * Joueurs *
         */
        for (int i = 0; i < this.listJouers.size(); i++) {
            this.listJouers.get(i).getPerso().affiche();
        }
        /**
         * ElementesDeJeu *
         */
        for (int i = 0; i < listElmentsJeu.size(); i++) {
            this.listElmentsJeu.get(i).affiche();
        }
    }

    /**
     * methode de creation Aleatoire des Monstres dans le monde il cree un
     * nombre aleatoire de chaque type de Monstre dans une meme liste. Les
     * coordonnes son aleatoires.
     */
    private void creationElementsDeJeu() {
        Random gA = new Random();
        Point2D p = new Point2D();
        /**
         * Lapins *
         */
        Lapin l;
        for (int i = 0; i < 20; i++) {
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    while (p.getCoordX() == listElmentsJeu.get(j).getPos().getCoordX() && p.getCoordY() == listElmentsJeu.get(j).getPos().getCoordY()) {
                        p.setCoordX(gA.nextInt(tailleX));
                        p.setCoordY(gA.nextInt(tailleY));
                    }
                }
                this.listElmentsJeu.add(l = new Lapin(100 + i, 10, 10, 10, p, 10));
            } else {
                p.setCoordX(gA.nextInt(tailleX));
                p.setCoordY(gA.nextInt(tailleY));
                this.listElmentsJeu.add(l = new Lapin(100 + i, 10, 10, 10, p, 10));
            }
        }
        /**
         * Loups *
         */
        Loup lp;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < listElmentsJeu.size(); j++) {
                while (p.getCoordX() == listElmentsJeu.get(j).getPos().getCoordX() && p.getCoordY() == listElmentsJeu.get(j).getPos().getCoordY()) {
                    p.setCoordX(gA.nextInt(tailleX));
                    p.setCoordY(gA.nextInt(tailleY));
                }
            }
            this.listElmentsJeu.add(lp = new Loup(100 + i, 10, 10, 10, p, 10));
        }
        /**
         * Potions Soin *
         */
        Soin sp;
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < listElmentsJeu.size(); j++) {
                while (p.getCoordX() == listElmentsJeu.get(j).getPos().getCoordX() && p.getCoordY() == listElmentsJeu.get(j).getPos().getCoordY()) {
                    p.setCoordX(gA.nextInt(tailleX));
                    p.setCoordY(gA.nextInt(tailleY));
                }
            }
            this.listElmentsJeu.add(sp = new Soin(p));

        }
        this.listElmentsJeu.add(sp = new Soin(this.listJouers.get(0).getPerso().getPos().getCoordX() + 2, this.listJouers.get(0).getPerso().getPos().getCoordY()));

        /**
         * Potions Mana *
         */
        Mana mp;
        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < listElmentsJeu.size(); j++) {
                while (p.getCoordX() == listElmentsJeu.get(j).getPos().getCoordX() && p.getCoordY() == listElmentsJeu.get(j).getPos().getCoordY()) {
                    p.setCoordX(gA.nextInt(tailleX));
                    p.setCoordY(gA.nextInt(tailleY));
                }
            }
            this.listElmentsJeu.add(mp = new Mana(p));

        }
    }

    /**
     * methode pour calculer le barycentre qui utilise la taille
     *
     * @return une variable long qui represent le temps en ns qui prends pour
     * calculer le barycentre
     */
    public long barycentrePersonnagesTaille() {
        long debutN = System.nanoTime();
        int centroidX = 0;
        int centroidY = 0;

        for (int i = 0; i < listJouers.size(); i++) {
            centroidX += listJouers.get(i).getPerso().getPos().getCoordX();
            centroidY += listJouers.get(i).getPerso().getPos().getCoordY();
        }
        Point2D centre = new Point2D(centroidX / listJouers.size(), centroidY / listJouers.size());
        long finN = System.nanoTime();

        return (finN - debutN);
    }

    /**
     * methode pour calculer le barycentre qui utilise un iterateur
     *
     * @return une variable long qui represent le temps en ns qui prends pour
     * calculer le barycentre
     */
    public long barycentrePersonnagesIt() {
        long debutN = System.nanoTime();

        Iterator<Joueur> it = listJouers.iterator();
        Archer n;

        int centroidX = 0;
        int centroidY = 0;

        while (it.hasNext()) {
            centroidX = it.next().getPerso().getPos().getCoordX();
            centroidY += it.next().getPerso().getPos().getCoordY();
        }
        Point2D centre = new Point2D(centroidX / listJouers.size(), centroidY / listJouers.size());
        long finN = System.nanoTime();
        return (finN - debutN);
    }

    /**
     *
     * @return La liste de Joueurs dans le monde
     */
    public ArrayList<Joueur> getListJouer() {
        return listJouers;
    }

    /**
     * Methode de creation d'un Joueur qui est ajouté a la liste.
     */
    public void creationJoueur() {
        Joueur p1 = new Joueur();
        listJouers.add(p1);
    }

    /**
     * Méthode qui verifie les differents potions (Mana et soins) avec la
     * position du personnage, s'il est dans la meme position il prends les
     * points de la potion et apres l'objet est enleve de la liste.
     *
     * @param p On verifie si ce personnage est dans la potition d'un potion.
     */
    public void verifierPotions(Personnage p) {
        Iterator<ElementDeJeu> it = this.listElmentsJeu.iterator();
        while (it.hasNext()) {
            ElementDeJeu i = it.next();
            if (i instanceof Soin && i.getPos().memePos(p.getPos())) {
                p.setPtVie(p.getPtVie() + 25);
                it.remove();
            }

            if (it instanceof Mana && i.getPos().memePos(p.getPos())) {
                p.setPtMana(p.getPtMana() + 25);
                it.remove();
            }
        }

    }

}
