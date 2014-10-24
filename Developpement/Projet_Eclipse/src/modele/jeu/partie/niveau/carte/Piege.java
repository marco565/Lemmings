package modele.jeu.partie.niveau.carte;


public class Piege extends Case {
	/**
	 * le type du piege
	 */
	private TypePiege type;

	/**
	 * S�mantique : Cr�e un Piege de type type
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param type
	 *            le type du piege
	 */
	public Piege(TypePiege type) {
		super();
		this.type = type;
	}

	/**
	 * S�mantique : Renvoie le type du piege
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @return le type du piege
	 */
	public TypePiege getType() {
		return this.type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.Case#toString()
	 */
	@Override
	public String toString() {
		switch (this.type) {
			case BROYEUR:
				return "%";
			case LANCE_FLAMME:
				return "!";
			default:
				return "?";
		}
	}

}