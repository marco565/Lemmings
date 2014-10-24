package modele.jeu.partie;

import java.io.File;
import java.util.ArrayList;

import modele.jeu.FichierInvalideException;
import modele.jeu.partie.niveau.Niveau;

public class Partie {

	private boolean finie;

	/**
	 * le niveaux
	 */
	private ArrayList<Niveau> niveaux = new ArrayList<Niveau>();

	/**
	 * le niveauCourrant
	 */
	private int niveauCourrant;

	/**
	 * S�mantique : Initiqlise une Partie
	 * Pr�conditions :
	 * Postconditions : partie initialis�e
	 */
	public Partie() {
		this.niveaux = new ArrayList<Niveau>();
		this.niveauCourrant = 0;
	}

	/**
	 * S�mantique : ajoute le niveau correspondant au fichier
	 * Pr�conditions : fichier correspondant a la semantique du niveau
	 * Postconditions : un niveau cr�e correspondant au fichier
	 * 
	 * @param fic
	 */
	public Niveau ajouterNiveau(File fichierNiveau)
			throws FichierInvalideException {
		Niveau niveau = new Niveau(fichierNiveau);
		this.niveaux.add(niveau);
		return niveau;
	}

	/**
	 * R�cup�re le finie
	 * 
	 * @return le finie
	 */
	public boolean isFinie() {
		return this.finie;
	}

	/**
	 * S�mantique : met a jour le niveau courrant
	 * Pr�conditions : au moin un niveau initialis�
	 * Postconditions : niveau courrant a jour
	 */
	public void miseAJour() {
		// if(this.niveaux.size() > 0)
		{
			this.niveaux.get(this.niveauCourrant).miseAJour();
		}
	}

	/**
	 * S�mantique : passe au niveau suivant si il y en a d'autres apres
	 * Pr�conditions : au moins un niveau initialis�
	 * Postconditions : on est pass� au niveau suivant
	 */
	public void passerAuNiveauSuivant() {
		if (this.niveauCourrant < (this.niveaux.size() - 1)) {
			this.niveauCourrant++;
		} else {
			this.finie = true;
			this.niveauCourrant = 0;
		}
	}
}