package modele.jeu.partie.niveau.carte;


public class Sortie extends Case {

	/**
	 * S�mantique : Cr�e une Sortie (non destructible et non grimpable)
	 * Pr�conditions :
	 * Postconditions :
	 */
	public Sortie() {
		super(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.Case#toString()
	 */
	@Override
	public String toString() {
		return "@";
	}
}