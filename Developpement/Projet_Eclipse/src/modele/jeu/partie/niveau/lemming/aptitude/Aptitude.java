package modele.jeu.partie.niveau.lemming.aptitude;

import modele.jeu.partie.niveau.carte.Carte;
import modele.jeu.partie.niveau.lemming.Lemming;

public abstract class Aptitude {
	/**
	 * la carte
	 */
	protected Carte carte;

	/**
	 * le lemming
	 */
	protected Lemming lemming;

	/**
	 * S�mantique : Cr�e un Aptitude
	 * Pr�conditions : carte != null, lemming != null
	 * Postconditions : initialisation aptitude
	 * 
	 * @param lemming
	 * @param carte
	 */
	public Aptitude(Lemming lemming, Carte carte) {
		// r�cupere les donn�es
		this.lemming = lemming;
		this.carte = carte;
	}

	/**
	 * S�mantique : execute l'action associ� � l'aptitude
	 * Pr�conditions : aptitude initialis�e
	 * Postconditions : action de l'aptitude
	 */
	public abstract void executer();

	public abstract TypeAptitude getType();
}