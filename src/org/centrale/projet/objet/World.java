/**
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 *
 */
package org.centrale.projet.objet;

import java.io.File;
import java.util.*;

/**
 * La classe World qui est en charge de la creation des personnages, monstres et
 * les differents potions, la classe fait aussi le tour de jeu
 *
 * @author EsauBZ
 *
 */
public class World {

    /**
     * list de Potions *
     */
    private ArrayList<ElementDeJeu> listPotions;
    /**
     * list de Nourritures *
     */
    private ArrayList<ElementDeJeu> listNourriture;
    /**
     * list de NuageToxique *
     */
    private ArrayList<ElementDeJeu> listNuageToxique;
    /**
     * list de Personnages *
     */
    private ArrayList<ElementDeJeu> listPersonnages;
    /**
     * list de Monstres *
     */
    private ArrayList<ElementDeJeu> listMonstres;
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
     * Constructeur du monde WoE on cree les differents lists pour les
     * personnages, les monstres et les potions, ici s'appelle aussi a les
     * methodes pour la creation de Joueur et les differents elements
     */
    public World() {
        /**
         * Lists de Joueur *
         */
        this.listJouers = new ArrayList<>();
        /**
         * Lists de Personnages *
         */
        this.listPersonnages = new ArrayList<>();
        /**
         * Lists de potions *
         */
        this.listPotions = new ArrayList<>();
        /**
        * list de NuageToxique *
        */
        this.listNuageToxique = new ArrayList<>();
        /**
         * Lists de monstres *
         */
        this.listMonstres = new ArrayList<>();
        /**
         * Lists de Nourriture *
         */
        this.listNourriture = new ArrayList<>();
        /**
         * Variables taille du monde *
         */
        tailleX = 50;
        tailleY = 50;
        this.creationJoueur();
        this.creationPersonnages();
        this.creationMonstres();
        this.creationPotions();
        this.creationNourriture();
    }
    
    public World(int x, int y){
        
        /**
         * Variables taille du monde *
        */
        tailleX = x;
        tailleY = y;
        
        /**
         * Lists de personnages *
         */
        this.listJouers = new ArrayList<>();
        /**
         * Lists de potions *
         */
        this.listPotions = new ArrayList<>();
        /**
         * Lists de monstres *
         */
        this.listMonstres = new ArrayList<>();
        /**
         * Lists de Personnages *
         */
        this.listPersonnages = new ArrayList<>();
        /**
        * list de NuageToxique *
        */
        this.listNuageToxique = new ArrayList<>();
         /**
         * Lists de Nourriture *
         */
        this.listNourriture = new ArrayList<>();
        
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
     * Tour de Jeu il fait la demmande au joueur pour savoir avec un switch s'il
     * veut se deplacer, se battre ou sauvegarder le jeu
     */
    public void tourdeJeu() {
        if (listJouers != null) {
            Scanner sc = new Scanner(System.in);
            for (Joueur a : listJouers) {
                for (int i = 0; i < listNourriture.size(); i++){
                    if (a.getPerso().getPos().getCoordX() == listNourriture.get(i).getPos().getCoordX() && a.getPerso().getPos().getCoordY() == listNourriture.get(i).getPos().getCoordY()){
                        ElementDeJeu el = listNourriture.get(i);
                        Nourriture r = (Nourriture) el;
                        a.getPerso().getNourriture().add(r);
                        a.getPerso().MettreAJourCaract(r);
                        listNourriture.remove(i);
                        i--;
                    }
                }
                System.out.println("Voulez-vous faire un mouvement ou sauvegarder le jeu? - Tapez le numero correspondant");
                System.out.println("1)Deplacement 2)Battre 3)Sauvegarder");
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
                        a.getPerso().MettreAJourDuree();
                        break;
                    case 2:
                        System.out.println("************************");
                        System.out.println("---- MODE COMBAT ----");
                        if (a.getPerso() instanceof Guerrier) {
                            Iterator<ElementDeJeu> it = this.listMonstres.iterator();
                            while (it.hasNext()) {
                                Monstre mt = (Monstre) it.next();
                                if (a.getPerso().getPos().distance(mt.getPos()) == 1) {

                                    a.getPerso().combattre(mt);
                                    if(mt instanceof Loup){
                                        ((Loup) mt).combattre(a.getPerso());
                                    }
                                }
                            }
                        }
                        if (a.getPerso() instanceof Archer) {
                            Iterator<ElementDeJeu> it = this.listMonstres.iterator();
                            while (it.hasNext()) {
                                Monstre mt = (Monstre) it.next();
                                if (a.getPerso().getPos().distance(mt.getPos()) > 1 && a.getPerso().getPos().distance(mt.getPos()) < a.getPerso().getDistAttMax()) {

                                    a.getPerso().combattre(mt);
                                    if(mt instanceof Loup){
                                        ((Loup) mt).combattre(a.getPerso());
                                    }
                                }
                            }
                        }
                        if (a.getPerso() instanceof Mage) {
                            Iterator<ElementDeJeu> it = this.listMonstres.iterator();
                            while (it.hasNext()) {
                                Monstre mt = (Monstre) it.next();
                                if (a.getPerso().getPos().distance(mt.getPos()) >= 1 && a.getPerso().getPos().distance(mt.getPos()) < a.getPerso().getDistAttMax()) {

                                    a.getPerso().combattre(mt);
                                    if(mt instanceof Loup){
                                        ((Loup) mt).combattre(a.getPerso());
                                    }
                                }
                            }
                        }
                        a.getPerso().MettreAJourDuree();
                        break;
                    case 3:
                        String menuSauvegarde;
                        String nomFichier;
                        SauvegardePartie save;
                        File F;
                        System.out.println("Manu Sauvegarde :");
                        System.out.println("1) Sauvegarde Automatique ");
                        System.out.println("2) Sauvegarde Manuel \n");
                        System.out.println("Choisissez l'option de sauvegarde: ");
                        menuSauvegarde = sc.next(); 
                        
                        switch (menuSauvegarde){
                            case "1":
                                int x = 1;
                                String prefixe = "sauvegarde";
                                String suffixe = ".txt";
                                nomFichier = prefixe + String.valueOf(x) + suffixe;
                                F = new File (nomFichier);
                                while (F.exists()){
                                    x++;
                                    nomFichier = prefixe + String.valueOf(x) + suffixe;
                                    F = new File(nomFichier);
                                }
                                save = new SauvegardePartie(nomFichier);
                                save.sauvegardePartie(this, nomFichier);
                                
                                break;
                                
                            case "2": 
                                 System.out.println("Tapez le nom du fichier dans lequel vous voulez sauvegarder le jeu: ");
                                 nomFichier = sc.next();
                                 F = new File (nomFichier);
                                 while (F.exists()){
                                    System.out.println("Le nom que vous avez choisi existe deja! Veuillez choisir un autre nom: ");
                                    nomFichier = sc.next();
                                    F = new File (nomFichier);
                                 }
                                 save = new SauvegardePartie(nomFichier);
                                 save.sauvegardePartie(this, nomFichier);
                        }
                        System.out.println("Le match était sauvegardé! \n");
                        break;
                        
                    default:
                        System.out.println("Un erreur s'est passé! \n");     
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
         * Joueurs *
         */
        for (int i = 0; i < this.listPersonnages.size(); i++) {
            this.listPersonnages.get(i).affiche();
        }
        /**
         * Monstres *
         */
        for (int i = 0; i < listMonstres.size(); i++) {
            this.listMonstres.get(i).affiche();
        }
        /**
         * Potions *
         */
        for (int i = 0; i < this.listPotions.size(); i++) {
            this.listPotions.get(i).affiche();
        }
        /**
         * Nourriture *
         */
        for (int i = 0; i < this.listNourriture.size(); i++) {
            this.listNourriture.get(i).affiche();
        }
    }
    
    /**
     * Methode de creation Aleatoire des Personnages dans le monde, il cree un
     * nombre aleatoire de chaque type de personnage dans une meme liste. Les
     * coordonnes sont aleatoires.
     */
    private void creationPersonnages(){
        Random gA = new Random();
        Point2D p = new Point2D();
        int cont = gA.nextInt(20);
         /**
         * Guerrier *
         */
        Guerrier g;
        for (int i = 0; i < cont; i++) {
            if (i > 0) {
                for (int j = 0; j < listPersonnages.size(); j++) {
                    while (p.getCoordX() == listPersonnages.get(j).getPos().getCoordX() && p.getCoordY() == listPersonnages.get(j).getPos().getCoordY()) {
                        p.setCoordX(gA.nextInt(tailleX));
                        p.setCoordY(gA.nextInt(tailleY));
                    }
                }
                this.listPersonnages.add(g = new Guerrier("Warrior"+(i+1), 100 + i, gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), p, gA.nextInt(tailleX)));
            } else {
                p.setCoordX(gA.nextInt(tailleX));
                p.setCoordY(gA.nextInt(tailleY));
                this.listPersonnages.add(g = new Guerrier("Warrior"+(i+1), 100 + i, gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), p, gA.nextInt(tailleX)));
            }
        }
        
         /**
         * Mage *
         */
        cont = gA.nextInt(20);
        Mage m;
        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < listPersonnages.size(); j++) {
                while (p.getCoordX() == listPersonnages.get(j).getPos().getCoordX() && p.getCoordY() == listPersonnages.get(j).getPos().getCoordY()) {
                    p.setCoordX(gA.nextInt(tailleX));
                    p.setCoordY(gA.nextInt(tailleY));
                }
            }
            this.listPersonnages.add(m = new Mage("Wizard"+(i+1), 100 + i, gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), p, gA.nextInt(tailleX)));
        }
        
         /**
         * Paysan *
         */
        cont = gA.nextInt(20);
        Paysan pay;
        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < listPersonnages.size(); j++) {
                while (p.getCoordX() == listPersonnages.get(j).getPos().getCoordX() && p.getCoordY() == listPersonnages.get(j).getPos().getCoordY()) {
                    p.setCoordX(gA.nextInt(tailleX));
                    p.setCoordY(gA.nextInt(tailleY));
                }
            }
            this.listPersonnages.add(pay = new Paysan("Peasant"+(i+1), 100 + i, gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), p, gA.nextInt(tailleX)));
        }
        
         /**
         * Archer *
         */
        cont = gA.nextInt(20);
        Archer a;
        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < listPersonnages.size(); j++) {
                while (p.getCoordX() == listPersonnages.get(j).getPos().getCoordX() && p.getCoordY() == listPersonnages.get(j).getPos().getCoordY()) {
                    p.setCoordX(gA.nextInt(tailleX));
                    p.setCoordY(gA.nextInt(tailleY));
                }
            }
            this.listPersonnages.add(a = new Archer("Bowman"+(i+1), 100 + i, gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), p, gA.nextInt(tailleX), gA.nextInt(tailleX)));
        
        }
    }

    /**
     * Methode de creation Aleatoire des Monstres et Nuage Toxique dans le monde, il cree un
     * nombre aleatoire de chaque type de Monstre et Nuage Toxique dans une meme liste. Les
     * coordonnes et ses attributs sont aleatoires
     */
    private void creationMonstres() {
        Random gA = new Random();
        Point2D p = new Point2D();
        int cont = gA.nextInt(20);
        /**
         * Lapins *
         */
        Lapin l;
        for (int i = 0; i < cont; i++) {
            if (i > 0) {
                for (int j = 0; j < listMonstres.size(); j++) {
                    while (p.getCoordX() == listMonstres.get(j).getPos().getCoordX() && p.getCoordY() == listMonstres.get(j).getPos().getCoordY()) {
                        p.setCoordX(gA.nextInt(tailleX));
                        p.setCoordY(gA.nextInt(tailleY));
                    }
                }
                this.listMonstres.add(l = new Lapin(100 + i, gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), p, gA.nextInt(tailleX)));
            } else {
                p.setCoordX(gA.nextInt(tailleX));
                p.setCoordY(gA.nextInt(tailleY));
                this.listMonstres.add(l = new Lapin(100 + i, gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), p, gA.nextInt(tailleX)));
            }
        }
        
        /**
         * Loups *
         */
        cont = gA.nextInt(20);
        Loup lp;
        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < listMonstres.size(); j++) {
                while (p.getCoordX() == listMonstres.get(j).getPos().getCoordX() && p.getCoordY() == listMonstres.get(j).getPos().getCoordY()) {
                    p.setCoordX(gA.nextInt(tailleX));
                    p.setCoordY(gA.nextInt(tailleY));
                }
            }
            this.listMonstres.add(lp = new Loup(100 + i, gA.nextInt(tailleX), gA.nextInt(tailleX), gA.nextInt(tailleX), p, gA.nextInt(tailleX)));
        }
        
        /**
         * Nuages *
         */
        cont = gA.nextInt(20);
        NuageToxique nt;
        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < listNuageToxique.size(); j++) {
                while (p.getCoordX() == listNuageToxique.get(j).getPos().getCoordX() && p.getCoordY() == listNuageToxique.get(j).getPos().getCoordY()) {
                    p.setCoordX(gA.nextInt(tailleX));
                    p.setCoordY(gA.nextInt(tailleY));
                }
            }
            this.listNuageToxique.add(nt = new NuageToxique(p, gA.nextInt(tailleX)));
        }
    }

    /**
     * Methode de creation Aleatoire des Potions dans le monde, il cree un
     * nombre aleatoire de chaque type de potion dans une meme liste. Les
     * coordonnes sont aleatoires.
     */
    private void creationPotions() {
        Random gA = new Random();
        Point2D p = new Point2D();
        int cont = gA.nextInt(10);
        /**
         * Potions Soin *
         */
        Soin sp;
        for (int i = 0; i < cont; i++) {
            if (i > 0) {
                for (int j = 0; j < listPotions.size(); j++) {
                    while (p.getCoordX() == listPotions.get(j).getPos().getCoordX() && p.getCoordY() == listPotions.get(j).getPos().getCoordY()) {
                        p.setCoordX(gA.nextInt(tailleX));
                        p.setCoordY(gA.nextInt(tailleY));
                    }
                }
                this.listPotions.add(sp = new Soin(p, gA.nextInt(tailleY)));
            } else {
                p.setCoordX(gA.nextInt(tailleX));
                p.setCoordY(gA.nextInt(tailleY));
                this.listPotions.add(sp = new Soin(p, gA.nextInt(tailleY)));
            }

        }
        
        /**
         * Potions Mana *
         */
        cont = gA.nextInt(10);
        Mana mp;
        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < listPotions.size(); j++) {
                while (p.getCoordX() == listPotions.get(j).getPos().getCoordX() && p.getCoordY() == listPotions.get(j).getPos().getCoordY()) {
                    p.setCoordX(gA.nextInt(tailleX));
                    p.setCoordY(gA.nextInt(tailleY));
                }
            }
            this.listPotions.add(mp = new Mana(p, gA.nextInt(tailleY)));
        }
    }
    
    /**
     * Methode de creation Aleatoire des Nourriture dans le monde, il cree un
     * nombre aleatoire de differents types de nourriture dans une meme liste. Les
     * coordonnes sont aleatoires.
     */
    private void creationNourriture() {
        Random gA = new Random();
        Point2D p = new Point2D();
        int cont = gA.nextInt(20);
        String[] caract = new String[7];
        caract[0] = "pA";
        caract[1] = "pP";
        caract[2] = "pM";
        caract[3] = "rM";
        caract[4] = "dA";
        caract[5] = "dM";
        caract[6] = "distMax";
        
        /**
         * Bonus *
         */
        Nourriture nb;
        for (int i = 0; i < cont; i++) {
            if (i > 0) {
                for (int j = 0; j < listNourriture.size(); j++) {
                    while (p.getCoordX() == listNourriture.get(j).getPos().getCoordX() && p.getCoordY() == listNourriture.get(j).getPos().getCoordY()) {
                        p.setCoordX(gA.nextInt(tailleX));
                        p.setCoordY(gA.nextInt(tailleY));
                    }
                }
                
                this.listNourriture.add(nb = new Nourriture("Bonus", caract[gA.nextInt(7)], gA.nextInt(5) + 1, gA.nextInt(10), p));
            } else {
                p.setCoordX(gA.nextInt(tailleX));
                p.setCoordY(gA.nextInt(tailleY));
                this.listNourriture.add(nb = new Nourriture("Bonus", caract[gA.nextInt(7)], gA.nextInt(5) + 1, gA.nextInt(10), p));
            }
        }
        
        /**
         * Malus *
         */
        cont = gA.nextInt(20);
        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < listNourriture.size(); j++) {
                while (p.getCoordX() == listNourriture.get(j).getPos().getCoordX() && p.getCoordY() == listNourriture.get(j).getPos().getCoordY()) {
                    p.setCoordX(gA.nextInt(tailleX));
                    p.setCoordY(gA.nextInt(tailleY));
                }
            }
            this.listNourriture.add(nb = new Nourriture("Malus", caract[gA.nextInt(7)], gA.nextInt(5) + 1, gA.nextInt(10), p));
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
     *
     * @return La liste de Potions dans le monde
     */
    public ArrayList<ElementDeJeu> getListPotions() {
        return listPotions;
    }
    
    /**
     *
     * @return La liste de NuageToxique dans le monde
     */
    public ArrayList<ElementDeJeu> getListNuageToxique() {
        return listNuageToxique;
    }
    
    /**
     *
     * @return La liste de Potions dans le monde
     */
    public ArrayList<ElementDeJeu> getListMonstres() {
        return listMonstres;
    }
    
    /**
     *
     * @return La liste de Personnages non controlés par humains dans le monde
     */
    public ArrayList<ElementDeJeu> getListPersonnages() {
        return listPersonnages;
    }
    
    /**
     *
     * @return La liste de Nourriture presentes dans le monde
     */
    public ArrayList<ElementDeJeu> getListNourriture() {
        return listNourriture;
    }
    
    /**
     * Methode de creation d'un Joueur qui est ajouté a la liste.
     */
    public void creationJoueur() {
        Joueur p1 = new Joueur();
        listJouers.add(p1);
    }
    
    /**
     * getter de la tailleX du monde
     * @return tailleX
     */
    public int getTailleX(){
        return this.tailleX;
    }
    
    /**
     * getter de la tailleY du monde
     * @return tailleY
     */
    public int getTailleY(){
        return this.tailleY;
    }

    /**
     * Méthode qui verifie les differents potions (Mana et soins) avec la
     * position du personnage, s'il est dans la meme position il prends les
     * points de la potion et apres l'objet est enleve de la liste.
     *
     * @param p On verifie si ce personnage est dans la potition d'un potion.
     */
    public void verifierPotions(Personnage p) {
        Iterator<ElementDeJeu> it = this.listPotions.iterator();
        while (it.hasNext()) {
            ElementDeJeu i = it.next();
            if (i instanceof Soin && i.getPos().memePos(p.getPos())) {
                Soin n = (Soin) i;
                p.setPtVie(p.getPtVie() + n.getPointPotion());
                it.remove();
            }

            if (it instanceof Mana && i.getPos().memePos(p.getPos())) {
                Mana m = (Mana) i;
                p.setPtMana(p.getPtMana() + m.getPointPotion());
                it.remove();
            }
        }

    }

}
