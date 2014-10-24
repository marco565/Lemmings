/**
 * 
 */
package modele.jeu.partie.niveau;

import java.util.ArrayList;
import java.util.EventObject;

import modele.jeu.partie.niveau.carte.Carte;
import modele.jeu.partie.niveau.lemming.Lemming;

/**
 * @author Paul
 * 
 */
public class NiveauChangedEvent extends EventObject {

	private Carte carte;
	private ArrayList<Lemming> lemmings;

	/**
	 * S�mantique : Cr�e un NiveauChangedEvent
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param arg0
	 */
	public NiveauChangedEvent(Object source, Carte carte,
			ArrayList<Lemming> lemmings) {
		super(source);

		this.carte = carte;
		this.lemmings = lemmings;
	}

	/**
	 * R�cup�re le carte
	 * 
	 * @return le carte
	 */
	public Carte getCarte() {
		return this.carte;
	}

	/**
	 * R�cup�re le lemmings
	 * 
	 * @return le lemmings
	 */
	public ArrayList<Lemming> getLemmings() {
		return this.lemmings;
	}

}
