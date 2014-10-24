/**
 * 
 */
package modele.jeu;

/**
 * @author Paul
 * 
 */
public class FichierInvalideException extends Exception {

	/**
	 * le serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * S�mantique : Cr�e un FichierInvalideException
	 * Pr�conditions :
	 * Postconditions :
	 * 
	 * @param message
	 */
	public FichierInvalideException(String message) {
		super(message);
	}

}
