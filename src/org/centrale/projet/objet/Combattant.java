/**
 * Ecole Centrale de Nantes
 * Option Informatique
 * Programation Oriente a Object
 *
 */
package org.centrale.projet.objet;

/**
 * Interface héritée par les différents personnages pour appliquer la méthode de
 * combat de différentes manières. (Distance et corps à corps)
 *
 * @author EsauBZ
 */
public interface Combattant {

    public void combattre(Creature cr);
}
