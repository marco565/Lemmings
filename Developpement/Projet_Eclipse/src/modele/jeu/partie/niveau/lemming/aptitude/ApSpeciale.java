package modele.jeu.partie.niveau.lemming.aptitude;

import modele.jeu.partie.niveau.carte.Carte;
import modele.jeu.partie.niveau.lemming.Lemming;

public abstract class ApSpeciale extends Aptitude {
	/**
	 * l'aptitude normale associ�e
	 */
	private ApNormale aptitudeNormale;

	/**
	 * S�mantique : Cr�e un ApSpeciale
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param lemming
	 * @param carte
	 */
	public ApSpeciale(Lemming lemming, Carte carte) {
		super(lemming, carte);
	}

	/** R�cup�re le aptitudeNormale
	 * @return le aptitudeNormale
	 */
	public ApNormale getAptitudeNormale() {
		return aptitudeNormale;
	}

	/** Modifie le aptitudeNormale
	 * @param aptitudeNormale le nouveau aptitudeNormale
	 */
	public void setAptitudeNormale(ApNormale aptitudeNormale) {
		this.aptitudeNormale = aptitudeNormale;
	}
}