package modele.jeu.partie.niveau.carte;


public class Trappe extends Case {
	/**
	 * S�mantique : Cr�e une Trappe (non destructible, et non grimpable)
	 * Pr�conditions :
	 * Postconditions :
	 */
	public Trappe() {
		super(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.Case#toString()
	 */
	@Override
	public String toString() {
		return "0";
	}
}