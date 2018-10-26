/**
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 *
 */
package org.centrale.projet.objet;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.border.*;
import java.io.File;
import java.util.Iterator;
import javax.swing.*;

/**
 *
 * @author EsauBZ
 */
public class GUIECN extends javax.swing.JFrame {

    World monde;
    String nomFichier;
    SauvegardePartie save;
    File F;
    private JButton[][] chessBoardSquares;
    private String combat = "";

    /**
     * Creates new form GUIECN
     */
    public GUIECN() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("World of ECN");
        setPreferredSize(new java.awt.Dimension(720, 600));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jButton1.setText("Nouveau jeu");
        jButton1.setAutoscrolls(true);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Charger un jeu");
        jButton2.setAutoscrolls(true);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton2MouseReleased(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setAutoscrolls(true);
        jPanel1.setMaximumSize(new java.awt.Dimension(700, 700));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSeparator1.setAutoscrolls(true);
        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.lightGray));

        jButton4.setText("Combattre");
        jButton4.setAutoscrolls(true);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Sauvegarder Autom");
        jButton5.setAutoscrolls(true);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton6.setText("Sauvegarder Manuelle");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton7.setText("UP");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });

        jButton8.setText("RG");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton8MouseReleased(evt);
            }
        });

        jButton9.setText("LF");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton9MouseReleased(evt);
            }
        });

        jButton10.setText("DW");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton10MouseReleased(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jButton7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jButton10)))
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton9)
                            .addComponent(jButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

        informationJuoeur wn = new informationJuoeur(this, true);
        wn.setVisible(true);

        String nm = wn.getjTextField1().getText();
        String cl = wn.getjTextField2().getText();
        /* Creation du Monde WoE */
        monde = new World(nm, cl);

        this.jTextArea1.setText(monde.getListJouer().get(0).makeStringInfo());

        this.makeGrid();


    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseReleased

        chargeMonde wn = new chargeMonde(this, true);
        wn.setVisible(true);

        nomFichier = wn.getjTextField1().getText();
        ChargementPartie load = new ChargementPartie(nomFichier);
        monde = load.chargerPartie();

        this.jTextArea1.setText(monde.getListJouer().get(0).makeStringInfo());

        this.makeGrid();

    }//GEN-LAST:event_jButton2MouseReleased
    /**
     * AUTOMATIQUE *
     */
    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        if (monde != null) {
            int x = 1;
            String prefixe = "sauvegarde";
            String suffixe = ".txt";
            nomFichier = prefixe + String.valueOf(x) + suffixe;
            F = new File(nomFichier);
            while (F.exists()) {
                x++;
                nomFichier = prefixe + String.valueOf(x) + suffixe;
                F = new File(nomFichier);
            }
            save = new SauvegardePartie(nomFichier);
            save.sauvegardePartie(monde, nomFichier);
        }
    }//GEN-LAST:event_jButton5MouseReleased
    /**
     * Manuel *
     */
    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        if (monde != null) {
            SauvJeuManuel wn = new SauvJeuManuel(this, true, 1);
            wn.setVisible(true);

            nomFichier = wn.getjTextField1().getText();
            F = new File(nomFichier);
            while (F.exists()) {
                wn = new SauvJeuManuel(this, true, 2);
                wn.setVisible(true);

                nomFichier = wn.getjTextField1().getText();
                F = new File(nomFichier);
            }
            save = new SauvegardePartie(nomFichier);
            save.sauvegardePartie(monde, nomFichier);
        }
    }//GEN-LAST:event_jButton6MouseReleased

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased

        for (Joueur a : monde.getListJouer()) {

            combat = combat + "---- MODE COMBAT ---- \n";

            if (a.getPerso() instanceof Guerrier) {
                Iterator<ElementDeJeu> it = monde.getListMonstres().iterator();
                while (it.hasNext()) {
                    Monstre mt = (Monstre) it.next();
                    if (a.getPerso().getPos().distance(mt.getPos()) == 1) {

                        combat = combat + " Combat Guerrier contre " + mt.getClass() + "\n";
                        combat = combat + "Pt Vie Creature: " + mt.getPtVie() + "\n";

                        a.getPerso().combattre(mt);

                        if (mt instanceof Loup) {
                            ((Loup) mt).combattre(a.getPerso());
                        }
                        combat = combat + "Pt Vie Creature: " + mt.getPtVie() + "\n";
                    }
                }
                Iterator<ElementDeJeu> ps = monde.getListPersonnages().iterator();
                while (ps.hasNext()) {
                    Personnage pt = (Personnage) ps.next();
                    if (a.getPerso().getPos().distance(pt.getPos()) == 1) {

                        combat = combat + " Combat Guerrier contre " + pt.getClass() + "\n";
                        combat = combat + "Pt Vie Creature: " + pt.getPtVie() + "\n";

                        a.getPerso().combattre(pt);
                        if (!(pt instanceof Paysan)) {
                            pt.combattre(a.getPerso());
                        }
                        combat = combat + "Pt Vie Creature: " + pt.getPtVie() + "\n";
                    }
                }

            }
            if (a.getPerso() instanceof Archer) {
                Iterator<ElementDeJeu> it = monde.getListMonstres().iterator();
                while (it.hasNext()) {
                    Monstre mt = (Monstre) it.next();
                    if (a.getPerso().getPos().distance(mt.getPos()) > 1 && a.getPerso().getPos().distance(mt.getPos()) < a.getPerso().getDistAttMax()) {
                        Archer rr = (Archer) a.getPerso();
                        if (rr.getNbFleches() > 0) {
                            
                            combat = combat + " Combat Archer contre " + mt.getClass() + "\n";
                            combat = combat + "Pt Vie Creature: " + mt.getPtVie() + "\n";
                            a.getPerso().combattre(mt);
                        }
                        if (mt instanceof Loup) {
                            ((Loup) mt).combattre(a.getPerso());
                        }
                        combat = combat + "Pt Vie Creature: " + mt.getPtVie() + "\n";
                    }
                }
                Iterator<ElementDeJeu> ps = monde.getListPersonnages().iterator();
                while (ps.hasNext()) {
                    Personnage pt = (Personnage) ps.next();
                    if (a.getPerso().getPos().distance(pt.getPos()) >= 1 && a.getPerso().getPos().distance(pt.getPos()) < a.getPerso().getDistAttMax()) {

                        Archer rr = (Archer) a.getPerso();
                        if (rr.getNbFleches() > 0) {
                            combat = combat + " Combat Archer contre " + pt.getClass() + "\n";
                            combat = combat + "Pt Vie Creature: " + pt.getPtVie() + "\n";
                            
                            a.getPerso().combattre(pt);
                        }
                        if (!(pt instanceof Paysan)) {
                            pt.combattre(a.getPerso());
                        }
                        combat = combat + "Pt Vie Creature: " + pt.getPtVie() + "\n";
                    }
                }

            }
            if (a.getPerso() instanceof Mage) {
                Iterator<ElementDeJeu> it = monde.getListMonstres().iterator();
                while (it.hasNext()) {
                    Monstre mt = (Monstre) it.next();
                    if (a.getPerso().getPos().distance(mt.getPos()) >= 1 && a.getPerso().getPos().distance(mt.getPos()) < a.getPerso().getDistAttMax()) {
                        if (a.getPerso().getPtMana() > 0) {
                            
                            combat = combat + " Combat Mage contre " + mt.getClass() + "\n";
                            combat = combat + "Pt Vie Creature: " + mt.getPtVie() + "\n";
                            a.getPerso().combattre(mt);
                        }
                        if (mt instanceof Loup) {
                            ((Loup) mt).combattre(a.getPerso());
                        }
                         combat = combat + "Pt Vie Creature: " + mt.getPtVie() + "\n";
                    }
                }
                Iterator<ElementDeJeu> ps = monde.getListPersonnages().iterator();
                while (ps.hasNext()) {
                    Personnage pt = (Personnage) ps.next();
                    if (a.getPerso().getPos().distance(pt.getPos()) >= 1 && a.getPerso().getPos().distance(pt.getPos()) < a.getPerso().getDistAttMax()) {
                        if (a.getPerso().getPtMana() > 0) {
                           
                            combat = combat + " Combat Mage contre " + pt.getClass() + "\n";
                            combat = combat + "Pt Vie Creature: " + pt.getPtVie() + "\n";
                            a.getPerso().combattre(pt);
                        }
                        if (!(pt instanceof Paysan)) {
                            pt.combattre(a.getPerso());
                        }
                        combat = combat + "Pt Vie Creature: " + pt.getPtVie() + "\n";
                    }
                }
            }

            a.getPerso().MettreAJourDuree();
            this.RefreshMonstres();
        }

        this.jTextArea1.setText(monde.getListJouer().get(0).makeStringInfo());
        this.jTextArea2.setText(combat);
        rePaint(0);
    }//GEN-LAST:event_jButton4MouseReleased

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

    }//GEN-LAST:event_formKeyReleased

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped
    /**
     * Event pour déplacer le joueur d'une case vers le haut
     *
     * @param evt
     */
    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased
        if (this.monde != null && monde.getListJouer().get(0).getPerso().getPos().getCoordX() - 1 > 0) {
            rePaint(3);
            monde.verifierPotions(monde.getListJouer().get(0).getPerso());
            monde.verifierNorriture(monde.getListJouer().get(0).getPerso());
            monde.getListJouer().get(0).getPerso().MettreAJourDuree();

            this.jTextArea1.setText(monde.getListJouer().get(0).makeStringInfo());

        }
    }//GEN-LAST:event_jButton7MouseReleased
    /**
     * Event pour déplacer le joueur d'une case vers le bas
     *
     * @param evt
     */
    private void jButton10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseReleased
        if (this.monde != null && monde.getListJouer().get(0).getPerso().getPos().getCoordX() + 1 < 21) {
            rePaint(4);
            monde.verifierPotions(monde.getListJouer().get(0).getPerso());
            monde.verifierNorriture(monde.getListJouer().get(0).getPerso());
            monde.getListJouer().get(0).getPerso().MettreAJourDuree();

            this.jTextArea1.setText(monde.getListJouer().get(0).makeStringInfo());

        }
    }//GEN-LAST:event_jButton10MouseReleased
    /**
     * Event pour déplacer le joueur d'une case a gauche
     *
     * @param evt
     */
    private void jButton9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseReleased
        if (this.monde != null && monde.getListJouer().get(0).getPerso().getPos().getCoordY() - 1 > 0) {
            rePaint(2);
            monde.verifierPotions(monde.getListJouer().get(0).getPerso());
            monde.verifierNorriture(monde.getListJouer().get(0).getPerso());
            monde.getListJouer().get(0).getPerso().MettreAJourDuree();

            this.jTextArea1.setText(monde.getListJouer().get(0).makeStringInfo());

        }
    }//GEN-LAST:event_jButton9MouseReleased
    /**
     * Event pour déplacer le joueur d'une case a droit
     *
     * @param evt
     */
    private void jButton8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseReleased
        if (this.monde != null && monde.getListJouer().get(0).getPerso().getPos().getCoordY() + 1 < 21) {
            rePaint(1);

            monde.verifierPotions(monde.getListJouer().get(0).getPerso());
            monde.verifierNorriture(monde.getListJouer().get(0).getPerso());
            monde.getListJouer().get(0).getPerso().MettreAJourDuree();

            this.jTextArea1.setText(monde.getListJouer().get(0).makeStringInfo());

        }
    }//GEN-LAST:event_jButton8MouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables

    private void RefreshMonstres() {
        Iterator<ElementDeJeu> it = monde.getListMonstres().iterator();
        while (it.hasNext()) {
            Monstre a = (Monstre) it.next();
            if (a.getPtVie() < 0) {
                it.remove();
            }
        }
    }

    private void makeGrid() {

        this.chessBoardSquares = new JButton[monde.getTailleX()][monde.getTailleY()];
        this.jPanel1.removeAll();

        this.jPanel1.setLayout(new GridLayout(monde.getTailleY(), monde.getTailleX()));
        this.jPanel1.setBorder(new LineBorder(Color.BLACK));

        paintMonde();

        // fill the black non-pawn piece row
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {

                this.jPanel1.add(chessBoardSquares[jj][ii]);
            }
        }
        this.validate();
    }//fin

    public void paintMonde() {

        JButton b;

        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {

                b = new JButton();
                b.setBackground(Color.WHITE);

                for (ElementDeJeu a : monde.getListMonstres()) {
                    if (a.getPos().memePos(ii + 1, jj + 1)) {
                        if (a instanceof Lapin) {
                            b.setText("La");
                        } else {

                            if (a instanceof Loup) {
                                b.setText("Lp");
                            }
                        }
                    }
                }
                for (Joueur a : monde.getListJouer()) {
                    if (a.getPerso().getPos().memePos(ii + 1, jj + 1)) {
                        b.setBackground(Color.BLUE);
                        b.setText("J");
                    }
                }

                for (ElementDeJeu a : monde.getListPersonnages()) {
                    if (a.getPos().memePos(ii + 1, jj + 1)) {
                        if (a instanceof Guerrier) {
                            b.setText("G");
                        } else {

                            if (a instanceof Archer) {
                                b.setText("A");
                            } else {
                                if (a instanceof Mage) {
                                    b.setText("Mg");
                                } else {
                                    b.setText("P");
                                }
                            }
                        }
                    }
                }

                for (ElementDeJeu a : monde.getListPotions()) {
                    if (a.getPos().memePos(ii + 1, jj + 1)) {
                        if (a instanceof Soin) {
                            b.setText("Sn");
                        } else {

                            if (a instanceof Mana) {
                                b.setText("Mn");
                            }
                        }
                    }
                }
                for (ElementDeJeu a : monde.getListNuageToxique()) {
                    if (a.getPos().memePos(ii + 1, jj + 1)) {

                        b.setText("Ng");

                    }
                }

                for (ElementDeJeu a : monde.getListNourriture()) {
                    if (a.getPos().memePos(ii + 1, jj + 1)) {
                        Nourriture nt = (Nourriture) a;
                        if (nt.getType().equals("Bonus")) {
                            b.setText("BN");
                        } else {
                            b.setText("ML");
                        }

                    }
                }

                chessBoardSquares[jj][ii] = b;
            }
        }
    }

    public void rePaint(int dir) {

        monde.getListJouer().get(0).getPerso().deplacer(dir);
        this.makeGrid();
        verifieJoueur();

        this.validate();
        this.jPanel1.validate();
    }

    public void verifieJoueur() {
        if (monde.getListJouer().get(0).getPerso().getPtVie() < 0) {
            YouDie wn = new YouDie(this, true);
            wn.setVisible(true);

            this.setVisible(false);
            this.dispose();
        }
    }
}
