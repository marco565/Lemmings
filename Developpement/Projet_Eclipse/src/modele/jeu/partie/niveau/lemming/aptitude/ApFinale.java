package modele.jeu.partie.niveau.lemming.aptitude;

import modele.jeu.partie.niveau.carte.Carte;
import modele.jeu.partie.niveau.lemming.Lemming;

/**
 * @author Paul
 *         Cette classe permet de sp�cifier un comportement diff�rent.
 *         Tous les classes sp�cialisant celle-ci deviendront des aptitudes
 *         finales, cad qu'aucune autre aptitude, except� sp�ciale, ne pourra
 *         leur etre attribu�.
 */
public abstract class ApFinale extends ApNormale {

	/**
	 * S�mantique : Cr�e une aptitude finale
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param lemming
	 * @param carte
	 */
	public ApFinale(Lemming lemming, Carte carte) {
		super(lemming, carte);
	}
}