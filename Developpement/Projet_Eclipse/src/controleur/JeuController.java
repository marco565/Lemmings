/**
 * 
 */
package controleur;

import modele.jeu.FichierInvalideException;
import modele.jeu.Jeu;
import vue.swing.jeu.JFrameJeuView;

/**
 * @author Paul
 *         Cette classe est le controleur du jeu.
 *         Elle gere l'affichage des diff�rentes parties, et les actions
 *         associ�es.
 *         **Pour l'instant il n'y a pas d'IHM, donc cette classe est l� pour de
 *         futurs �volutions
 */
public class JeuController {

	private Jeu jeu;

	/**
	 * le fichier du niveau
	 */
	private String fichier;

	/**
	 * le controleur de Partie
	 */
	private PartieController controleurPartie;

	/**
	 * le fenetre o� afficher
	 */
	private JFrameJeuView fenetre;

	/**
	 * S�mantique : Cr�e un ControleurJeuLemmings, qui initialisera le jeu et
	 * ses param�tres.
	 * Pr�conditions :
	 * Postconditions :
	 */
	public JeuController(String fichier) throws FichierInvalideException {
		this.jeu = new Jeu(); // le jeu
		this.fenetre = new JFrameJeuView(this); // la fenetre
		this.fichier = fichier;
	}

	/**
	 * S�mantique : Fermer la fenetre
	 * Pr�conditions :
	 * Postconditions :
	 */
	private void closeViews() {
		this.fenetre.close();
	}

	/**
	 * S�mantique : Lance le jeu, m�thode a appeler pour lancer le jeu des
	 * lemmings
	 * Pr�conditions :
	 * Postconditions :
	 */
	public void lancerJeu() {
		// normalement on affiche l'ihm du jeu
		this.notifyChoixPartie();
		this.closeViews();
	}

	/**
	 * S�mantique : Changer la partie selectionn�e
	 * Pr�conditions :
	 * Postconditions :
	 */
	public void notifyChoixPartie() {
		// on cree le controleur de la partie
		this.controleurPartie = new PartieController(this.jeu.ajouterPartie(),
				this.fenetre); // le controleur de la partie
		// On l'affiche
		this.controleurPartie.displayView();
		// on lance la partie
		this.controleurPartie.lancerPartie(this.fichier);
	}

	/**
	 * S�mantique : Quitte le jeu en cours
	 * Pr�conditions :
	 * Postconditions :
	 */
	public void quitter() {
		this.jeu.quitter();
	}
}
