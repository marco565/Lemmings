package modele.jeu;

import java.util.ArrayList;

import modele.jeu.partie.Partie;

public class Jeu {
	/**
	 * les parties
	 */
	private ArrayList<Partie> parties = new ArrayList<Partie>();

	/**
	 * le partieCourante
	 */
	private int partieCourante;

	/**
	 * S�mantique : Cree le jeu nu
	 * paramettre
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param fic
	 */
	public Jeu() {
		this.parties = new ArrayList<Partie>();
		this.partieCourante = -1;
	}

	/**
	 * S�mantique : ajoute une partie et la d�finie comme partie courante
	 * Pr�conditions :
	 * Postconditions : la partie est ajout�
	 */
	public Partie ajouterPartie() {
		Partie partieAjoutee = new Partie();
		this.parties.add(partieAjoutee);
		this.partieCourante = this.parties.indexOf(partieAjoutee);
		return partieAjoutee;
	}

	/**
	 * S�mantique : met a jour la partie
	 * Pr�conditions : partie != null
	 * Postconditions : partie a jour
	 */
	public void miseAJour() {
		// met a jour la partie courante
		if (this.parties.size() > 0) {
			// ajouter le niveau a la partie courante
			this.parties.get(this.partieCourante).miseAJour();
		}
	}

	/**
	 * S�mantique : quitte le programme
	 * Pr�conditions :
	 * Postconditions : fin du programme
	 */
	public void quitter() {
		System.exit(0);
	}
}